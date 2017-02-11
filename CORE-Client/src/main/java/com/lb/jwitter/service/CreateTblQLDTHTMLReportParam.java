
package com.lb.jwitter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createTbl_QLDT_HTMLReport_Param complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createTbl_QLDT_HTMLReport_Param">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://service.jwitter.lb.com/}tblQLDTHTMLReportParam" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createTbl_QLDT_HTMLReport_Param", propOrder = {
    "arg0"
})
public class CreateTblQLDTHTMLReportParam {

    protected TblQLDTHTMLReportParam arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link TblQLDTHTMLReportParam }
     *     
     */
    public TblQLDTHTMLReportParam getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TblQLDTHTMLReportParam }
     *     
     */
    public void setArg0(TblQLDTHTMLReportParam value) {
        this.arg0 = value;
    }

}
