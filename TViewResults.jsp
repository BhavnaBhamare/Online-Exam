<%@page import="com.pojo.Score"%>
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
	List<Score> slist=bl.ListAllScore();
	session.setAttribute("slist", slist);
%>

<table>
	<tr>
		<th>sid</th>
		<th>Cid</th>
		<th>Score</th>
		<th>Test Series</th>
	</tr>
	<c:forEach items="${sessionScope.slist}" var="s">
	<tr>
		<td>${s.sid }</td>
		<td>${s.candidate.cid }</td>
		<td>${s.testseries.tsname }</td>
		<td>${s.score }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>