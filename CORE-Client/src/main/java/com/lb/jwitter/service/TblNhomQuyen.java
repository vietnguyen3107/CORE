
package com.lb.jwitter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tblNhomQuyen complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tblNhomQuyen">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="defaultPage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="tenNhomQuyen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tblNhomQuyen", propOrder = {
    "defaultPage",
    "id",
    "tenNhomQuyen"
})
public class TblNhomQuyen {

    protected String defaultPage;
    protected Long id;
    protected String tenNhomQuyen;

    /**
     * Gets the value of the defaultPage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultPage() {
        return defaultPage;
    }

    /**
     * Sets the value of the defaultPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultPage(String value) {
        this.defaultPage = value;
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
     * Gets the value of the tenNhomQuyen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenNhomQuyen() {
        return tenNhomQuyen;
    }

    /**
     * Sets the value of the tenNhomQuyen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenNhomQuyen(String value) {
        this.tenNhomQuyen = value;
    }

}
