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

import com.vaadin.Application;

/**
 * The Class ApplicationHolder.
 */
public class ApplicationHolder {

    /** The app. */
    private static ThreadLocal<Application> app = new ThreadLocal<Application>();

    /**
     * Sets the application.
     *
     * @param application the new application
     */
    public static void setApplication(Application application) {
        app.set(application);
    }

    /**
     * Reset application.
     */
    public static void resetApplication() {
        app.remove();
    }

    /**
     * Gets the application.
     *
     * @return the application
     */
    public static Application getApplication() {
        return app.get();
    }
}
