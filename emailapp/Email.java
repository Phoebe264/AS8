/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailapp;

import java.util.Random;
import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String companySuffix = "aeycompany.com";
    private int mailBoxCapacity = 50;
    private int defaultPasswordLength = 10;
    private String department;
    private String password;
    Scanner input = new Scanner(System.in);

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = this.randomPassword(this.defaultPasswordLength);
    }

    private String setDepartment() {
        System.out.println("1 for Sales");
        System.out.println("2 for Development");
        System.out.println("3 for Accounting");
        System.out.println("0 for none");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                return "Sales";
            case 2:
                return "Dev";
            case 3:
                return "Acc";
            case 0:
                return "";
            default:
                return "";
        }
    }

    private String getName() {
        return this.firstName + " " + this.lastName;
    }

    private String getEmail() {
        return this.firstName + "." + this.lastName + "@" + this.department + "." + this.companySuffix;
    }

    private String randomPassword(int length) {
        Random rand = new Random();
        String passwordWord = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        String randomPassword = "";
        for (int i = 0; i < this.defaultPasswordLength; i++) {
            randomPassword += passwordWord.charAt(rand.nextInt(passwordWord.length()));
        }
        return randomPassword;
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public void setMailBoxCapacity(int mailBoxCapacity) {
        this.mailBoxCapacity = mailBoxCapacity;
    }

    public String getPassword() {
        return password;
    }

    public void setDefaultPasswordLength(int defaultPasswordLength) {
        this.defaultPasswordLength = defaultPasswordLength;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String showInfo() {
        String data = "New Worker: " + this.getName() + ". Department Codes:\n";
        System.out.println(data);
        this.department = this.setDepartment();
        data = "DISPLAY NAME: " + this.getName() + "\n";
        data += "DEPARTMENT: " + this.department + "\n";
        data += "COMPANY EMAIL: " + this.getEmail() + "\n";
        data += "PASSWORD: " + this.getPassword() + "\n";
        data += "MAILBOX CAPACITY: " + this.getMailBoxCapacity() + "mb\n";
        return data;
    }

}
