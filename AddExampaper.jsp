<%@page import="com.pojo.Testseries"%>
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
	List<Testseries> testlist=bl.ListAllTestseries();
	session.setAttribute("tslist", testlist);
%>
<a href="ViewAllExampapers.jsp">View All Question</a>
<hr><br>
<a href="TViewResults.jsp">View Candidate Results</a>
<hr>

Add Question Details Below..<hr><br><br>
<form action="SaveExampaper" method="post">

	Question No.:<input type="text" name="questionno"><br>
	Standard:<input type="text" name="std"><br>
	Question:<input type="text" name="question"><br>
	Correct Answer:<input type="text" name="ans"><br>
	Choice 1:<input type="text" name="ch1"><br>
	Choice 2:<input type="text" name="ch2"><br>
	Choice 3:<input type="text" name="ch3"><br>
	Choice 4:<input type="text" name="ch4"><br>
	Choice 5:<input type="text" name="ch5"><br> 
	Marks:<input type="text" name="questionmarks"><br>
	Test Series:<select name="tsname">
				<option>Select Test Series</option>
				<c:forEach items="${sessionScope.tslist}" var="ts">
					<option>${ts.tsname }</option>
				</c:forEach>
			</select><br><br>

	<input type="submit" value="Add">
</form>
</body>
</html>