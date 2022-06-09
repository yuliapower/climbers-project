package ru.ifmo.exams.climbers.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class Climber extends BaseId {
    @Column(nullable = false)
    private String name;
    private String address;
    @ManyToOne(fetch=FetchType.LAZY)
    private Group group;

    public Climber(){
    }

    public Climber(String name, String address) {
        setName(name);
        setAddress(address);
    }

    public void setName(String name) {
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Значение name от 3 символов");
        }
        this.name = name;
    }

    public void setAddress(String address) {
        if (address == null || address.length() < 5) {
            throw new IllegalArgumentException("Значение address от 5 символов");
        }
        this.address = address;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
