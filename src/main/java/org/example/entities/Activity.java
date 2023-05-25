package org.example.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity

public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cours")
    int idCours;

    String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_session")
    Date dateSession;

    @ManyToMany(mappedBy = "activities")
    List<Adhering> adherings;

    @ManyToOne
    @JoinColumn(name = "center_id")
    Center centeractivity;


    public Activity() {
    }


    public Center getCenteractivity() {
        return centeractivity;
    }

    public void setCenteractivity(Center centeractivity) {
        this.centeractivity = centeractivity;
    }

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateSession() {
        return dateSession;
    }

    public void setDateSession(Date dateSession) {
        this.dateSession = dateSession;
    }

    public List<Adhering> getAdherings() {
        return adherings;
    }

    public void setAdherings(List<Adhering> adherings) {
        this.adherings = adherings;
    }

    public void addAdherings(Adhering a){
        adherings.add(a);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "idCours=" + idCours +
                ", name='" + name + '\'' +
                ", dateSession=" + dateSession +
                ", adherings=" + adherings +
                ", centeractivity=" + centeractivity +
                '}';
    }
}
