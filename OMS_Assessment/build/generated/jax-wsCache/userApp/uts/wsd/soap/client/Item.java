
package uts.wsd.soap.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for item complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="item"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="movieTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="movieGenre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="moviePrice" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="releaseDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="copiesPurchased" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "item", propOrder = {
    "movieTitle",
    "movieGenre",
    "moviePrice",
    "releaseDate",
    "copiesPurchased"
})
public class Item {

    protected String movieTitle;
    protected String movieGenre;
    protected int moviePrice;
    protected String releaseDate;
    protected int copiesPurchased;

    /**
     * Gets the value of the movieTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * Sets the value of the movieTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMovieTitle(String value) {
        this.movieTitle = value;
    }

    /**
     * Gets the value of the movieGenre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMovieGenre() {
        return movieGenre;
    }

    /**
     * Sets the value of the movieGenre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMovieGenre(String value) {
        this.movieGenre = value;
    }

    /**
     * Gets the value of the moviePrice property.
     * 
     */
    public int getMoviePrice() {
        return moviePrice;
    }

    /**
     * Sets the value of the moviePrice property.
     * 
     */
    public void setMoviePrice(int value) {
        this.moviePrice = value;
    }

    /**
     * Gets the value of the releaseDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the value of the releaseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReleaseDate(String value) {
        this.releaseDate = value;
    }

    /**
     * Gets the value of the copiesPurchased property.
     * 
     */
    public int getCopiesPurchased() {
        return copiesPurchased;
    }

    /**
     * Sets the value of the copiesPurchased property.
     * 
     */
    public void setCopiesPurchased(int value) {
        this.copiesPurchased = value;
    }

}
