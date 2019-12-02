package homeWork6;

import java.util.List;

public class Employer {
    private String firstname;
    private String lastname;
    private int id;

     Employer(int id, String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }

     int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + firstname + " " + lastname;
    }
}
