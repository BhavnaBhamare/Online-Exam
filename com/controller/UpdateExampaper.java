package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Exampaper;
import com.pojo.Testseries;

/**
 * Servlet implementation class UpdateExampaper
 */
@WebServlet("/UpdateExampaper")
public class UpdateExampaper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateExampaper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seid=request.getParameter("eid");
		int eid=Integer.parseInt(seid);
		BLManager bl=new BLManager();
		Exampaper ex=bl.SearchExampaperById(eid);
		HttpSession sess=request.getSession();
		sess.setAttribute("ex", ex);
		response.sendRedirect("UpdateExampaper.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String seid=request.getParameter("eid");
		int eid=Integer.parseInt(seid);
		String questionno=request.getParameter("questionno");
		String std=request.getParameter("std");
		String question=request.getParameter("question");
		String ans=request.getParameter("ans");
		String ch1=request.getParameter("ch1");
		String ch2=request.getParameter("ch2");
		String ch3=request.getParameter("ch3");
		String ch4=request.getParameter("ch4");
		String ch5=request.getParameter("ch5");
		String questionmarks=request.getParameter("questionmarks");
		String tsname=request.getParameter("tsname");
		
		BLManager bl=new BLManager();
		Testseries ts=bl.getTestseriesByTsname(tsname);
		
		Exampaper ex=new Exampaper();
		ex.setEid(eid);
		ex.setQuestionno(questionno);
		ex.setStd(std);
		ex.setQuestion(question);
		ex.setAns(ans);
		ex.setCh1(ch1);
		ex.setCh2(ch2);
		ex.setCh3(ch3);
		ex.setCh4(ch4);
		ex.setCh5(ch5);
		ex.setQuestionmarks(questionmarks);
		ex.setTestseries(ts);
		
		bl.UpdateExampaper(ex);
		System.out.println("Question Updated Successfully....");
		response.sendRedirect("ViewAllExampapers.jsp");
		
	}

}
