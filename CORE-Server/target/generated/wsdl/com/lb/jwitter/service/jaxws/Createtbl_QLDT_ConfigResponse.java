
package com.lb.jwitter.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by the CXF 2.0.9
 * Wed Feb 08 16:11:51 ICT 2017
 * Generated source version: 2.0.9
 * 
 */

@XmlRootElement(name = "createtbl_QLDT_ConfigResponse", namespace = "http://service.jwitter.lb.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createtbl_QLDT_ConfigResponse", namespace = "http://service.jwitter.lb.com/")

public class Createtbl_QLDT_ConfigResponse {

    @XmlElement(name = "return")
    private java.lang.Long _return;

    public java.lang.Long get_return() {
        return this._return;
    }
    
    public void set_return( java.lang.Long new_return ) {
        this._return = new_return;
    }
    
}

