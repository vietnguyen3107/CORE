
package com.lb.jwitter.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import com.lb.jwitter.service.TblQuyenNhomQuyenService;

/**
 * This class was generated by Apache CXF 2.0.9
 * Mon Sep 05 09:39:21 ICT 2016
 * Generated source version: 2.0.9
 * 
 */

@WebServiceClient(name = "Tbl_Quyen_NhomQuyenServiceService", 
                  wsdlLocation = "file:/C:/PROJECT/VIET%20SOLUTION/CODE%20MAU/WEB%20SERVICE/CORE-Client/src/main/resources/wsdl/core/Tbl_Quyen_NhomQuyenService.wsdl",
                  targetNamespace = "http://service.jwitter.lb.com/") 
public class TblQuyenNhomQuyenServiceService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://service.jwitter.lb.com/", "Tbl_Quyen_NhomQuyenServiceService");
    public final static QName TblQuyenNhomQuyenServicePort = new QName("http://service.jwitter.lb.com/", "Tbl_Quyen_NhomQuyenServicePort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/PROJECT/VIET%20SOLUTION/CODE%20MAU/WEB%20SERVICE/CORE-Client/src/main/resources/wsdl/core/Tbl_Quyen_NhomQuyenService.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from file:/C:/PROJECT/VIET%20SOLUTION/CODE%20MAU/WEB%20SERVICE/CORE-Client/src/main/resources/wsdl/core/Tbl_Quyen_NhomQuyenService.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public TblQuyenNhomQuyenServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TblQuyenNhomQuyenServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TblQuyenNhomQuyenServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns TblQuyenNhomQuyenServicePort
     */
    @WebEndpoint(name = "Tbl_Quyen_NhomQuyenServicePort")
    public TblQuyenNhomQuyenService getTblQuyenNhomQuyenServicePort() {
        return super.getPort(TblQuyenNhomQuyenServicePort, TblQuyenNhomQuyenService.class);
    }

}
