/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zexin Zhong
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="movie")
public class Movie implements Serializable{
    
    @XmlElement(name="title")
    private String movie_title;
    @XmlElement(name="genre")
    private String movie_genre;
    @XmlElement(name="relase_date")
    private String movie_release_date;
    @XmlElement(name="price")
    private double movie_price;
    @XmlElement(name="available_copies")
    private int available_copies;

    public Movie() {
    }

    public Movie(String movie_title, String movie_genre, String movie_release_date, double movie_price, int available_copies) {
        this.movie_title = movie_title;
        this.movie_genre = movie_genre;
        this.movie_release_date = movie_release_date;
        this.movie_price = movie_price;
        this.available_copies = available_copies;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public String getMovie_genre() {
        return movie_genre;
    }

    public String getMovie_release_date() {
        return movie_release_date;
    }

    public double getMovie_price() {
        return movie_price;
    }

    public int getAvailable_copies() {
        return available_copies;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public void setMovie_genre(String movie_genre) {
        this.movie_genre = movie_genre;
    }

    public void setMovie_release_date(String movie_release_date) {
        this.movie_release_date = movie_release_date;
    }

    public void setMovie_price(double movie_price) {
        this.movie_price = movie_price;
    }

    public void setAvailable_copies(int available_copies) {
        this.available_copies = available_copies;
    }
    
    public void updateCopies(int sellCopies){
        this.available_copies -= sellCopies;
    }
}

