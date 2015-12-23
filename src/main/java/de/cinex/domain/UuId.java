package de.cinex.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class UuId implements Serializable {

    private String id;

    private UuId(String id) {
        this.id = id;
    }

    public UuId() {
        id = UUID.randomUUID().toString();
    }


    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static UuId fromString(String id) {
        UUID.fromString(id);
        return new UuId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = UUID.fromString(id).toString();
    }

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