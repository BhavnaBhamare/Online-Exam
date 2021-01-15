<%@page import="java.util.List"%>
<%@page import="com.pojo.Testseries"%>
<%@page import="com.pojo.Student"%>
<%@page import="com.model.BLManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
// 	String studid=(String)session.getAttribute("sid");
	
	BLManager bl=new BLManager();
	List<Testseries> ts1=bl.ListAllTestseries();
	session.setAttribute("testserieslist", ts1);

%>
<form action="SaveCandidate" method="post">
	Test Series:<select name="tsname">
					<option>Select Test Series</option>
					<c:forEach items="${sessionScope.testserieslist }" var="ts">
						<option>${ts.tsname }</option>
					</c:forEach>
				</select><br>
	Standard:<input type="text" name="standard"><br><br>
	<input type="submit">
</form>
</body>
</html>