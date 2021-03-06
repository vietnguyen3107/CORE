
package com.lb.jwitter.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.0.9
 * Mon Sep 05 09:39:23 ICT 2016
 * Generated source version: 2.0.9
 * 
 */

@WebService(targetNamespace = "http://service.jwitter.lb.com/", name = "Tbl_MenuService")

public interface TblMenuService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "gettbl_Menu", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.GettblMenu")
    @ResponseWrapper(localName = "gettbl_MenuResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.GettblMenuResponse")
    @WebMethod(operationName = "gettbl_Menu")
    public com.lb.jwitter.service.TblMenu gettblMenu(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "counttbl_MenuByCondition", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CounttblMenuByCondition")
    @ResponseWrapper(localName = "counttbl_MenuByConditionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CounttblMenuByConditionResponse")
    @WebMethod(operationName = "counttbl_MenuByCondition")
    public int counttblMenuByCondition(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.lb.jwitter.service.ConditionReport> arg0
    );

    @RequestWrapper(localName = "updatetbl_Menu", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.UpdatetblMenu")
    @ResponseWrapper(localName = "updatetbl_MenuResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.UpdatetblMenuResponse")
    @WebMethod(operationName = "updatetbl_Menu")
    public void updatetblMenu(
        @WebParam(name = "arg0", targetNamespace = "")
        com.lb.jwitter.service.TblMenu arg0
    );

    @RequestWrapper(localName = "deletetbl_Menu", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeletetblMenu")
    @ResponseWrapper(localName = "deletetbl_MenuResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeletetblMenuResponse")
    @WebMethod(operationName = "deletetbl_Menu")
    public void deletetblMenu(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findAlltbl_Menu", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindAlltblMenu")
    @ResponseWrapper(localName = "findAlltbl_MenuResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindAlltblMenuResponse")
    @WebMethod(operationName = "findAlltbl_Menu")
    public java.util.List<com.lb.jwitter.service.TblMenu> findAlltblMenu(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1
    );

    @RequestWrapper(localName = "deleteListtbl_Menu", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeleteListtblMenu")
    @ResponseWrapper(localName = "deleteListtbl_MenuResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeleteListtblMenuResponse")
    @WebMethod(operationName = "deleteListtbl_Menu")
    public void deleteListtblMenu(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<java.lang.String> arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createtbl_Menu", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CreatetblMenu")
    @ResponseWrapper(localName = "createtbl_MenuResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CreatetblMenuResponse")
    @WebMethod(operationName = "createtbl_Menu")
    public java.lang.Long createtblMenu(
        @WebParam(name = "arg0", targetNamespace = "")
        com.lb.jwitter.service.TblMenu arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findtbl_MenuByCondition", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindtblMenuByCondition")
    @ResponseWrapper(localName = "findtbl_MenuByConditionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindtblMenuByConditionResponse")
    @WebMethod(operationName = "findtbl_MenuByCondition")
    public java.util.List<com.lb.jwitter.service.TblMenu> findtblMenuByCondition(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.lb.jwitter.service.ConditionReport> arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2
    );
}
