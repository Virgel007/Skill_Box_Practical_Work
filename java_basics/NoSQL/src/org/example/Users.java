package org.example;

import java.util.Date;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Users {
    private String name;

    private boolean serviceFrontQueue;

    private Date registrationTime;

    public Users(String name, Date registrationTime, boolean serviceFrontQueue) {
        this.name = name;
        this.registrationTime = registrationTime;
        this.serviceFrontQueue = serviceFrontQueue;
    }

    @Override
    public String toString() {
        return "" + name + " Время регистрации: " + registrationTime + "   -   " + serviceFrontQueue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(name, users.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}