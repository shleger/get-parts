package ru.saa.part.springrf.server.locator.spring;

import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ServletWrappingController;

public class CustomServletWrappingController extends ServletWrappingController {
    private Class servletClass;
    private String servletName;
    private Properties initParameters = new Properties();
    private String beanName;
    private Servlet servletInstance;
    /**
     * Set the class of the servlet to wrap. Needs to implement
     * <code>javax.servlet.Servlet</code>.
     *
     * @see javax.servlet.Servlet
     */
    public void setServletClass(Class servletClass) {
        this.servletClass = servletClass;
    }
    /**
     * Set the name of the servlet to wrap. Default is the bean name of this
     * controller.
     */
    public void setServletName(String servletName) {
        this.servletName = servletName;
    }
    /**
     * Specify init parameters for the servlet to wrap, as name-value pairs.
     */
    public void setInitParameters(Properties initParameters) {
        this.initParameters = initParameters;
    }
    public void setBeanName(String name) {
        this.beanName = name;
    }
    /**
     * Overriden to implement our hack. It initializes the wrapped Servlet
     * instance.
     *
     * @author jatinder-singh
     * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig)
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        if (this.servletClass == null) {
            throw new IllegalArgumentException("servletClass is required");
        }
        if (!Servlet.class.isAssignableFrom(this.servletClass)) {
            throw new IllegalArgumentException("servletClass ["
                    + this.servletClass.getName()
                    + "] needs to implement interface [javax.servlet.Servlet]");
        }
        if (this.servletName == null) {
            this.servletName = this.beanName;
        }
        // We retrieve RF instance instead of using the one defined in
        // singhsolution-servlet.xml
        // Author: Jatinder Singh
        this.servletInstance = (Servlet) this.getApplicationContext().getBean(
                "requestFactoryServlet");
        this.servletInstance.init(new DelegatingServletConfig());
    }
    /**
     * Invoke the the wrapped Servlet instance.
     *
     * @see javax.servlet.Servlet#service(javax.servlet.ServletRequest,
     *      javax.servlet.ServletResponse)
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        this.servletInstance.service(request, response);
        return null;
    }
    /**
     * Destroy the wrapped Servlet instance.
     *
     * @see javax.servlet.Servlet#destroy()
     */
    public void destroy() {
        this.servletInstance.destroy();
    }
    /**
     * Internal implementation of the ServletConfig interface, to be passed to
     * the wrapped servlet. Delegates to ServletWrappingController fields and
     * methods to provide init parameters and other environment info.
     */
    private class DelegatingServletConfig implements ServletConfig {
        public String getServletName() {
            return servletName;
        }
        public ServletContext getServletContext() {
            return CustomServletWrappingController.this.getServletContext();
        }
        public String getInitParameter(String paramName) {
            return initParameters.getProperty(paramName);
        }
        public Enumeration getInitParameterNames() {
            return initParameters.keys();
        }
    }
}
