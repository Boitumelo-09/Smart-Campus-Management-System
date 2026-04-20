package models;

import interfaces.Login;
import lombok.Data;

@Data
public class Staff  {

    int staffID;
    String lastName;
    String userName;
    String staffRole;
    String password;

    public Staff() {}

    public Staff(String role, String lastName, String name,int i) {
        staffID = i;
        this.lastName = lastName;
        userName = name;
        staffRole = role;
    }


}
