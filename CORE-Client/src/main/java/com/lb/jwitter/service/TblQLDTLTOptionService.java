
package com.lb.jwitter.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.0.9
 * Mon Sep 05 09:39:26 ICT 2016
 * Generated source version: 2.0.9
 * 
 */

@WebService(targetNamespace = "http://service.jwitter.lb.com/", name = "Tbl_QLDTLT_OptionService")

public interface TblQLDTLTOptionService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "countTbl_QLDTLT_OptionByCondition", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CountTblQLDTLTOptionByCondition")
    @ResponseWrapper(localName = "countTbl_QLDTLT_OptionByConditionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CountTblQLDTLTOptionByConditionResponse")
    @WebMethod(operationName = "countTbl_QLDTLT_OptionByCondition")
    public int countTblQLDTLTOptionByCondition(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.lb.jwitter.service.ConditionReport> arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "queryHQLTbl_QLDTLT_Option", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.QueryHQLTblQLDTLTOption")
    @ResponseWrapper(localName = "queryHQLTbl_QLDTLT_OptionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.QueryHQLTblQLDTLTOptionResponse")
    @WebMethod(operationName = "queryHQLTbl_QLDTLT_Option")
    public java.util.List<com.lb.jwitter.service.TblQLDTLTOption> queryHQLTblQLDTLTOption(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2
    );

    @RequestWrapper(localName = "deleteListTbl_QLDTLT_Option", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeleteListTblQLDTLTOption")
    @ResponseWrapper(localName = "deleteListTbl_QLDTLT_OptionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeleteListTblQLDTLTOptionResponse")
    @WebMethod(operationName = "deleteListTbl_QLDTLT_Option")
    public void deleteListTblQLDTLTOption(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<java.lang.String> arg0
    );

    @RequestWrapper(localName = "updateTbl_QLDTLT_Option", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.UpdateTblQLDTLTOption")
    @ResponseWrapper(localName = "updateTbl_QLDTLT_OptionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.UpdateTblQLDTLTOptionResponse")
    @WebMethod(operationName = "updateTbl_QLDTLT_Option")
    public void updateTblQLDTLTOption(
        @WebParam(name = "arg0", targetNamespace = "")
        com.lb.jwitter.service.TblQLDTLTOption arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findTbl_QLDTLT_OptionByCondition", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindTblQLDTLTOptionByCondition")
    @ResponseWrapper(localName = "findTbl_QLDTLT_OptionByConditionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindTblQLDTLTOptionByConditionResponse")
    @WebMethod(operationName = "findTbl_QLDTLT_OptionByCondition")
    public java.util.List<com.lb.jwitter.service.TblQLDTLTOption> findTblQLDTLTOptionByCondition(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.lb.jwitter.service.ConditionReport> arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findColumnTbl_QLDTLT_OptionByCondition", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindColumnTblQLDTLTOptionByCondition")
    @ResponseWrapper(localName = "findColumnTbl_QLDTLT_OptionByConditionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindColumnTblQLDTLTOptionByConditionResponse")
    @WebMethod(operationName = "findColumnTbl_QLDTLT_OptionByCondition")
    public java.util.List<java.lang.Object> findColumnTblQLDTLTOptionByCondition(
        @WebParam(name = "arg0", targetNamespace = "")
        java.util.List<com.lb.jwitter.service.ConditionReport> arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.util.List<java.lang.String> arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createTbl_QLDTLT_Option", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CreateTblQLDTLTOption")
    @ResponseWrapper(localName = "createTbl_QLDTLT_OptionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CreateTblQLDTLTOptionResponse")
    @WebMethod(operationName = "createTbl_QLDTLT_Option")
    public java.lang.Long createTblQLDTLTOption(
        @WebParam(name = "arg0", targetNamespace = "")
        com.lb.jwitter.service.TblQLDTLTOption arg0
    );

    @RequestWrapper(localName = "deleteTbl_QLDTLT_Option", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeleteTblQLDTLTOption")
    @ResponseWrapper(localName = "deleteTbl_QLDTLT_OptionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.DeleteTblQLDTLTOptionResponse")
    @WebMethod(operationName = "deleteTbl_QLDTLT_Option")
    public void deleteTblQLDTLTOption(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getTbl_QLDTLT_Option", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.GetTblQLDTLTOption")
    @ResponseWrapper(localName = "getTbl_QLDTLT_OptionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.GetTblQLDTLTOptionResponse")
    @WebMethod(operationName = "getTbl_QLDTLT_Option")
    public com.lb.jwitter.service.TblQLDTLTOption getTblQLDTLTOption(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findAllTbl_QLDTLT_Option", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindAllTblQLDTLTOption")
    @ResponseWrapper(localName = "findAllTbl_QLDTLT_OptionResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.FindAllTblQLDTLTOptionResponse")
    @WebMethod(operationName = "findAllTbl_QLDTLT_Option")
    public java.util.List<com.lb.jwitter.service.TblQLDTLTOption> findAllTblQLDTLTOption(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1
    );
}