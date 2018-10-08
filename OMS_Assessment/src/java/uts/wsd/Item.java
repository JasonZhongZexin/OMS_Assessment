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
@XmlRootElement(name = "orderItem")
public class Item implements Serializable {

    @XmlElement(name = "movieTitle")
    private String movieTitle;
    @XmlElement(name = "movieGenre")
    private String movieGenre;
    @XmlElement(name = "moviePrice")
    private int moviePrice;
    @XmlElement(name = "releaseDate")
    private String releaseDate;
    @XmlElement(name = "copiesPurchased")
    private int copiesPurchased;

    public Item() {
    }

    /**
     * THis is the constructor of the item class. It will construct the item with the
     * given field.
     * @param movieTitle
     * @param movieGenre
     * @param moviePrice
     * @param releaseDate
     * @param copiesPurchased 
     */
    public Item(String movieTitle, String movieGenre, int moviePrice, String releaseDate, int copiesPurchased) {
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
        this.moviePrice = moviePrice;
        this.releaseDate = releaseDate;
        this.copiesPurchased = copiesPurchased;
    }

    /**
     * This is the getter of the movieTitle field 
     * @return movieTitle
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * This is the getter of the movieGenre field.
     * @return movieGenre
     */
    public String getMovieGenre() {
        return movieGenre;
    }

    /**
     * This is the getter of the moviePrice field.
     * @return moviePrice
     */
    public int getMoviePrice() {
        return moviePrice;
    }

    /**
     * This is the getter of the releaseDate field.
     * @return releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * This is the getter of the copiesPurchased field.
     * @return copiesPurchased
     */
    public int getCopiesPurchased() {
        return copiesPurchased;
    }

    /**
     * This is the setter of the movieTitle field
     *
     * @param movieTitle
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    /**
     * This is the setter of the movieGenre field
     *
     * @param movieGenre
     */
    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    /**
     * This is the setter of the moviePrice field
     *
     * @param moviePrice
     */
    public void setMoviePrice(int moviePrice) {
        this.moviePrice = moviePrice;
    }

    /**
     * This is the setter of the releaseDate field
     *
     * @param releaseDate
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * This is the setter of the copiesPurchased field.
     *
     * @param copiesPurchased
     */
    public void setCopiesPurchased(int copiesPurchased) {
        this.copiesPurchased = copiesPurchased;
    }

}
