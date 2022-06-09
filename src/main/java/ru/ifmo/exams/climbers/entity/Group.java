package ru.ifmo.exams.climbers.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "groups_of_climbers")
public class Group extends BaseId{
    @OneToMany(mappedBy = "group",fetch = FetchType.EAGER, orphanRemoval = true,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Climber[] climbers;
    //@Column(unique = true,nullable = false)
    @ManyToOne
    private Mountain mountain;

    public Group(){
    }

    public Group( Mountain mountain,int countClimbers) {

        this.climbers = new Climber[countClimbers];
        this.mountain = mountain;
    }


    public void addClimber(Climber climber) {
        if (climbers.length > 3) {
            System.out.println("Набор закрыт");
            return;
        }
        for (int i = 0; i < climbers.length; i++) {
            if (climbers[i] == null) {
                climbers[i] = climber;
                climber.setGroup(this);
                return;
            }
        }
    }

}
