
package com.lb.jwitter.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by the CXF 2.0.9
 * Fri Feb 10 15:46:41 ICT 2017
 * Generated source version: 2.0.9
 * 
 */

@XmlRootElement(name = "findTbl_DonViByConditionResponse", namespace = "http://service.jwitter.lb.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findTbl_DonViByConditionResponse", namespace = "http://service.jwitter.lb.com/")

public class FindTbl_DonViByConditionResponse {

    @XmlElement(name = "return")
    private java.util.List _return;

    public java.util.List get_return() {
        return this._return;
    }
    
    public void set_return( java.util.List new_return ) {
        this._return = new_return;
    }
    
}
