
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

@XmlRootElement(name = "createTbl_DonVi", namespace = "http://service.jwitter.lb.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createTbl_DonVi", namespace = "http://service.jwitter.lb.com/")

public class CreateTbl_DonVi {

    @XmlElement(name = "arg0")
    private com.lb.jwitter.core.Tbl_DonVi arg0;

    public com.lb.jwitter.core.Tbl_DonVi getArg0() {
        return this.arg0;
    }
    
    public void setArg0( com.lb.jwitter.core.Tbl_DonVi newArg0 ) {
        this.arg0 = newArg0;
    }
    
}

