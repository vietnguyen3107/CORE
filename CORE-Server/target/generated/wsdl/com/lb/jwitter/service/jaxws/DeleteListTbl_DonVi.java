
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

@XmlRootElement(name = "deleteListTbl_DonVi", namespace = "http://service.jwitter.lb.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteListTbl_DonVi", namespace = "http://service.jwitter.lb.com/")

public class DeleteListTbl_DonVi {

    @XmlElement(name = "arg0")
    private String[] arg0;

    public String[] getArg0() {
        return this.arg0;
    }
    
    public void setArg0( String[] newArg0 ) {
        this.arg0 = newArg0;
    }
    
}
