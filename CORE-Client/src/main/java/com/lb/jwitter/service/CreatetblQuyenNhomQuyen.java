
package com.lb.jwitter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createtbl_Quyen_NhomQuyen complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createtbl_Quyen_NhomQuyen">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://service.jwitter.lb.com/}tblQuyenNhomQuyen" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createtbl_Quyen_NhomQuyen", propOrder = {
    "arg0"
})
public class CreatetblQuyenNhomQuyen {

    protected TblQuyenNhomQuyen arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link TblQuyenNhomQuyen }
     *     
     */
    public TblQuyenNhomQuyen getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TblQuyenNhomQuyen }
     *     
     */
    public void setArg0(TblQuyenNhomQuyen value) {
        this.arg0 = value;
    }

}
