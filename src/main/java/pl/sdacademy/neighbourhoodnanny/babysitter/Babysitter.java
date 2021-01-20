package pl.sdacademy.neighbourhoodnanny.babysitter;

import org.hibernate.annotations.Cascade;
import pl.sdacademy.neighbourhoodnanny.child.Child;
import pl.sdacademy.neighbourhoodnanny.childcareevent.ChildCareEvent;
import pl.sdacademy.neighbourhoodnanny.users.User;

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
    @OneToOne
    User user;
    @Size(min = 1,max = 100, message = "has to be between 1 and 100 characters")
    private String firstName;
    @Size(min = 1,max = 100, message = "has to be between 1 and 100 characters")
    private String lastName;
    @Size(min = 3,max = 15, message = "has to be between 3 and 15 digits")
    private String phoneNumber;
    @Size(min = 1,max = 300, message = "has to be between 1 and 300 characters")
    @Email(message = "has to be a valid email address")
    private String email;
    @OneToMany
    private List<ChildCareEvent> eventList;
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<Child> children;


    public Babysitter(User user, String firstName, String lastName, String phoneNumber, String email, List<ChildCareEvent> eventList, List<Child> children) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.eventList = eventList;
        this.children = children;
    }

    public Babysitter(User user, String firstName, String lastName, String phoneNumber, String email) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.eventList = new ArrayList<>();
        this.children = new ArrayList<>();

    }public Babysitter(String firstName, String lastName, String phoneNumber, String email) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                ", user=" + user +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", eventList=" + eventList +
                ", children=" + children +
                '}';
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
