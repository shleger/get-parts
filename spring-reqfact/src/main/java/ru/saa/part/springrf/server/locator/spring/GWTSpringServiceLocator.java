package ru.saa.part.springrf.server.locator.spring;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class GWTSpringServiceLocator implements ServiceLocator,
        ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public Object getInstance(Class<?> arg0) {
        ApplicationContext ctx = WebApplicationContextUtils
                .getWebApplicationContext(RequestFactoryServlet
                        .getThreadLocalServletContext());
        return ctx.getBean(arg0);
    }

    public void setApplicationContext(ApplicationContext context)
            throws BeansException {
        this.context = context;
    }
}
