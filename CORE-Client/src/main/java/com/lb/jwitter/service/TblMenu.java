
package com.lb.jwitter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tblMenu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tblMenu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hinh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="menuCha" type="{http://service.jwitter.lb.com/}tblMenu" minOccurs="0"/>
 *         &lt;element name="menuId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nhom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STT" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ten" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tblMenu", propOrder = {
    "hinh",
    "id",
    "menuCha",
    "menuId",
    "nhom",
    "stt",
    "ten",
    "url"
})
public class TblMenu {

    protected String hinh;
    protected Long id;
    protected TblMenu menuCha;
    protected String menuId;
    protected String nhom;
    @XmlElement(name = "STT")
    protected Integer stt;
    protected String ten;
    protected String url;

    /**
     * Gets the value of the hinh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHinh() {
        return hinh;
    }

    /**
     * Sets the value of the hinh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHinh(String value) {
        this.hinh = value;
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
     * Gets the value of the menuCha property.
     * 
     * @return
     *     possible object is
     *     {@link TblMenu }
     *     
     */
    public TblMenu getMenuCha() {
        return menuCha;
    }

    /**
     * Sets the value of the menuCha property.
     * 
     * @param value
     *     allowed object is
     *     {@link TblMenu }
     *     
     */
    public void setMenuCha(TblMenu value) {
        this.menuCha = value;
    }

    /**
     * Gets the value of the menuId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * Sets the value of the menuId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMenuId(String value) {
        this.menuId = value;
    }

    /**
     * Gets the value of the nhom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNhom() {
        return nhom;
    }

    /**
     * Sets the value of the nhom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNhom(String value) {
        this.nhom = value;
    }

    /**
     * Gets the value of the stt property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSTT() {
        return stt;
    }

    /**
     * Sets the value of the stt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSTT(Integer value) {
        this.stt = value;
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
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

}
