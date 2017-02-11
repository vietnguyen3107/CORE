
package com.lb.jwitter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tblQLDTConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tblQLDTConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="giaTri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ma" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ten" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tblQLDTConfig", propOrder = {
    "giaTri",
    "id",
    "ma",
    "ten"
})
public class TblQLDTConfig {

    protected String giaTri;
    protected Long id;
    protected String ma;
    protected String ten;

    /**
     * Gets the value of the giaTri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGiaTri() {
        return giaTri;
    }

    /**
     * Sets the value of the giaTri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGiaTri(String value) {
        this.giaTri = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the ma property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMa() {
        return ma;
    }

    /**
     * Sets the value of the ma property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMa(String value) {
        this.ma = value;
    }

    /**
     * Gets the value of the ten property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTen() {
        return ten;
    }

    /**
     * Sets the value of the ten property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTen(String value) {
        this.ten = value;
    }

}
