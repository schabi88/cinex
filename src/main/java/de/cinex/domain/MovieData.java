package de.cinex.domain;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class MovieData extends PersistentObject {


    /**
     * --------------------VARIABLES-----------------------------
     **/
    private String name;
    private int age;
    private String genre;
    private double duration;
    private String description;
    private String cinemaname;
    private double price;

    /**
     * --------------------Getter/Setter-----------------------------
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCinemaname() {
        return cinemaname;
    }

    public void setCinemaname(String cinemaname) {
        this.cinemaname = cinemaname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * --------------------Constructor-----------------------------
     **/

    public MovieData() {
    }


}
