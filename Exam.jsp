<%@page import="com.pojo.Exampaper"%>
<%@page import="java.util.List"%>
<%@page import="com.pojo.Candidate"%>
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
int cid=(Integer)session.getAttribute("cid");
// int cid=Integer.parseInt(scid);
BLManager bl=new BLManager();
Candidate c=bl.SearchCandidateById(cid);
List<Exampaper> exlist=bl.prepareExam(c);

session.setAttribute("exampaperlist", exlist);
%>

	<table border="2">
		<tr>
<!-- 			<th>Eid</th> -->
			<th>Qno</th>
<!-- 			<th>Standard</th> -->
			<th>Question</th>
<!-- 			<th>Choice1</th> -->
<!-- 			<th>Choice2</th> -->
<!-- 			<th>Choice3</th> -->
<!-- 			<th>Choice4</th> -->
<!-- 			<th>Choice5</th> -->
<!-- 			<th>Answer</th> -->
			<th>Testseries</th>
			<th>Marks</th>
			<th>View</th>
		</tr>
		
		<c:forEach items="${sessionScope.exampaperlist }" var="exl">
		<tr>
<%-- 			<td>${esl.eid }</td> --%>
			<td>${exl.questionno }</td>
<%-- 			<td>${exl.std }</td> --%>
			<td>${exl.question }</td>
<%-- 			<td>${exl.ch1 }</td> --%>
<%-- 			<td>${exl.ch2 }</td> --%>
<%-- 			<td>${exl.ch3 }</td> --%>
<%-- 			<td>${exl.ch4 }</td> --%>
<%-- 			<td>${exl.ch5 }</td> --%>
<%-- 			<td>${exl.ans }</td> --%>
			<td>${exl.testseries.getTsname() }</td>
			<td>${exl.questionmarks }</td>
			<td>
					<a href="ViewQuestion.jsp?eid=${exl.eid }">View</a>

			</td>
		</tr>
		</c:forEach>
	</table>
<a href="GenerateResult"><input type="submit" value="Submit Exam"></a>

</body>
</html>

