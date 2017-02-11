
package com.lb.jwitter.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.0.9
 * Mon Sep 05 09:39:20 ICT 2016
 * Generated source version: 2.0.9
 * 
 */

@WebService(targetNamespace = "http://service.jwitter.lb.com/", name = "Tbl_QLDT_ConfigService")

public interface TblQLDTConfigService {

    @RequestWrapper(localName = "deleteListtbl_QLDT_Config", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeleteListtblQLDTConfig")
    @ResponseWrapper(localName = "deleteListtbl_QLDT_ConfigResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeleteListtblQLDTConfigResponse")
    @WebMethod(operationName = "deleteListtbl_QLDT_Config")
    public void deleteListtblQLDTConfig(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<java.lang.String> arg0
    );

    @RequestWrapper(localName = "deletetbl_QLDT_Config", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeletetblQLDTConfig")
    @ResponseWrapper(localName = "deletetbl_QLDT_ConfigResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeletetblQLDTConfigResponse")
    @WebMethod(operationName = "deletetbl_QLDT_Config")
    public void deletetblQLDTConfig(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createtbl_QLDT_Config", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CreatetblQLDTConfig")
    @ResponseWrapper(localName = "createtbl_QLDT_ConfigResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CreatetblQLDTConfigResponse")
    @WebMethod(operationName = "createtbl_QLDT_Config")
    public java.lang.Long createtblQLDTConfig(
        @WebParam(name = "arg0", targetNamespace = "")
        com.lb.jwitter.service.TblQLDTConfig arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findAlltbl_QLDT_Config", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindAlltblQLDTConfig")
    @ResponseWrapper(localName = "findAlltbl_QLDT_ConfigResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindAlltblQLDTConfigResponse")
    @WebMethod(operationName = "findAlltbl_QLDT_Config")
    public java.util.List<com.lb.jwitter.service.TblQLDTConfig> findAlltblQLDTConfig(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "counttbl_QLDT_ConfigByCondition", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CounttblQLDTConfigByCondition")
    @ResponseWrapper(localName = "counttbl_QLDT_ConfigByConditionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CounttblQLDTConfigByConditionResponse")
    @WebMethod(operationName = "counttbl_QLDT_ConfigByCondition")
    public int counttblQLDTConfigByCondition(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.lb.jwitter.service.ConditionReport> arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "gettbl_QLDT_Config", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.GettblQLDTConfig")
    @ResponseWrapper(localName = "gettbl_QLDT_ConfigResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.GettblQLDTConfigResponse")
    @WebMethod(operationName = "gettbl_QLDT_Config")
    public com.lb.jwitter.service.TblQLDTConfig gettblQLDTConfig(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findColumntbl_QLDT_ConfigByCondition", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindColumntblQLDTConfigByCondition")
    @ResponseWrapper(localName = "findColumntbl_QLDT_ConfigByConditionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindColumntblQLDTConfigByConditionResponse")
    @WebMethod(operationName = "findColumntbl_QLDT_ConfigByCondition")
    public java.util.List<java.lang.Object> findColumntblQLDTConfigByCondition(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.lb.jwitter.service.ConditionReport> arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.util.List<java.lang.String> arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3
    );

    @RequestWrapper(localName = "updatetbl_QLDT_Config", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.UpdatetblQLDTConfig")
    @ResponseWrapper(localName = "updatetbl_QLDT_ConfigResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.UpdatetblQLDTConfigResponse")
    @WebMethod(operationName = "updatetbl_QLDT_Config")
    public void updatetblQLDTConfig(
        @WebParam(name = "arg0", targetNamespace = "")
        com.lb.jwitter.service.TblQLDTConfig arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findtbl_QLDT_ConfigByCondition", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindtblQLDTConfigByCondition")
    @ResponseWrapper(localName = "findtbl_QLDT_ConfigByConditionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindtblQLDTConfigByConditionResponse")
    @WebMethod(operationName = "findtbl_QLDT_ConfigByCondition")
    public java.util.List<com.lb.jwitter.service.TblQLDTConfig> findtblQLDTConfigByCondition(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.lb.jwitter.service.ConditionReport> arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2
    );
}