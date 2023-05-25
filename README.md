# ECF apli de gestion de centre sportif (fitnessShark)

- Le site permet de gerer des adhérents, des activités et des centres grâce a un CRUD



- de plus, j'ai ajouté des relation entre mes différente class : 

- du ***Many To Many*** 
un adhérent peut avoir une ou plusieurs activité(s) et inversement. 
Pour le class l'adhérent sa donne ceci : 

```
@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "adhering_activity",
            joinColumns = @JoinColumn(name = "adhering_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id")

    )
    List<Activity> activities;
```

et l'activité :
```
 @ManyToMany(mappedBy = "activities")
    List<Adhering> adherings;
```


 - du ***Many To One*** 
Un adhérent peut avoir aucune ou une sale atribuée
```
@ManyToOne
    @JoinColumn(name = "center_id")
    Center center;
```

- Et inversement, du ***One To Many***
un centre peut avoir zéro a une infinité d'adhérent;