package org.example.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "center_id")
    int id;

    String name;

    String adress;

    @OneToMany(mappedBy = "center")
    List<Adhering> adheringList;
    @OneToMany(mappedBy = "centeractivity")
    List<Activity> activityList;


    public Center() {
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Adhering> getAdheringList() {
        return adheringList;
    }

    public void setAdheringList(List<Adhering> adheringList) {
        this.adheringList = adheringList;
    }
    public void addAdhering (Adhering a) {
        adheringList.add(a);
    }

    @Override
    public String toString() {
        return "Center{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", adheringList=" + adheringList +
                ", activityList=" + activityList +
                '}';
    }
}
