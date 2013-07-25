package ru.saa.test.mockito;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.vm.RequestFactorySource;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import ru.saa.part.springrf.shared.proxy.EmployeeProxy;
import ru.saa.part.springrf.shared.services.ExpensesRequestFactory;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 21.12.12
 * Time: 17:23
 * To change this template use File | Settings | File Templates.
 */
public class MockitoIntro {

    private static final String URL_TO_GWT_SERVLET = "http://localhost:8888/gwtRequest";
    //Is server have to be running ??


    @Test
    public void withArguments() {
        Comparable c = mock(Comparable.class);
        when(c.compareTo("Test")).thenReturn(1);
        assertEquals(1, c.compareTo("Test"));
    }


    @Test
    public void testRequestFactory() {

        ExpensesRequestFactory factory = RequestFactorySource.create(ExpensesRequestFactory.class);
        factory.initialize(new SimpleEventBus(), new HttpPostTransport(URL_TO_GWT_SERVLET));

        Long employeeId = 3L;

        Receiver receiver = mock(Receiver.class);
        factory.employeeRequest().findEmployee(employeeId).fire(receiver);


        ArgumentCaptor<EmployeeProxy> captor = ArgumentCaptor.forClass(EmployeeProxy.class);
        verify(receiver).onSuccess(captor.capture());

//        ArgumentCaptor<ServerFailure> error = ArgumentCaptor.forClass(ServerFailure.class);
//        verify(receiver).onFailure(error.capture());

        EmployeeProxy found = captor.getValue();


        assertEquals(employeeId, found.getId());


    }

}
