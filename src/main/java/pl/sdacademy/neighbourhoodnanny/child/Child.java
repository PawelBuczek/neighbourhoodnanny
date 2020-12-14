package pl.sdacademy.neighbourhoodnanny.child;

import pl.sdacademy.neighbourhoodnanny.babysitter.Babysitter;

import javax.persistence.*;

@Entity
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    @ManyToOne
    private Babysitter babysitter;

    public Child(String firstName, String lastName, int age, Babysitter babysitter) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.babysitter = babysitter;
    }

    public Child() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Babysitter getBabysitter() {
        return babysitter;
    }

    public void setBabysitter(Babysitter babysitters) {
        this.babysitter = babysitters;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", babysitters=" + babysitter +
                '}';
    }
}
