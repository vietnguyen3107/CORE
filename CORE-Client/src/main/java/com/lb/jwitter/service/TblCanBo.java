
package com.lb.jwitter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tblCanBo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tblCanBo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="diaChi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dienThoai" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="donViId" type="{http://service.jwitter.lb.com/}tblDonVi" minOccurs="0"/>
 *         &lt;element name="ghiChu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="maQuanLy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ngheNghiep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noiLam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noiSinh" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ten" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trinhDo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tblCanBo", propOrder = {
    "diaChi",
    "dienThoai",
    "donViId",
    "ghiChu",
    "id",
    "maQuanLy",
    "ngheNghiep",
    "noiLam",
    "noiSinh",
    "ten",
    "trinhDo"
})
public class TblCanBo {

    protected String diaChi;
    protected String dienThoai;
    protected TblDonVi donViId;
    protected String ghiChu;
    protected Long id;
    protected String maQuanLy;
    protected String ngheNghiep;
    protected String noiLam;
    protected String noiSinh;
    protected String ten;
    protected String trinhDo;

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
     * Gets the value of the dienThoai property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDienThoai() {
        return dienThoai;
    }

    /**
     * Sets the value of the dienThoai property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDienThoai(String value) {
        this.dienThoai = value;
    }

    /**
     * Gets the value of the donViId property.
     * 
     * @return
     *     possible object is
     *     {@link TblDonVi }
     *     
     */
    public TblDonVi getDonViId() {
        return donViId;
    }

    /**
     * Sets the value of the donViId property.
     * 
     * @param value
     *     allowed object is
     *     {@link TblDonVi }
     *     
     */
    public void setDonViId(TblDonVi value) {
        this.donViId = value;
    }

    /**
     * Gets the value of the ghiChu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGhiChu() {
        return ghiChu;
    }

    /**
     * Sets the value of the ghiChu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGhiChu(String value) {
        this.ghiChu = value;
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
     * Gets the value of the maQuanLy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaQuanLy() {
        return maQuanLy;
    }

    /**
     * Sets the value of the maQuanLy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaQuanLy(String value) {
        this.maQuanLy = value;
    }

    /**
     * Gets the value of the ngheNghiep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNgheNghiep() {
        return ngheNghiep;
    }

    /**
     * Sets the value of the ngheNghiep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNgheNghiep(String value) {
        this.ngheNghiep = value;
    }

    /**
     * Gets the value of the noiLam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoiLam() {
        return noiLam;
    }

    /**
     * Sets the value of the noiLam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoiLam(String value) {
        this.noiLam = value;
    }

    /**
     * Gets the value of the noiSinh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoiSinh() {
        return noiSinh;
    }

    /**
     * Sets the value of the noiSinh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoiSinh(String value) {
        this.noiSinh = value;
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
     * Gets the value of the trinhDo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrinhDo() {
        return trinhDo;
    }

    /**
     * Sets the value of the trinhDo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrinhDo(String value) {
        this.trinhDo = value;
    }

}
