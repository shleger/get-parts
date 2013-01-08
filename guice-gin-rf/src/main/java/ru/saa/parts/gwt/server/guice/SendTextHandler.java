package ru.saa.parts.gwt.server.guice;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.dispatch.server.ExecutionContext;
import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;
import ru.saa.parts.gwt.shared.command.SendTextRequest;
import ru.saa.parts.gwt.shared.command.SendTextResponce;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: saa
 * Date: 1/8/13
 * Time: 04:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class SendTextHandler implements ActionHandler<SendTextRequest, SendTextResponce> {

    private Provider<HttpServletRequest> requestProvider;
    private ServletContext servletContext;

    @Inject
    public SendTextHandler(Provider<HttpServletRequest> requestProvider, ServletContext servletContext) {
        this.requestProvider = requestProvider;
        this.servletContext = servletContext;
    }

    @Override
    public SendTextResponce execute(SendTextRequest action, ExecutionContext context) throws ActionException {

        String req = action.getReq();

        SendTextResponce sendTextResponce = new SendTextResponce();
        sendTextResponce.setRes(req);
        return sendTextResponce;
    }

    @Override
    public Class<SendTextRequest> getActionType() {
        return SendTextRequest.class;
    }

    @Override
    public void undo(SendTextRequest sendTextRequest, SendTextResponce sendTextResponce, ExecutionContext executionContext) throws ActionException {
        // not undoable
    }
}
