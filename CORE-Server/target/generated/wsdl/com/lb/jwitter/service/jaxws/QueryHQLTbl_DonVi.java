
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

@XmlRootElement(name = "queryHQLTbl_DonVi", namespace = "http://service.jwitter.lb.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "queryHQLTbl_DonVi", namespace = "http://service.jwitter.lb.com/")

public class QueryHQLTbl_DonVi {

    @XmlElement(name = "arg0")
    private java.lang.String arg0;
    @XmlElement(name = "arg1")
    private int arg1;
    @XmlElement(name = "arg2")
    private int arg2;

    public java.lang.String getArg0() {
        return this.arg0;
    }
    
    public void setArg0( java.lang.String newArg0 ) {
        this.arg0 = newArg0;
    }
    
    public int getArg1() {
        return this.arg1;
    }
    
    public void setArg1( int newArg1 ) {
        this.arg1 = newArg1;
    }
    
    public int getArg2() {
        return this.arg2;
    }
    
    public void setArg2( int newArg2 ) {
        this.arg2 = newArg2;
    }
    
}
