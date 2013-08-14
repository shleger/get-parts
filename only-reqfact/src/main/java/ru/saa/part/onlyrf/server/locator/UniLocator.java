package ru.saa.part.onlyrf.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.saa.part.onlyrf.server.dao.EmployeeDao;
import ru.saa.part.onlyrf.server.domain.DataStoreObject;
import ru.saa.part.onlyrf.server.domain.Employee;

/**
 * Created with IntelliJ IDEA.
 * User: saa
 * Date: 12/21/12
 * Time: 01:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class UniLocator extends Locator<DataStoreObject,Long> {

    //GWT Logger: private static Logger	logger	= Logger.getLogger(UniversalEntityLocator.class.getName());
    private static Logger logger = LoggerFactory.getLogger(MyServiceLocator.class.getSimpleName());

    @Override
    public DataStoreObject create(final Class<? extends DataStoreObject> clazz) {
        try {
            final DataStoreObject obj = clazz.newInstance();
            logger.debug("new instance for " + clazz.getName() + " created (UniversalEntityLocator)");
            return obj;
        } catch (final InstantiationException e) {
            throw new RuntimeException(e);
        } catch (final IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DataStoreObject find(final Class<? extends DataStoreObject> clazz, final Long id) {
        final EmployeeDao daoBase = new EmployeeDao();
        logger.debug("find DataStoreObject with ID: " + id);

        return daoBase.findEmployee(id);
    }

    @Override
    public Class<DataStoreObject> getDomainType() {
        logger.debug("getDomainType was called");

        // Never called
        return null;
    }

    @Override
    public Long getId(final DataStoreObject domainObject) {
        logger.debug("returns ID:" + domainObject.getId());
        return domainObject.getId();
    }

    @Override
    public Class<Long> getIdType() {
        logger.debug("returns getIdType:" + Long.class.getSimpleName());
        return Long.class;
    }

    @Override
    public Object getVersion(final DataStoreObject domainObject) {
        logger.debug("returns Version:" + domainObject.getVersion());
        return domainObject.getVersion();
    }
}
