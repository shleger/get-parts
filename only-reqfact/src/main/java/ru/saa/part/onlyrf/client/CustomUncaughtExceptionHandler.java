package ru.saa.part.onlyrf.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.web.bindery.event.shared.UmbrellaException;

/**
 * Created with IntelliJ IDEA.
 * User: saa
 * Date: 8/13/13
 * Time: 01:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomUncaughtExceptionHandler implements GWT.UncaughtExceptionHandler {

    @Override
    public void onUncaughtException( Throwable e ) {
        // Get rid of UmbrellaException
        Throwable exceptionToDisplay = getExceptionToDisplay( e );
        // Replace with your favorite message dialog, e.g. GXT's MessageBox
        Window.alert(exceptionToDisplay.getMessage());
    }

    private static Throwable getExceptionToDisplay( Throwable throwable ) {
        Throwable result = throwable;
        if (throwable instanceof UmbrellaException && ((UmbrellaException) throwable).getCauses().size() == 1) {
            result = ((UmbrellaException) throwable).getCauses().iterator().next();
        }
        return result;
    }
}