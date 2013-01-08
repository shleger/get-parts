package ru.saa.parts.gwt.shared.command;

import com.gwtplatform.dispatch.shared.Result;

/**
 * Created with IntelliJ IDEA.
 * User: saa
 * Date: 1/8/13
 * Time: 04:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class SendTextResponse implements Result {

    private String res;

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
