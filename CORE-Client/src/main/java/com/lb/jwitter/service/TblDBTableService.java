
package com.lb.jwitter.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.0.9
 * Mon Sep 05 09:39:24 ICT 2016
 * Generated source version: 2.0.9
 * 
 */

@WebService(targetNamespace = "http://service.jwitter.lb.com/", name = "Tbl_DBTableService")

public interface TblDBTableService {

    @RequestWrapper(localName = "updatetbl_DBTable", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.UpdatetblDBTable")
    @ResponseWrapper(localName = "updatetbl_DBTableResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.UpdatetblDBTableResponse")
    @WebMethod(operationName = "updatetbl_DBTable")
    public void updatetblDBTable(
        @WebParam(name = "arg0", targetNamespace = "")
        com.lb.jwitter.service.TblDBTable arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "gettbl_DBTable", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.GettblDBTable")
    @ResponseWrapper(localName = "gettbl_DBTableResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.GettblDBTableResponse")
    @WebMethod(operationName = "gettbl_DBTable")
    public com.lb.jwitter.service.TblDBTable gettblDBTable(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findAlltbl_DBTable", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindAlltblDBTable")
    @ResponseWrapper(localName = "findAlltbl_DBTableResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindAlltblDBTableResponse")
    @WebMethod(operationName = "findAlltbl_DBTable")
    public java.util.List<com.lb.jwitter.service.TblDBTable> findAlltblDBTable(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "counttbl_DBTableByCondition", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CounttblDBTableByCondition")
    @ResponseWrapper(localName = "counttbl_DBTableByConditionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CounttblDBTableByConditionResponse")
    @WebMethod(operationName = "counttbl_DBTableByCondition")
    public int counttblDBTableByCondition(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.lb.jwitter.service.ConditionReport> arg0
    );

    @RequestWrapper(localName = "deleteListtbl_DBTable", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeleteListtblDBTable")
    @ResponseWrapper(localName = "deleteListtbl_DBTableResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeleteListtblDBTableResponse")
    @WebMethod(operationName = "deleteListtbl_DBTable")
    public void deleteListtblDBTable(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<java.lang.String> arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findtbl_DBTableByCondition", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindtblDBTableByCondition")
    @ResponseWrapper(localName = "findtbl_DBTableByConditionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindtblDBTableByConditionResponse")
    @WebMethod(operationName = "findtbl_DBTableByCondition")
    public java.util.List<com.lb.jwitter.service.TblDBTable> findtblDBTableByCondition(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.lb.jwitter.service.ConditionReport> arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2
    );

    @RequestWrapper(localName = "deletetbl_DBTable", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeletetblDBTable")
    @ResponseWrapper(localName = "deletetbl_DBTableResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeletetblDBTableResponse")
    @WebMethod(operationName = "deletetbl_DBTable")
    public void deletetblDBTable(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createtbl_DBTable", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CreatetblDBTable")
    @ResponseWrapper(localName = "createtbl_DBTableResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CreatetblDBTableResponse")
    @WebMethod(operationName = "createtbl_DBTable")
    public java.lang.Long createtblDBTable(
        @WebParam(name = "arg0", targetNamespace = "")
        com.lb.jwitter.service.TblDBTable arg0
    );
}
