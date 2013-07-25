package ru.saa.parts.gwt.server.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Test;
import ru.saa.parts.gwt.server.dao.ExamplePersistedClassDao;
import ru.saa.parts.gwt.server.domain.ExamplePersistedClass;

/**
 * $Revision:  $
 * $Author: shleger $
 * $Date: 25.07.13 14:33  $
 */
public class DbModuleTest {

    @Test
    public void testConfigure() throws Exception {

        Injector injector = Guice.createInjector(new DbModule());
        ExamplePersistedClassDao examplePersistedClassDao = injector.getInstance(ExamplePersistedClassDao.class);

        ExamplePersistedClass example = new ExamplePersistedClass();
        example.setOtherField("hello world");
        examplePersistedClassDao .saveInNewTransaction(example);

        ExamplePersistedClass retrieved = examplePersistedClassDao.getByOtherField("hello world");

        Assert.assertEquals(example.getId(), retrieved.getId());
        Assert.assertEquals(example.getOtherField(), retrieved.getOtherField());

    }
}
