package ru.saa.parts.gwt.server.dao;

import ru.saa.parts.gwt.server.domain.Data;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: shleger
 * Date: 19.12.12
 * Time: 17:28
 * To change this template use File | Settings | File Templates.
 */
public class DataDao {

    public Data getData(){

        Data d = new Data();
        d.setId(12L);
        d.setName("Data name");
        d.setDescr("Description");
        d.setVersion(new Random().nextLong());

        return d;
    }
}
