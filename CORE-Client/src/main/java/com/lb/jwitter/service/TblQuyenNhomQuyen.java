
package com.lb.jwitter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tblQuyenNhomQuyen complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tblQuyenNhomQuyen">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="maNhomQuyen" type="{http://service.jwitter.lb.com/}tblNhomQuyen" minOccurs="0"/>
 *         &lt;element name="maQuyen" type="{http://service.jwitter.lb.com/}tblQuyen" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tblQuyenNhomQuyen", propOrder = {
    "id",
    "maNhomQuyen",
    "maQuyen"
})
public class TblQuyenNhomQuyen {

    protected Long id;
    protected TblNhomQuyen maNhomQuyen;
    protected TblQuyen maQuyen;

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
     * Gets the value of the maNhomQuyen property.
     * 
     * @return
     *     possible object is
     *     {@link TblNhomQuyen }
     *     
     */
    public TblNhomQuyen getMaNhomQuyen() {
        return maNhomQuyen;
    }

    /**
     * Sets the value of the maNhomQuyen property.
     * 
     * @param value
     *     allowed object is
     *     {@link TblNhomQuyen }
     *     
     */
    public void setMaNhomQuyen(TblNhomQuyen value) {
        this.maNhomQuyen = value;
    }

    /**
     * Gets the value of the maQuyen property.
     * 
     * @return
     *     possible object is
     *     {@link TblQuyen }
     *     
     */
    public TblQuyen getMaQuyen() {
        return maQuyen;
    }

    /**
     * Sets the value of the maQuyen property.
     * 
     * @param value
     *     allowed object is
     *     {@link TblQuyen }
     *     
     */
    public void setMaQuyen(TblQuyen value) {
        this.maQuyen = value;
    }

}
