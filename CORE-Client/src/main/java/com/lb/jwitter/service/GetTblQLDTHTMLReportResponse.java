
package com.lb.jwitter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTbl_QLDT_HTMLReportResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTbl_QLDT_HTMLReportResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://service.jwitter.lb.com/}tblQLDTHTMLReport" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTbl_QLDT_HTMLReportResponse", propOrder = {
    "_return"
})
public class GetTblQLDTHTMLReportResponse {

    @XmlElement(name = "return")
    protected TblQLDTHTMLReport _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link TblQLDTHTMLReport }
     *     
     */
    public TblQLDTHTMLReport getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link TblQLDTHTMLReport }
     *     
     */
    public void setReturn(TblQLDTHTMLReport value) {
        this._return = value;
    }

}
