
package com.lb.jwitter.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import com.lb.jwitter.service.TblQuyenService;

/**
 * This class was generated by Apache CXF 2.0.9
 * Mon Sep 05 09:39:23 ICT 2016
 * Generated source version: 2.0.9
 * 
 */

@WebServiceClient(name = "Tbl_QuyenServiceService", 
                  wsdlLocation = "file:/C:/PROJECT/VIET%20SOLUTION/CODE%20MAU/WEB%20SERVICE/CORE-Client/src/main/resources/wsdl/core/Tbl_QuyenService.wsdl",
                  targetNamespace = "http://service.jwitter.lb.com/") 
public class TblQuyenServiceService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://service.jwitter.lb.com/", "Tbl_QuyenServiceService");
    public final static QName TblQuyenServicePort = new QName("http://service.jwitter.lb.com/", "Tbl_QuyenServicePort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/PROJECT/VIET%20SOLUTION/CODE%20MAU/WEB%20SERVICE/CORE-Client/src/main/resources/wsdl/core/Tbl_QuyenService.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from file:/C:/PROJECT/VIET%20SOLUTION/CODE%20MAU/WEB%20SERVICE/CORE-Client/src/main/resources/wsdl/core/Tbl_QuyenService.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public TblQuyenServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TblQuyenServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TblQuyenServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns TblQuyenServicePort
     */
    @WebEndpoint(name = "Tbl_QuyenServicePort")
    public TblQuyenService getTblQuyenServicePort() {
        return super.getPort(TblQuyenServicePort, TblQuyenService.class);
    }

}
