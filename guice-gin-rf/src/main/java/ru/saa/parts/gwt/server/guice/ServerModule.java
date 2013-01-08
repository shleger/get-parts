package ru.saa.parts.gwt.server.guice;

import com.gwtplatform.dispatch.server.guice.HandlerModule;
import ru.saa.parts.gwt.shared.command.SendTextRequest;

/**
 * Created with IntelliJ IDEA.
 * User: saa
 * Date: 1/8/13
 * Time: 04:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class ServerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
        bindHandler(SendTextRequest.class, SendTextHandler.class);
    }
}
