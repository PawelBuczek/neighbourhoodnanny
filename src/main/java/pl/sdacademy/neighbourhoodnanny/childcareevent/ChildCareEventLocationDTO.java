package pl.sdacademy.neighbourhoodnanny.childcareevent;

import pl.sdacademy.neighbourhoodnanny.child.Child;

import java.time.LocalDateTime;
import java.util.List;

public class ChildCareEventLocationDTO {
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Child> children;
    private String street;
    private String city;
    private String postalCode;

    public ChildCareEventLocationDTO(String name, LocalDateTime startTime, LocalDateTime endTime, List<Child> children, String street, String city, String postalCode) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.children = children;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public ChildCareEventLocationDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
