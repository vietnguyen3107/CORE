
package com.lb.jwitter.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.0.9
 * Wed Feb 08 16:23:07 ICT 2017
 * Generated source version: 2.0.9
 * 
 */

@WebService(targetNamespace = "http://service.jwitter.lb.com/", name = "Tbl_DonViService")

public interface TblDonViService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findColumnTbl_DonViByCondition", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindColumnTblDonViByCondition")
    @ResponseWrapper(localName = "findColumnTbl_DonViByConditionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindColumnTblDonViByConditionResponse")
    @WebMethod(operationName = "findColumnTbl_DonViByCondition")
    public java.util.List<java.lang.Object> findColumnTblDonViByCondition(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.lb.jwitter.service.ConditionReport> arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.util.List<java.lang.String> arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3
    );

    @RequestWrapper(localName = "deleteListTbl_DonVi", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeleteListTblDonVi")
    @ResponseWrapper(localName = "deleteListTbl_DonViResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeleteListTblDonViResponse")
    @WebMethod(operationName = "deleteListTbl_DonVi")
    public void deleteListTblDonVi(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<java.lang.String> arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findAllTbl_DonVi", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindAllTblDonVi")
    @ResponseWrapper(localName = "findAllTbl_DonViResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindAllTblDonViResponse")
    @WebMethod(operationName = "findAllTbl_DonVi")
    public java.util.List<com.lb.jwitter.service.TblDonVi> findAllTblDonVi(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getTbl_DonVi", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.GetTblDonVi")
    @ResponseWrapper(localName = "getTbl_DonViResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.GetTblDonViResponse")
    @WebMethod(operationName = "getTbl_DonVi")
    public com.lb.jwitter.service.TblDonVi getTblDonVi(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findTbl_DonViByCondition", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindTblDonViByCondition")
    @ResponseWrapper(localName = "findTbl_DonViByConditionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindTblDonViByConditionResponse")
    @WebMethod(operationName = "findTbl_DonViByCondition")
    public java.util.List<com.lb.jwitter.service.TblDonVi> findTblDonViByCondition(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.lb.jwitter.service.ConditionReport> arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2
    );

    @RequestWrapper(localName = "updateTbl_DonVi", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.UpdateTblDonVi")
    @ResponseWrapper(localName = "updateTbl_DonViResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.UpdateTblDonViResponse")
    @WebMethod(operationName = "updateTbl_DonVi")
    public void updateTblDonVi(
        @WebParam(name = "arg0", targetNamespace = "")
        com.lb.jwitter.service.TblDonVi arg0
    );

    @RequestWrapper(localName = "deleteTbl_DonVi", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeleteTblDonVi")
    @ResponseWrapper(localName = "deleteTbl_DonViResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeleteTblDonViResponse")
    @WebMethod(operationName = "deleteTbl_DonVi")
    public void deleteTblDonVi(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "countTbl_DonViByCondition", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CountTblDonViByCondition")
    @ResponseWrapper(localName = "countTbl_DonViByConditionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CountTblDonViByConditionResponse")
    @WebMethod(operationName = "countTbl_DonViByCondition")
    public int countTblDonViByCondition(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.lb.jwitter.service.ConditionReport> arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createTbl_DonVi", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CreateTblDonVi")
    @ResponseWrapper(localName = "createTbl_DonViResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CreateTblDonViResponse")
    @WebMethod(operationName = "createTbl_DonVi")
    public java.lang.Long createTblDonVi(
        @WebParam(name = "arg0", targetNamespace = "")
        com.lb.jwitter.service.TblDonVi arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "queryHQLTbl_DonVi", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.QueryHQLTblDonVi")
    @ResponseWrapper(localName = "queryHQLTbl_DonViResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.QueryHQLTblDonViResponse")
    @WebMethod(operationName = "queryHQLTbl_DonVi")
    public java.util.List<com.lb.jwitter.service.TblDonVi> queryHQLTblDonVi(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2
    );
}
