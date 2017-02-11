
package com.lb.jwitter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tblTaiKhoan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tblTaiKhoan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="canBoId" type="{http://service.jwitter.lb.com/}tblCanBo" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="maNhomQuyen" type="{http://service.jwitter.lb.com/}tblNhomQuyen" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tblTaiKhoan", propOrder = {
    "canBoId",
    "id",
    "maNhomQuyen",
    "password",
    "username"
})
public class TblTaiKhoan {

    protected TblCanBo canBoId;
    protected Long id;
    protected TblNhomQuyen maNhomQuyen;
    protected String password;
    protected String username;

    /**
     * Gets the value of the canBoId property.
     * 
     * @return
     *     possible object is
     *     {@link TblCanBo }
     *     
     */
    public TblCanBo getCanBoId() {
        return canBoId;
    }

    /**
     * Sets the value of the canBoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link TblCanBo }
     *     
     */
    public void setCanBoId(TblCanBo value) {
        this.canBoId = value;
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
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

}
