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
@XmlRootElement(name = "order")
public class Order implements Serializable{
    
    @XmlElement(name = "movieTitle")
    private String movieTitle;
    @XmlElement(name = "movieGenre")
    private String movieGenre;
    @XmlElement(name = "moviePrice")
    private String moviePrice;
    @XmlElement(name = "releaseDate")
    private String releaseDate;
    @XmlElement(name = "copiesPurchased")
    private String copiesPurchased;
}
