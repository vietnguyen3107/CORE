
package com.lb.jwitter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTbl_QLDT_HTMLReport_ParamResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTbl_QLDT_HTMLReport_ParamResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://service.jwitter.lb.com/}tblQLDTHTMLReportParam" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTbl_QLDT_HTMLReport_ParamResponse", propOrder = {
    "_return"
})
public class GetTblQLDTHTMLReportParamResponse {

    @XmlElement(name = "return")
    protected TblQLDTHTMLReportParam _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link TblQLDTHTMLReportParam }
     *     
     */
    public TblQLDTHTMLReportParam getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link TblQLDTHTMLReportParam }
     *     
     */
    public void setReturn(TblQLDTHTMLReportParam value) {
        this._return = value;
    }

}
