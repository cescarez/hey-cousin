package com.escarezapi.heycousin;

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
    public Cousin() {
        this("Unknown", "Cousin");
    }
    public Cousin(String firstName, String lastName) {
        this.id = "0"; //Firebase entity id generated during write is used
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
    public void setId(String id) { this.id = id; }
}
