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
@XmlRootElement(name = "movie")
public class Movie implements Serializable {

    @XmlElement(name = "title")
    private String movie_title;
    @XmlElement(name = "genre")
    private String movie_genre;
    @XmlElement(name = "relase_date")
    private String movie_release_date;
    @XmlElement(name = "price")
    private int movie_price;
    @XmlElement(name = "available_copies")
    private int available_copies;

    public Movie() {
    }

    public Movie(String movie_title, String movie_genre, String movie_release_date, int movie_price, int available_copies) {
        this.movie_title = movie_title;
        this.movie_genre = movie_genre;
        this.movie_release_date = movie_release_date;
        this.movie_price = movie_price;
        this.available_copies = available_copies;
    }

    /**
     *This is the getter of the movie_title field.
     * @return movie_title
     */
    public String getMovie_title() {
        return movie_title;
    }

    /**
     *This is the getter of the movie_genre field.
     * @return movie_genre
     */
    public String getMovie_genre() {
        return movie_genre;
    }

    /**
     *This is the getter of the movie_release_date field.
     * @return movie_release_date
     */
    public String getMovie_release_date() {
        return movie_release_date;
    }

    /**
     *This is the getter of the movie_price field.
     * @return movie_price
     */
    public int getMovie_price() {
        return movie_price;
    }

    /**
     * This is the getter of the available_copies field.
     *
     * @return available_copies
     */
    public int getAvailable_copies() {
        return available_copies;
    }

    /**
     * This is the setter of the movie_title field.
     *
     * @param movie_title
     */
    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    /**
     * This is the setter of the movie_genre.
     *
     * @param movie_genre
     */
    public void setMovie_genre(String movie_genre) {
        this.movie_genre = movie_genre;
    }

    /**
     * This is the setter of the movie_release_date field.
     *
     * @param movie_release_date
     */
    public void setMovie_release_date(String movie_release_date) {
        this.movie_release_date = movie_release_date;
    }

    /**
     * This is the setter of the movie_price field.
     *
     * @param movie_price
     */
    public void setMovie_price(int movie_price) {
        this.movie_price = movie_price;
    }

    /**
     * This is the setter of the available_copies field.
     *
     * @param available_copies
     */
    public void setAvailable_copies(int available_copies) {
        this.available_copies = available_copies;
    }

    /**
     * This method will decrease the available copies of the movie.
     *
     * @param sellCopies the number of copies that has sell
     */
    public void updateCopies(int sellCopies) {
        this.available_copies -= sellCopies;
    }

    /**
     * This method will check if the movie title match the query movie title
     *
     * @param movie_title the query movie title
     * @return
     */
    public boolean matchTitle(String movie_title) {
        return this.movie_title.equals(movie_title);
    }

    /**
     * This method will increase the available copies of the movie
     *
     * @param copies
     */
    public void addCopies(int copies) {
        this.available_copies += copies;
    }

    /**
     * This method will minus the available copies of the movie
     *
     * @param copies
     */
    public void minusCopies(int copies) {
        this.available_copies -= copies;
    }

    /**
     * This method will check if the movie is available.
     *
     * @return true if the movie is available
     */
    public boolean checkAvailable() {
        return this.available_copies > 0;
    }
}
