/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zhongzexin
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "history")
public class History implements Serializable {

    @XmlElement(name = "ID")
    private String ID;
    @XmlElement(name = "fullName")
    private String fullName;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "paymentMethod")
    private String paymentMethod;
    @XmlElement(name = "saleTotal")
    private String saleTotal;
    @XmlElement(name = "status")
    private String status;
    @XmlElement(name = "orders")
    private ArrayList<Order> orders;

}
