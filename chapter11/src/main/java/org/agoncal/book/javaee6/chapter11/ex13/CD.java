package org.agoncal.book.javaee6.chapter11.ex13;

import javax.persistence.Entity;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
public class CD extends Item {

    // ======================================
    // =             Attributes             =
    // ======================================

    private String musicCompany;
    private Integer numberOfCDs;
    private Float totalDuration;
    private String gender;

    // ======================================
    // =            Constructors            =
    // ======================================

    public CD() {
    }

    public CD(String title, Float price, String description, String musicCompany, Integer numberOfCDs, Float totalDuration, String gender) {
        super(title, price, description);
        this.musicCompany = musicCompany;
        this.numberOfCDs = numberOfCDs;
        this.totalDuration = totalDuration;
        this.gender = gender;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getMusicCompany() {
        return musicCompany;
    }

    public void setMusicCompany(String musicCompany) {
        this.musicCompany = musicCompany;
    }

    public Integer getNumberOfCDs() {
        return numberOfCDs;
    }

    public void setNumberOfCDs(Integer numberOfCDs) {
        this.numberOfCDs = numberOfCDs;
    }

    public Float getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Float totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}