package de.cinex.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class UuId implements Serializable {

    private String id;

    private UuId(String id) {
        this.id = id;
    } //First contructor with parameterized String "id"

    public UuId() {
        id = UUID.randomUUID().toString();
    } //Second constructor with no paramter -> generates UUID and converts into string

    //Method does not make any sense to me, fromString is pre defined by class UUID, why is this (Override??!!) necessary?
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static UuId fromString(String id) {
        UUID.fromString(id); // validate
        return new UuId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = UUID.fromString(id).toString();
    } //Sets ID by taking ID as paramter and generates new UUID and comnverts it into string

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UuId id1 = (UuId) o;

        return id.equals(id1.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "UuId{" +
                "id=" + id +
                '}';
    }

    public String asString() {
        return id;
    }
}