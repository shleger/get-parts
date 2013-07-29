package ru.saa.part.springrf.server.locator.spring;

import java.io.Serializable;

/**
 * $Revision:  $
 * $Author: shleger $
 * $Date: 25.07.13 17:01  $
 */
public interface HasVersionAndId extends Serializable{

    Long getId();
    Long getVersion();

}
