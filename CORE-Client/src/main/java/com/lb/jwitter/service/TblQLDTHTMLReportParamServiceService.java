
package com.lb.jwitter.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import com.lb.jwitter.service.TblQLDTHTMLReportParamService;

/**
 * This class was generated by Apache CXF 2.0.9
 * Mon Sep 05 09:39:18 ICT 2016
 * Generated source version: 2.0.9
 * 
 */

@WebServiceClient(name = "Tbl_QLDT_HTMLReport_ParamServiceService", 
                  wsdlLocation = "file:/C:/PROJECT/VIET%20SOLUTION/CODE%20MAU/WEB%20SERVICE/CORE-Client/src/main/resources/wsdl/core/Tbl_QLDT_HTMLReport_ParamService.wsdl",
                  targetNamespace = "http://service.jwitter.lb.com/") 
public class TblQLDTHTMLReportParamServiceService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://service.jwitter.lb.com/", "Tbl_QLDT_HTMLReport_ParamServiceService");
    public final static QName TblQLDTHTMLReportParamServicePort = new QName("http://service.jwitter.lb.com/", "Tbl_QLDT_HTMLReport_ParamServicePort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/PROJECT/VIET%20SOLUTION/CODE%20MAU/WEB%20SERVICE/CORE-Client/src/main/resources/wsdl/core/Tbl_QLDT_HTMLReport_ParamService.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from file:/C:/PROJECT/VIET%20SOLUTION/CODE%20MAU/WEB%20SERVICE/CORE-Client/src/main/resources/wsdl/core/Tbl_QLDT_HTMLReport_ParamService.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public TblQLDTHTMLReportParamServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TblQLDTHTMLReportParamServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TblQLDTHTMLReportParamServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns TblQLDTHTMLReportParamServicePort
     */
    @WebEndpoint(name = "Tbl_QLDT_HTMLReport_ParamServicePort")
    public TblQLDTHTMLReportParamService getTblQLDTHTMLReportParamServicePort() {
        return super.getPort(TblQLDTHTMLReportParamServicePort, TblQLDTHTMLReportParamService.class);
    }

}