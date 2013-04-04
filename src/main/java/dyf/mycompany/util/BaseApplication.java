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

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.i18n.LocaleContextHolder;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;

/**
 * The BaseApplication class to extend.
 */
public abstract class BaseApplication extends Application implements HttpServletRequestListener {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * @see com.vaadin.Application#getLocale()
     */
    @Override
    public Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }

    /**
     * @see com.vaadin.Application#setLocale(java.util.Locale)
     */
    @Override
    public void setLocale(Locale locale) {
        LocaleContextHolder.setLocale(locale);
    }

    /**
     * @see com.vaadin.terminal.gwt.server.HttpServletRequestListener#onRequestStart(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void onRequestStart(HttpServletRequest request, HttpServletResponse response) {
        ApplicationHolder.setApplication(this);
        requestStart(request, response);
    }

    /**
     * @see com.vaadin.terminal.gwt.server.HttpServletRequestListener#onRequestEnd(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void onRequestEnd(HttpServletRequest request, HttpServletResponse response) {
        try {
            requestEnd(request, response);
        } finally {
            ApplicationHolder.resetApplication();
        }
    }

    /**
     * Request end.
     *
     * @param request the request
     * @param response the response
     */
    public void requestEnd(HttpServletRequest request, HttpServletResponse response) {
    }

    /**
     * Request start.
     *
     * @param request the request
     * @param response the response
     */
    public void requestStart(HttpServletRequest request, HttpServletResponse response) {
    }

}
