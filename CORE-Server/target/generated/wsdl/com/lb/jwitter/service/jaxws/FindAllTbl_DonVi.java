
package com.lb.jwitter.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by the CXF 2.0.9
 * Fri Feb 10 15:46:40 ICT 2017
 * Generated source version: 2.0.9
 * 
 */

@XmlRootElement(name = "findAllTbl_DonVi", namespace = "http://service.jwitter.lb.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findAllTbl_DonVi", namespace = "http://service.jwitter.lb.com/")

public class FindAllTbl_DonVi {

    @XmlElement(name = "arg0")
    private int arg0;
    @XmlElement(name = "arg1")
    private int arg1;

    public int getArg0() {
        return this.arg0;
    }
    
    public void setArg0( int newArg0 ) {
        this.arg0 = newArg0;
    }
    
    public int getArg1() {
        return this.arg1;
    }
    
    public void setArg1( int newArg1 ) {
        this.arg1 = newArg1;
    }
    
}

