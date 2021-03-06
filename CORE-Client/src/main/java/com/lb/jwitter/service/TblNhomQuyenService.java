
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

@WebService(targetNamespace = "http://service.jwitter.lb.com/", name = "Tbl_NhomQuyenService")

public interface TblNhomQuyenService {

    @RequestWrapper(localName = "deletetbl_NhomQuyen", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeletetblNhomQuyen")
    @ResponseWrapper(localName = "deletetbl_NhomQuyenResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeletetblNhomQuyenResponse")
    @WebMethod(operationName = "deletetbl_NhomQuyen")
    public void deletetblNhomQuyen(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findtbl_NhomQuyenByCondition", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindtblNhomQuyenByCondition")
    @ResponseWrapper(localName = "findtbl_NhomQuyenByConditionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindtblNhomQuyenByConditionResponse")
    @WebMethod(operationName = "findtbl_NhomQuyenByCondition")
    public java.util.List<com.lb.jwitter.service.TblNhomQuyen> findtblNhomQuyenByCondition(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.lb.jwitter.service.ConditionReport> arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createtbl_NhomQuyen", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CreatetblNhomQuyen")
    @ResponseWrapper(localName = "createtbl_NhomQuyenResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CreatetblNhomQuyenResponse")
    @WebMethod(operationName = "createtbl_NhomQuyen")
    public java.lang.Long createtblNhomQuyen(
        @WebParam(name = "arg0", targetNamespace = "")
        com.lb.jwitter.service.TblNhomQuyen arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "counttbl_NhomQuyenByCondition", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CounttblNhomQuyenByCondition")
    @ResponseWrapper(localName = "counttbl_NhomQuyenByConditionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CounttblNhomQuyenByConditionResponse")
    @WebMethod(operationName = "counttbl_NhomQuyenByCondition")
    public int counttblNhomQuyenByCondition(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.lb.jwitter.service.ConditionReport> arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findAlltbl_NhomQuyen", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindAlltblNhomQuyen")
    @ResponseWrapper(localName = "findAlltbl_NhomQuyenResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindAlltblNhomQuyenResponse")
    @WebMethod(operationName = "findAlltbl_NhomQuyen")
    public java.util.List<com.lb.jwitter.service.TblNhomQuyen> findAlltblNhomQuyen(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "gettbl_NhomQuyen", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.GettblNhomQuyen")
    @ResponseWrapper(localName = "gettbl_NhomQuyenResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.GettblNhomQuyenResponse")
    @WebMethod(operationName = "gettbl_NhomQuyen")
    public com.lb.jwitter.service.TblNhomQuyen gettblNhomQuyen(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @RequestWrapper(localName = "updatetbl_NhomQuyen", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.UpdatetblNhomQuyen")
    @ResponseWrapper(localName = "updatetbl_NhomQuyenResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.UpdatetblNhomQuyenResponse")
    @WebMethod(operationName = "updatetbl_NhomQuyen")
    public void updatetblNhomQuyen(
        @WebParam(name = "arg0", targetNamespace = "")
        com.lb.jwitter.service.TblNhomQuyen arg0
    );

    @RequestWrapper(localName = "deleteListtbl_NhomQuyen", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeleteListtblNhomQuyen")
    @ResponseWrapper(localName = "deleteListtbl_NhomQuyenResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeleteListtblNhomQuyenResponse")
    @WebMethod(operationName = "deleteListtbl_NhomQuyen")
    public void deleteListtblNhomQuyen(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<java.lang.String> arg0
    );
}
