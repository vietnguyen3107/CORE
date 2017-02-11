
package com.lb.jwitter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTbl_QLDTLT_OptionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTbl_QLDTLT_OptionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://service.jwitter.lb.com/}tblQLDTLTOption" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTbl_QLDTLT_OptionResponse", propOrder = {
    "_return"
})
public class GetTblQLDTLTOptionResponse {

    @XmlElement(name = "return")
    protected TblQLDTLTOption _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link TblQLDTLTOption }
     *     
     */
    public TblQLDTLTOption getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link TblQLDTLTOption }
     *     
     */
    public void setReturn(TblQLDTLTOption value) {
        this._return = value;
    }

}
