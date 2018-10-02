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
 * @author zhongzexin
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "orderItem")
public class Item implements Serializable{
    
    @XmlElement(name = "movieTitle")
    private String movieTitle;
    @XmlElement(name = "movieGenre")
    private String movieGenre;
    @XmlElement(name = "moviePrice")
    private String moviePrice;
    @XmlElement(name = "releaseDate")
    private String releaseDate;
    @XmlElement(name = "copiesPurchased")
    private int copiesPurchased;

    public Item() {
    }

    public Item(String movieTitle, String movieGenre, String moviePrice, String releaseDate, int copiesPurchased) {
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
        this.moviePrice = moviePrice;
        this.releaseDate = releaseDate;
        this.copiesPurchased = copiesPurchased;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public String getMoviePrice() {
        return moviePrice;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getCopiesPurchased() {
        return copiesPurchased;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public void setMoviePrice(String moviePrice) {
        this.moviePrice = moviePrice;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setCopiesPurchased(int copiesPurchased) {
        this.copiesPurchased = copiesPurchased;
    }
    
    
}
