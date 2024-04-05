package org.example;

import org.example.model.Contact;
import org.example.model.EmailAddress;
import org.example.model.PhoneNumber;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Contact> contacts = new ArrayList<>();
        List<PhoneNumber> phoneNumbers=new ArrayList<>();
        List<EmailAddress>emailAddresses=new ArrayList<>();
        Contact contact1=new Contact("David","Sanger","Argos LLC","Sales Manager");
        Contact contact2=new Contact("Carlos","Jimenez","Zappos LLC"," Director");
        Contact contact3=new Contact("Ali","Gafar","BMI Services", "HR Manager");
PhoneNumber phoneNumber1= new PhoneNumber("240-133-0011","Home");
PhoneNumber phoneNumber2= new PhoneNumber("2240-112-0123","Mobile");
EmailAddress emailAddress1=new EmailAddress("dave.sang@gmail.com","Home");
EmailAddress emailAddress2=new EmailAddress("dsanger@argos.com","Work");
phoneNumbers.add(phoneNumber1);
phoneNumbers.add(phoneNumber2);
emailAddresses.add(emailAddress1);
emailAddresses.add(emailAddress2);
contact1.setPhoneNumbers(phoneNumbers);
contact1.setEmailAddresses(emailAddresses);
PhoneNumber phoneNumber3 = new PhoneNumber("412-116-9988","Work");
EmailAddress emailAddress3=new EmailAddress("ali@bmi.com","Work");
        List<PhoneNumber> phoneNumbers3=new ArrayList<>();
        List<EmailAddress>emailAddresses3=new ArrayList<>();
        phoneNumbers3.add(phoneNumber3);
        emailAddresses3.add(emailAddress3);
contact3.setPhoneNumbers(phoneNumbers3);
contact3.setEmailAddresses(emailAddresses3);

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);

        Collections.sort(contacts, Comparator.comparing(Contact::getLastName));


        System.out.println("[");
        for (Contact contact : contacts) {
            System.out.println("  {");
            System.out.println("    \"Contact FirstName\": " + contact.getFirstName() + ",");
            System.out.println("    \"Last Name\": \"" + contact.getLastName() + "\",");
            System.out.println("    \"Company\": \"" + contact.getCompany() + "\",");
            System.out.println("    \"Job Title\": \"" + contact.getJobTittle() + "\",");
            System.out.println("    \"Phone Numbers\": " + contact.getPhoneNumbers() + ",");
            System.out.println("    \"Email Addresses\": \"" + contact.getEmailAddresses() + "\",");

            System.out.println("  },");
        }
        System.out.println("]");
        }
    }
