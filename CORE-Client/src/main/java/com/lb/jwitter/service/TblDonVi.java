
package com.lb.jwitter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tblDonVi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tblDonVi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="diaChi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="donViChaId" type="{http://service.jwitter.lb.com/}tblDonVi" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="lvl" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ma" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sdt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ten" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="truongDonVi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tblDonVi", propOrder = {
    "diaChi",
    "donViChaId",
    "email",
    "id",
    "lvl",
    "ma",
    "sdt",
    "ten",
    "truongDonVi"
})
public class TblDonVi {

    protected String diaChi;
    protected TblDonVi donViChaId;
    protected String email;
    protected Long id;
    protected Integer lvl;
    protected String ma;
    protected String sdt;
    protected String ten;
    protected String truongDonVi;

    /**
     * Gets the value of the diaChi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * Sets the value of the diaChi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiaChi(String value) {
        this.diaChi = value;
    }

    /**
     * Gets the value of the donViChaId property.
     * 
     * @return
     *     possible object is
     *     {@link TblDonVi }
     *     
     */
    public TblDonVi getDonViChaId() {
        return donViChaId;
    }

    /**
     * Sets the value of the donViChaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link TblDonVi }
     *     
     */
    public void setDonViChaId(TblDonVi value) {
        this.donViChaId = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
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
     * Gets the value of the lvl property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLvl() {
        return lvl;
    }

    /**
     * Sets the value of the lvl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLvl(Integer value) {
        this.lvl = value;
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
     * Gets the value of the sdt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSdt() {
        return sdt;
    }

    /**
     * Sets the value of the sdt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSdt(String value) {
        this.sdt = value;
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

    /**
     * Gets the value of the truongDonVi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTruongDonVi() {
        return truongDonVi;
    }

    /**
     * Sets the value of the truongDonVi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTruongDonVi(String value) {
        this.truongDonVi = value;
    }

}
