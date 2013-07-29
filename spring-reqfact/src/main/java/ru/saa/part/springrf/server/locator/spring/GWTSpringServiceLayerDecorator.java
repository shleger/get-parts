package ru.saa.part.springrf.server.locator.spring;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.server.ServiceLayerDecorator;
import com.google.web.bindery.requestfactory.shared.Locator;

public class GWTSpringServiceLayerDecorator extends ServiceLayerDecorator
        implements ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public <T extends Locator<?, ?>> T createLocator(Class<T> clazz) {

        HttpServletRequest request = RequestFactoryServlet
                .getThreadLocalRequest();
        ApplicationContext context = WebApplicationContextUtils
                .getWebApplicationContext(request.getSession()
                        .getServletContext());

        return context.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext arg0)
            throws BeansException {
        // TODO Auto-generated method stub
        this.context = arg0;
    }

    @Override
    public Object invoke(Method domainMethod, Object... args) {
        Object response = super.invoke(domainMethod, args);
        try {
            if (response instanceof Callable) {
                return ((Callable<?>) response).call();
            } else {
                return response;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
