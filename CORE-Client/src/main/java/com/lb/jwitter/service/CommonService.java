
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

@WebService(targetNamespace = "http://service.jwitter.lb.com/", name = "CommonService")

public interface CommonService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "query_SQL_WithParams_AliasTransformer", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.QuerySQLWithParamsAliasTransformer")
    @ResponseWrapper(localName = "query_SQL_WithParams_AliasTransformerResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.QuerySQLWithParamsAliasTransformerResponse")
    @WebMethod(operationName = "query_SQL_WithParams_AliasTransformer")
    public java.util.List<com.lb.jwitter.service.Qresult> querySQLWithParamsAliasTransformer(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.util.List<java.lang.String> arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.util.List<java.lang.Object> arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        int arg4
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "query_HQL_WithParams_AliasTransformer", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.QueryHQLWithParamsAliasTransformer")
    @ResponseWrapper(localName = "query_HQL_WithParams_AliasTransformerResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.QueryHQLWithParamsAliasTransformerResponse")
    @WebMethod(operationName = "query_HQL_WithParams_AliasTransformer")
    public java.util.List<com.lb.jwitter.service.Qresult> queryHQLWithParamsAliasTransformer(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.util.List<java.lang.String> arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.util.List<java.lang.Object> arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        int arg4
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createSQLQueryWithParams", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CreateSQLQueryWithParams")
    @ResponseWrapper(localName = "createSQLQueryWithParamsResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CreateSQLQueryWithParamsResponse")
    @WebMethod
    public java.util.List<com.lb.jwitter.service.Qresult> createSQLQueryWithParams(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.util.List<java.lang.String> arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        java.util.List<java.lang.String> arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        int arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        int arg5
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "queryWithParams", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.QueryWithParams")
    @ResponseWrapper(localName = "queryWithParamsResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.QueryWithParamsResponse")
    @WebMethod
    public java.util.List<com.lb.jwitter.service.Qresult> queryWithParams(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.util.List<java.lang.String> arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        java.util.List<java.lang.String> arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        int arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        int arg5
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "countByHql", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CountByHql")
    @ResponseWrapper(localName = "countByHqlResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.CountByHqlResponse")
    @WebMethod
    public java.lang.Long countByHql(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "executeQuery", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.ExecuteQuery")
    @ResponseWrapper(localName = "executeQueryResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.ExecuteQueryResponse")
    @WebMethod
    public java.lang.Boolean executeQuery(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "query", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.Query")
    @ResponseWrapper(localName = "queryResponse", targetNamespace = "http://service.jwitter.lb.com/", className = "com.lb.jwitter.service.QueryResponse")
    @WebMethod
    public java.util.List<com.lb.jwitter.service.Qresult> query(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3
    );
}
