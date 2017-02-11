
package com.lb.jwitter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tblQuyenChiTiet complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tblQuyenChiTiet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bangId" type="{http://service.jwitter.lb.com/}tblDBTable" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="quyenId" type="{http://service.jwitter.lb.com/}tblQuyen" minOccurs="0"/>
 *         &lt;element name="sua" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="them" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="xem" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="xoa" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tblQuyenChiTiet", propOrder = {
    "bangId",
    "id",
    "quyenId",
    "sua",
    "them",
    "xem",
    "xoa"
})
public class TblQuyenChiTiet {

    protected TblDBTable bangId;
    protected Long id;
    protected TblQuyen quyenId;
    protected Boolean sua;
    protected Boolean them;
    protected Boolean xem;
    protected Boolean xoa;

    /**
     * Gets the value of the bangId property.
     * 
     * @return
     *     possible object is
     *     {@link TblDBTable }
     *     
     */
    public TblDBTable getBangId() {
        return bangId;
    }

    /**
     * Sets the value of the bangId property.
     * 
     * @param value
     *     allowed object is
     *     {@link TblDBTable }
     *     
     */
    public void setBangId(TblDBTable value) {
        this.bangId = value;
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
     * Gets the value of the quyenId property.
     * 
     * @return
     *     possible object is
     *     {@link TblQuyen }
     *     
     */
    public TblQuyen getQuyenId() {
        return quyenId;
    }

    /**
     * Sets the value of the quyenId property.
     * 
     * @param value
     *     allowed object is
     *     {@link TblQuyen }
     *     
     */
    public void setQuyenId(TblQuyen value) {
        this.quyenId = value;
    }

    /**
     * Gets the value of the sua property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSua() {
        return sua;
    }

    /**
     * Sets the value of the sua property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSua(Boolean value) {
        this.sua = value;
    }

    /**
     * Gets the value of the them property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isThem() {
        return them;
    }

    /**
     * Sets the value of the them property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setThem(Boolean value) {
        this.them = value;
    }

    /**
     * Gets the value of the xem property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isXem() {
        return xem;
    }

    /**
     * Sets the value of the xem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setXem(Boolean value) {
        this.xem = value;
    }

    /**
     * Gets the value of the xoa property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isXoa() {
        return xoa;
    }

    /**
     * Sets the value of the xoa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setXoa(Boolean value) {
        this.xoa = value;
    }

}
