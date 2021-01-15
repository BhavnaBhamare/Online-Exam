<%@page import="com.pojo.Exampaper"%>
<%@page import="java.util.List"%>
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
	BLManager bl=new BLManager();
	List<Exampaper> exlist=bl.ListAllExampaper();
	session.setAttribute("exlist", exlist);
%>
<br>
<a href="AddExampaper.jsp">Add More Questions</a>
<hr><br>
<table border="2">
	<tr>
		<th>Eid</th>
		<th>Standard</th>
		<th>Qno</th>
		<th>Question</th>
		<th>Ch1</th>
		<th>Ch2</th>
		<th>Ch3</th>
		<th>Ch4</th>
		<th>Ch5</th>
		<th>Correct Answer</th>
		<th>Test Series</th>
		<th>Marks</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${sessionScope.exlist}" var="ex">
		<tr>
			<td>${ex.eid }</td>
			<td>${ex.std }</td>
			<td>${ex.questionno }</td>
			<td>${ex.question }</td>
			<td>${ex.ch1 }</td>
			<td>${ex.ch2 }</td>
			<td>${ex.ch3 }</td>
			<td>${ex.ch4 }</td>
			<td>${ex.ch5 }</td>
			<td>${ex.ans }</td>
			<td>${ex.testseries.getTsname() }</td>
			<td>${ex.questionmarks }</td>	
			<td><a href="UpdateExampaper?eid=${ex.eid}">Update</a></td>
			<td><a href="DeleteExampaper?eid=${ex.eid}">Delete</a></td>		
		</tr>
	</c:forEach>
</table>
</body>
</html>