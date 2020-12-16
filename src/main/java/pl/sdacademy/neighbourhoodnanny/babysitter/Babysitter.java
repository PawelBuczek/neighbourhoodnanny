package pl.sdacademy.neighbourhoodnanny.babysitter;

import pl.sdacademy.neighbourhoodnanny.ChildCareEvent.ChildCareEvent;
import pl.sdacademy.neighbourhoodnanny.child.Child;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Babysitter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    @OneToMany
    private List<ChildCareEvent> eventList;
    @OneToMany
    private List<Child> children;


    public Babysitter(String firstName, String lastName, String phoneNumber, String email, List<ChildCareEvent> eventList, List<Child> children) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.eventList = eventList;
        this.children = children;
    }

    public Babysitter(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.eventList = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Babysitter() {
    }

    public void addChild(Child child) {
        children.add(child);
    }

    public Long getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String eMail) {
        this.email = eMail;
    }


    public List<ChildCareEvent> getEventList() {
        return eventList;
    }

    public void setEventList(List<ChildCareEvent> eventList) {
        this.eventList = eventList;
    }

    @Override
    public String toString() {
        return "Babysitter{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", eMail='" + email + '\'' +
                ", eventList=" + eventList +
                '}';
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
