<%@page import="com.pojo.Exampaper"%>
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
	
// 	Exampaper ex1=(Exampaper)session.getAttribute("ex");
// 	Testseries ts1=ex1.getTestseries();
// 	session.setAttribute("testseriesname", ts1);
%>
<!-- <a href="ViewAllQuestions.jsp">View All Question</a> -->
<hr>
Add Question Details Below..<hr><br><br>
<form action="UpdateExampaper" method="post">
	
	<input type="hidden" name="eid" value="${ex.eid }">
	<input type="hidden" name="questionno" value="${ex.questionno }"><br>
	Standard:<input type="text" name="std" value="${ex.std }"><br>
	Question:<input type="text" name="question" value="${ex.question }"><br>
	Correct Answer:<input type="text" name="ans" value="${ex.ans }"><br>
	Choice 1:<input type="text" name="ch1" value="${ex.ch1 }"><br>
	Choice 2:<input type="text" name="ch2" value="${ex.ch2 }"><br>
	Choice 3:<input type="text" name="ch3" value="${ex.ch3 }"><br>
	Choice 4:<input type="text" name="ch4" value="${ex.ch4 }"><br>
	Choice 5:<input type="text" name="ch5" value="${ex.ch5 }"><br> 
	Marks:<input type="text" name="questionmarks" value="${ex.questionmarks }"><br>
	Test Series:<select name="tsname" >
				<option selected="selected">${ex.testseries.tsname }</option>
				<c:forEach items="${sessionScope.tslist}" var="ts">
					<option>${ts.tsname }</option>
				</c:forEach>
			</select><br><br>
	<input type="submit" value="Update">
</form>
</body>
</html>