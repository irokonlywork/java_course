package ru.stqa.course.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "addressbook")

@XStreamAlias("contact")
public class ContactData {

    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Expose
    @Column(name = "firstname")
    private String firstname;

    @Expose
    @Column(name = "lastname")
    private String lastname;

    @Expose
    @Column(name = "email")
    @Type(type = "text")
    private String email;

    @Transient
    private String group;

    @Column(name = "home")
    @Type(type = "text")
    private String homePhone;

    @Column(name = "mobile")
    @Type(type = "text")
    private String mobilePhone;

    @Column(name = "work")
    @Type(type = "text")
    private String workPhone;

    @Transient
    private String allPhones;

    @Column(name = "address")
    @Type(type = "text")
    private String homeAddress;

    @Column(name = "address2")
    @Type(type = "text")
    private String secondaryAddress;

    @Transient
    private String allAddresses;

    @Column(name = "email2")
    @Type(type = "text")
    private String twoEmail;

    @Column(name = "email3")
    @Type(type = "text")
    private String threeEmail;

    @Transient
    private String allEmails;

    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withHomePhone(String home) {
        this.homePhone = home;
        return this;
    }

    public ContactData withMobilePhone(String mobile) {
        this.mobilePhone = mobile;
        return this;
    }

    public ContactData withWorkPhone(String work) {
        this.workPhone = work;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withHomeAddress(String home) {
        this.homeAddress = home;
        return this;
    }

    public ContactData withSecondaryAddress(String secondary) {
        this.secondaryAddress = secondary;
        return this;
    }

    public ContactData withAllAddresses(String allAddresses) {
        this.allAddresses = allAddresses;
        return this;
    }

    public ContactData withTwoEmail(String email2) {
        this.twoEmail = email2;
        return this;
    }

    public ContactData withThreeEmail(String email3) {
        this.threeEmail = email3;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getSecondaryAddress() {
        return secondaryAddress;
    }

    public String getAllAddresses() {
        return allAddresses;
    }

    public String getTwoEmail() {
        return twoEmail;
    }

    public String getThreeEmail() {
        return threeEmail;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public File getPhoto() {
        return new File(photo);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", group='" + group + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", allPhones='" + allPhones + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", secondaryAddress='" + secondaryAddress + '\'' +
                ", allAddresses='" + allAddresses + '\'' +
                ", twoEmail='" + twoEmail + '\'' +
                ", threeEmail='" + threeEmail + '\'' +
                ", allEmails='" + allEmails + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;

        ContactData that = (ContactData) o;

        if ( firstname != null ? ! firstname.equals(that.firstname) : that.firstname != null ) return false;
        if ( lastname != null ? ! lastname.equals(that.lastname) : that.lastname != null ) return false;
        if ( email != null ? ! email.equals(that.email) : that.email != null ) return false;
        if ( group != null ? ! group.equals(that.group) : that.group != null ) return false;
        if ( homePhone != null ? ! homePhone.equals(that.homePhone) : that.homePhone != null ) return false;
        if ( mobilePhone != null ? ! mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null ) return false;
        if ( workPhone != null ? ! workPhone.equals(that.workPhone) : that.workPhone != null ) return false;
        if ( allPhones != null ? ! allPhones.equals(that.allPhones) : that.allPhones != null ) return false;
        if ( homeAddress != null ? ! homeAddress.equals(that.homeAddress) : that.homeAddress != null ) return false;
        if ( secondaryAddress != null ? ! secondaryAddress.equals(that.secondaryAddress) : that.secondaryAddress != null )
            return false;
        if ( allAddresses != null ? ! allAddresses.equals(that.allAddresses) : that.allAddresses != null ) return false;
        if ( twoEmail != null ? ! twoEmail.equals(that.twoEmail) : that.twoEmail != null ) return false;
        if ( threeEmail != null ? ! threeEmail.equals(that.threeEmail) : that.threeEmail != null ) return false;
        return allEmails != null ? allEmails.equals(that.allEmails) : that.allEmails == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
        result = 31 * result + (allPhones != null ? allPhones.hashCode() : 0);
        result = 31 * result + (homeAddress != null ? homeAddress.hashCode() : 0);
        result = 31 * result + (secondaryAddress != null ? secondaryAddress.hashCode() : 0);
        result = 31 * result + (allAddresses != null ? allAddresses.hashCode() : 0);
        result = 31 * result + (twoEmail != null ? twoEmail.hashCode() : 0);
        result = 31 * result + (threeEmail != null ? threeEmail.hashCode() : 0);
        result = 31 * result + (allEmails != null ? allEmails.hashCode() : 0);
        return result;
    }
}
