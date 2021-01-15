package com.controller;

import java.io.IOException;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Candidate;
import com.pojo.Student;
import com.pojo.Testseries;

/**
 * Servlet implementation class AddCandidate
 */
@WebServlet("/SaveCandidate")
public class SaveCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCandidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tsname=request.getParameter("tsname");
		String standard=request.getParameter("standard");
		
		HttpSession sess=request.getSession();
//		String studid=(String)
		int sid=(Integer)sess.getAttribute("sid");
		
		BLManager bl=new BLManager();
		Testseries tss=bl.getTestseriesByTsname(tsname);
		Student stud=bl.SearchStudentById(sid);
		Candidate c=new Candidate();
		
		LocalDate ldate=java.time.LocalDate.now();
		LocalTime ltime=java.time.LocalTime.now();
		String date=ldate.toString();
		String time=ltime.toString();
		
		c.setTestseries(tss);
		c.setDate(date);
		c.setTime(time);
		c.setStudent(stud);
		c.setStandard(standard);
		
		bl.SaveCandidate(c);
		
		sess.setAttribute("cid", c.getCid());
		System.out.println("Candidate Saved Successfully....");
//		response.sendRedirect("PrepareExam?cid="+c.getCid());
		response.sendRedirect("Exam.jsp");
	}

}
