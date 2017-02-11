
package com.lb.jwitter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tblQLDTHTMLReportParam complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tblQLDTHTMLReportParam">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paramSql" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paramVariable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportId" type="{http://service.jwitter.lb.com/}tblQLDTHTMLReport" minOccurs="0"/>
 *         &lt;element name="ten" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tblQLDTHTMLReportParam", propOrder = {
    "id",
    "label",
    "paramSql",
    "paramVariable",
    "reportId",
    "ten",
    "type"
})
public class TblQLDTHTMLReportParam {

    protected Long id;
    protected String label;
    protected String paramSql;
    protected String paramVariable;
    protected TblQLDTHTMLReport reportId;
    protected String ten;
    protected String type;

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
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the paramSql property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParamSql() {
        return paramSql;
    }

    /**
     * Sets the value of the paramSql property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParamSql(String value) {
        this.paramSql = value;
    }

    /**
     * Gets the value of the paramVariable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParamVariable() {
        return paramVariable;
    }

    /**
     * Sets the value of the paramVariable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParamVariable(String value) {
        this.paramVariable = value;
    }

    /**
     * Gets the value of the reportId property.
     * 
     * @return
     *     possible object is
     *     {@link TblQLDTHTMLReport }
     *     
     */
    public TblQLDTHTMLReport getReportId() {
        return reportId;
    }

    /**
     * Sets the value of the reportId property.
     * 
     * @param value
     *     allowed object is
     *     {@link TblQLDTHTMLReport }
     *     
     */
    public void setReportId(TblQLDTHTMLReport value) {
        this.reportId = value;
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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
