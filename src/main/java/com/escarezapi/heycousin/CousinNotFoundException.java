package com.escarezapi.heycousin;

public class CousinNotFoundException extends RuntimeException {
    CousinNotFoundException(String id) {
        super("Could not find cousin " + id + ".");
    }
}
