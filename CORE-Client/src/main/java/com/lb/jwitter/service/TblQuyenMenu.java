
package com.lb.jwitter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tblQuyenMenu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tblQuyenMenu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="choPhep" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="menuId" type="{http://service.jwitter.lb.com/}tblMenu" minOccurs="0"/>
 *         &lt;element name="quyenId" type="{http://service.jwitter.lb.com/}tblQuyen" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tblQuyenMenu", propOrder = {
    "choPhep",
    "id",
    "menuId",
    "quyenId"
})
public class TblQuyenMenu {

    protected Boolean choPhep;
    protected Long id;
    protected TblMenu menuId;
    protected TblQuyen quyenId;

    /**
     * Gets the value of the choPhep property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isChoPhep() {
        return choPhep;
    }

    /**
     * Sets the value of the choPhep property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setChoPhep(Boolean value) {
        this.choPhep = value;
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
     * Gets the value of the menuId property.
     * 
     * @return
     *     possible object is
     *     {@link TblMenu }
     *     
     */
    public TblMenu getMenuId() {
        return menuId;
    }

    /**
     * Sets the value of the menuId property.
     * 
     * @param value
     *     allowed object is
     *     {@link TblMenu }
     *     
     */
    public void setMenuId(TblMenu value) {
        this.menuId = value;
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

}
