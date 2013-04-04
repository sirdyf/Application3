/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package dyf.mycompany.util;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;

/**
 * The Class SpringApplicationServlet.
 */
public class SpringApplicationServlet extends AbstractApplicationServlet {

    /** The Constant serialVersionUID. */
    private static final long            serialVersionUID = 1L;

    /** The application context. */
    private WebApplicationContext        applicationContext;

    /** The application class. */
    private Class<? extends Application> applicationClass;

    /** The application bean. */
    private String                       applicationBean;

    /** The locale resolver. */
    private LocaleResolver               localeResolver;

    /**
     * @see com.vaadin.terminal.gwt.server.AbstractApplicationServlet#init(javax.servlet.ServletConfig)
     */
    @SuppressWarnings("unchecked")
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        applicationBean = servletConfig.getInitParameter("applicationBean");
        if (applicationBean == null) {
            throw new ServletException("ApplicationBean not specified in servlet parameters");
        }
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
        applicationClass = (Class<? extends Application>) applicationContext.getType(applicationBean);
        initLocaleResolver(applicationContext);
    }

    /**
     * Inits the locale resolver.
     *
     * @param context the context
     */
    private void initLocaleResolver(ApplicationContext context) {
        try {
            this.localeResolver = (LocaleResolver) context.getBean(DispatcherServlet.LOCALE_RESOLVER_BEAN_NAME, LocaleResolver.class);
        } catch (NoSuchBeanDefinitionException ex) {
            this.localeResolver = new SessionLocaleResolver();
        }
    }

    /**
     * @see com.vaadin.terminal.gwt.server.AbstractApplicationServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
        IOException {
        final Locale locale = localeResolver.resolveLocale(request);
        LocaleContextHolder.setLocale(locale);
        ServletRequestAttributes requestAttributes = new ServletRequestAttributes(request);
        RequestContextHolder.setRequestAttributes(requestAttributes);
        try {
            super.service(new HttpServletRequestWrapper(request) {
                @Override
                public Locale getLocale() {
                    return locale;
                }
            }, response);
        } finally {
            if (!locale.equals(LocaleContextHolder.getLocale())) {
                localeResolver.setLocale(request, response, LocaleContextHolder.getLocale());
            }
            LocaleContextHolder.resetLocaleContext();
            RequestContextHolder.resetRequestAttributes();
        }
    }

    /**
     * @see com.vaadin.terminal.gwt.server.AbstractApplicationServlet#getNewApplication(javax.servlet.http.HttpServletRequest)
     */
    @Override
    protected Application getNewApplication(HttpServletRequest request) throws ServletException {
        return (Application) applicationContext.getBean(applicationBean);
    }

    /**
     * @see com.vaadin.terminal.gwt.server.AbstractApplicationServlet#getApplicationClass()
     */
    @Override
    protected Class<? extends Application> getApplicationClass() throws ClassNotFoundException {
        return applicationClass;
    }

}
