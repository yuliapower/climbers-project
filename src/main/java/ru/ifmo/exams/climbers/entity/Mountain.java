package ru.ifmo.exams.climbers.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class Mountain extends BaseId {
    @Column(unique = true,nullable = false)
    private String mountainName;
    private String country;
    private int height;
    //private Group group;

    public Mountain() {
    }

    public Mountain(String mountainName, String country, int height) {
        setMountainName(mountainName);
        setCountry(country);
        setHeight(height);
    }

    public void setMountainName(String mountainName) {
        if (mountainName == null || mountainName.length() < 4) {
            throw new IllegalArgumentException("Значение mountain от 4 символов");
        }
        this.mountainName = mountainName;
    }


    public void setCountry(String country) {
        if (country == null || country.length() < 4) {
            throw new IllegalArgumentException("Значение country от 4 символов");
        }
        this.country = country;
    }

    public void setHeight(int height) {
        if (height < 100) {
            throw new IllegalArgumentException("Значение height должно быть больше 100");
        }
        this.height = height;
    }

    public int getHeight() {
        return height;
    }


}
