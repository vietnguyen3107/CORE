<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="2;url=<s:url includeParams="get" />"/>
<%--
<meta http-equiv="refresh" content="2"/>"/>
Above refresh meta will also work as long as browser supports cookie,
by including params above we are making sure that it will work even when cookies are disabled
 --%>
<title>Processing intermediate page</title>
</head>
<body>
<h3>Hệ thống đang xử lý, vui lòng đợi trong giây lát....</h3>
<img alt="processing" src="images/bigrotation2.gif" align="middle">
</body>
</html>