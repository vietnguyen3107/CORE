
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

@XmlRootElement(name = "createtbl_QLDT_Config", namespace = "http://service.jwitter.lb.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createtbl_QLDT_Config", namespace = "http://service.jwitter.lb.com/")

public class Createtbl_QLDT_Config {

    @XmlElement(name = "arg0")
    private com.lb.jwitter.core.Tbl_QLDT_Config arg0;

    public com.lb.jwitter.core.Tbl_QLDT_Config getArg0() {
        return this.arg0;
    }
    
    public void setArg0( com.lb.jwitter.core.Tbl_QLDT_Config newArg0 ) {
        this.arg0 = newArg0;
    }
    
}

