
package com.lb.jwitter.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.0.9
 * Mon Sep 05 09:39:21 ICT 2016
 * Generated source version: 2.0.9
 * 
 */

@WebService(targetNamespace = "http://service.jwitter.lb.com/", name = "Tbl_Quyen_MenuService")

public interface TblQuyenMenuService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createtbl_Quyen_Menu", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CreatetblQuyenMenu")
    @ResponseWrapper(localName = "createtbl_Quyen_MenuResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CreatetblQuyenMenuResponse")
    @WebMethod(operationName = "createtbl_Quyen_Menu")
    public java.lang.Long createtblQuyenMenu(
        @WebParam(name = "arg0", targetNamespace = "")
        com.lb.jwitter.service.TblQuyenMenu arg0
    );

    @RequestWrapper(localName = "deleteListtbl_Quyen_Menu", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeleteListtblQuyenMenu")
    @ResponseWrapper(localName = "deleteListtbl_Quyen_MenuResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeleteListtblQuyenMenuResponse")
    @WebMethod(operationName = "deleteListtbl_Quyen_Menu")
    public void deleteListtblQuyenMenu(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<java.lang.String> arg0
    );

    @RequestWrapper(localName = "updatetbl_Quyen_Menu", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.UpdatetblQuyenMenu")
    @ResponseWrapper(localName = "updatetbl_Quyen_MenuResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.UpdatetblQuyenMenuResponse")
    @WebMethod(operationName = "updatetbl_Quyen_Menu")
    public void updatetblQuyenMenu(
        @WebParam(name = "arg0", targetNamespace = "")
        com.lb.jwitter.service.TblQuyenMenu arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "gettbl_Quyen_Menu", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.GettblQuyenMenu")
    @ResponseWrapper(localName = "gettbl_Quyen_MenuResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.GettblQuyenMenuResponse")
    @WebMethod(operationName = "gettbl_Quyen_Menu")
    public com.lb.jwitter.service.TblQuyenMenu gettblQuyenMenu(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @RequestWrapper(localName = "deletetbl_Quyen_Menu", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeletetblQuyenMenu")
    @ResponseWrapper(localName = "deletetbl_Quyen_MenuResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeletetblQuyenMenuResponse")
    @WebMethod(operationName = "deletetbl_Quyen_Menu")
    public void deletetblQuyenMenu(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findAlltbl_Quyen_Menu", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindAlltblQuyenMenu")
    @ResponseWrapper(localName = "findAlltbl_Quyen_MenuResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindAlltblQuyenMenuResponse")
    @WebMethod(operationName = "findAlltbl_Quyen_Menu")
    public java.util.List<com.lb.jwitter.service.TblQuyenMenu> findAlltblQuyenMenu(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findtbl_Quyen_MenuByNhomQuyen", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindtblQuyenMenuByNhomQuyen")
    @ResponseWrapper(localName = "findtbl_Quyen_MenuByNhomQuyenResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindtblQuyenMenuByNhomQuyenResponse")
    @WebMethod(operationName = "findtbl_Quyen_MenuByNhomQuyen")
    public java.util.List<com.lb.jwitter.service.TblQuyenMenu> findtblQuyenMenuByNhomQuyen(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "counttbl_Quyen_MenuByCondition", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CounttblQuyenMenuByCondition")
    @ResponseWrapper(localName = "counttbl_Quyen_MenuByConditionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CounttblQuyenMenuByConditionResponse")
    @WebMethod(operationName = "counttbl_Quyen_MenuByCondition")
    public int counttblQuyenMenuByCondition(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.lb.jwitter.service.ConditionReport> arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findtbl_Quyen_MenuByCondition", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindtblQuyenMenuByCondition")
    @ResponseWrapper(localName = "findtbl_Quyen_MenuByConditionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindtblQuyenMenuByConditionResponse")
    @WebMethod(operationName = "findtbl_Quyen_MenuByCondition")
    public java.util.List<com.lb.jwitter.service.TblQuyenMenu> findtblQuyenMenuByCondition(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.lb.jwitter.service.ConditionReport> arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2
    );
}
