package pl.sdacademy.neighbourhoodnanny.babysitter;

import org.springframework.format.annotation.NumberFormat;
import pl.sdacademy.neighbourhoodnanny.child.Child;
import pl.sdacademy.neighbourhoodnanny.childcareevent.ChildCareEvent;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Babysitter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 1,max = 100)
    private String firstName;
    @Size(min = 1,max = 100)
    private String lastName;
    @Size(min = 3,max = 15)
    @NumberFormat
    private String phoneNumber;
    @Size(min = 1,max = 300)
    @Email
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

    public void removeChild(Child child) {
        children.remove(child);
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
