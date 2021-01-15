<%@page import="com.pojo.Exampaper"%>
<%@page import="com.model.BLManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
// 	int cid=(Integer)session.getAttribute("cid");
	BLManager bl =new BLManager();
	String seid=request.getParameter("eid");
	int eid=Integer.parseInt(seid);
	Exampaper exp=bl.SearchExampaperById(eid);
	session.setAttribute("exp1", exp);
%>
<form action="SaveCandidateAns" method="post">
Question No.:${exp1.questionno } 
<input type="hidden" name="questionno" value="${exp1.eid }"><br>
Question:&nbsp;${exp1.question } <br><br>
Options:<br>
<input type="radio" name="ans" id="ch1" value="${exp1.ch1 }">${exp1.ch1 }
<input type="radio" name="ans" id="ch2" value="${exp1.ch2 }">${exp1.ch2 }
<input type="radio" name="ans" id="ch3" value="${exp1.ch3 }">${exp1.ch3 }
<input type="radio" name="ans" id="ch4" value="${exp1.ch4 }">${exp1.ch4 }
<input type="radio" name="ans" id="ch5" value="${exp1.ch5 }">${exp1.ch5 }<br>
<input type="submit" value="Save">
</form>
</body>
</html>