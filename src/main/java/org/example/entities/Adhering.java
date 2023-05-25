package org.example.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Adhering {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_adhering")
    int id;

    String lastName;
    String firstName;
    int age;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "adhering_activity",
            joinColumns = @JoinColumn(name = "adhering_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")

    )
    List<Activity> activities;

    @ManyToOne
    @JoinColumn(name = "center_id")
    Center center;


    public Adhering() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }
    public void addActivity (Activity a){
        activities.add(a);
    }

    @Override
    public String toString() {
        return "Adhering{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", activities=" + activities +
                ", center=" + center +
                '}';
    }
}
