package ru.saa.parts.gwt.shared.command;

import com.gwtplatform.dispatch.shared.UnsecuredActionImpl;

/**
 * Created with IntelliJ IDEA.
 * User: saa
 * Date: 1/8/13
 * Time: 04:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class SendTextRequest  extends UnsecuredActionImpl<SendTextResponce>{

    private String req;

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }
}
