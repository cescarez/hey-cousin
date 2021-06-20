package com.escarezapi.heycousin;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Cousin {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Cousin parentOne;
    private Cousin parentTwo;
    List<String> nicknames;

// TODO: validate inputs
    public Cousin(String firstName, String lastName) {
        this.id = "0"; //TODO:create algo to create id
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate.toString();
    }
    public int getAge() {
        return Period.between(LocalDate.now(), birthDate).getYears();
    }
}
