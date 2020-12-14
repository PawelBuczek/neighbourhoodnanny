package pl.sdacademy.neighbourhoodnanny.ChildCareEvent;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class ChildCareEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @ManyToOne(fetch = FetchType.EAGER)
    private List<Child> children;
    @ManyToOne(fetch = FetchType.EAGER)
    private Location location;

    public ChildCareEvent(String name, LocalDateTime startTime, LocalDateTime endTime, List<Child> children, Location location) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.children = children;
        this.location = location;
    }

    public ChildCareEvent() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
        return Objects.hash(Id, name, startTime, endTime, children, location);
    }

    @Override
    public String toString() {
        return "ChildCareEvent{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", children=" + children +
                ", location=" + location +
                '}';
    }
}
