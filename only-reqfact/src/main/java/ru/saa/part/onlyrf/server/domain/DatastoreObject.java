package ru.saa.part.onlyrf.server.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Version;

/**
 * Created with IntelliJ IDEA.
 * User: saa
 * Date: 8/14/13
 * Time: 21:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataStoreObject {

    private static Logger logger	= LoggerFactory.getLogger(DataStoreObject.class.getSimpleName());

    @Id
    @Column(name = "id", nullable = false)
    protected Long			id;

    @Version
    @Column(name = "version")
    protected Integer			version	= 0;

    /**
     * Auto-increment version # whenever persisted
     */
    @PrePersist
    void onPersist() {

        this.version++;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        logger.debug("setId to " + id);
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(final Integer version) {
        logger.debug("setVersion to: " + version);
        this.version = version;
    }

}
