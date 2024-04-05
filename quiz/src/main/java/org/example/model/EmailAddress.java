package org.example.model;

public class EmailAddress {


    private String email;
    private String label;

    public EmailAddress(String email, String label) {
        this.email = email;
        this.label = label;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmailAddress{" +
                "email='" + email + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
