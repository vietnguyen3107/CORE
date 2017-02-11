
package com.lb.jwitter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for gettbl_Quyen_NhomQuyenResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="gettbl_Quyen_NhomQuyenResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://service.jwitter.lb.com/}tblQuyenNhomQuyen" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gettbl_Quyen_NhomQuyenResponse", propOrder = {
    "_return"
})
public class GettblQuyenNhomQuyenResponse {

    @XmlElement(name = "return")
    protected TblQuyenNhomQuyen _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link TblQuyenNhomQuyen }
     *     
     */
    public TblQuyenNhomQuyen getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link TblQuyenNhomQuyen }
     *     
     */
    public void setReturn(TblQuyenNhomQuyen value) {
        this._return = value;
    }

}
