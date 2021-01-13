package pl.sdacademy.neighbourhoodnanny.childcareevent;

import org.springframework.format.annotation.DateTimeFormat;
import pl.sdacademy.neighbourhoodnanny.child.Child;
import pl.sdacademy.neighbourhoodnanny.location.Location;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ChildCareEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 1,max = 100, message = "has to be between 1 and 100 characters")
    private String name;
    @DateTimeFormat(pattern= "DD-MM-YYYY")
    private LocalDateTime startTime;
    @DateTimeFormat(pattern= "DD-MM-YYYY")
    private LocalDateTime endTime;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Child> children;
    @ManyToOne
    private Location location;

    public ChildCareEvent(String name, LocalDateTime startTime, LocalDateTime endTime, List<Child> children, Location location) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.children = children;
        this.location = location;
    }

    public ChildCareEvent(String name, LocalDateTime startTime, LocalDateTime endTime, Location location) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.children = new ArrayList<>();
        this.location = location;
    }

    public void addChild(Child child) {
        children.add(child);
    }

    public ChildCareEvent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildCareEvent that = (ChildCareEvent) o;
        return Objects.equals(name, that.name) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(children, that.children) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startTime, endTime, children, location);
    }

    @Override
    public String toString() {
        return "ChildCareEvent{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", children=" + children +
                ", location=" + location +
                '}';
    }
}
