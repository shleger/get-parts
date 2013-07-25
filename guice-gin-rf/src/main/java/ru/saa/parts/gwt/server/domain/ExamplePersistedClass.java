package ru.saa.parts.gwt.server.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * $Revision:  $
 * $Author: shleger $
 * $Date: 25.07.13 14:20  $
 *
 * from http://www.benmccann.com/blog/hibernate-with-jpa-annotations-and-guice/
 */
@Entity
public class ExamplePersistedClass {

    @Id
    @GeneratedValue
    private Long id;

    private String otherField;

    public ExamplePersistedClass() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setOtherField(String otherField) {
        this.otherField = otherField;
    }

    public String getOtherField() {
        return otherField;
    }

}
