
package com.lb.jwitter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tblQLDTHTMLReport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tblQLDTHTMLReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="body" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bodySql" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="css" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fileTemplate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="footer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="header" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="headerSql" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="javascript" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ma" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "tblQLDTHTMLReport", propOrder = {
    "body",
    "bodySql",
    "css",
    "description",
    "fileTemplate",
    "footer",
    "header",
    "headerSql",
    "id",
    "javascript",
    "ma",
    "ten",
    "type"
})
public class TblQLDTHTMLReport {

    protected String body;
    protected String bodySql;
    protected String css;
    protected String description;
    protected String fileTemplate;
    protected String footer;
    protected String header;
    protected String headerSql;
    protected Long id;
    protected String javascript;
    protected String ma;
    protected String ten;
    protected String type;

    /**
     * Gets the value of the body property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBody(String value) {
        this.body = value;
    }

    /**
     * Gets the value of the bodySql property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBodySql() {
        return bodySql;
    }

    /**
     * Sets the value of the bodySql property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBodySql(String value) {
        this.bodySql = value;
    }

    /**
     * Gets the value of the css property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCss() {
        return css;
    }

    /**
     * Sets the value of the css property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCss(String value) {
        this.css = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the fileTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileTemplate() {
        return fileTemplate;
    }

    /**
     * Sets the value of the fileTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileTemplate(String value) {
        this.fileTemplate = value;
    }

    /**
     * Gets the value of the footer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFooter() {
        return footer;
    }

    /**
     * Sets the value of the footer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFooter(String value) {
        this.footer = value;
    }

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeader(String value) {
        this.header = value;
    }

    /**
     * Gets the value of the headerSql property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeaderSql() {
        return headerSql;
    }

    /**
     * Sets the value of the headerSql property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeaderSql(String value) {
        this.headerSql = value;
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
     * Gets the value of the javascript property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJavascript() {
        return javascript;
    }

    /**
     * Sets the value of the javascript property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJavascript(String value) {
        this.javascript = value;
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
