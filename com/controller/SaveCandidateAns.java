package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Candidate;
import com.pojo.Candidateans;

/**
 * Servlet implementation class SaveCandidateAns
 */
@WebServlet("/SaveCandidateAns")
public class SaveCandidateAns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCandidateAns() {
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
		String questionno=request.getParameter("questionno");
		String ans=request.getParameter("ans");
//		int qno=Integer.parseInt(questionno);
		HttpSession sess=request.getSession();
		int cid=(Integer)sess.getAttribute("cid");
		
		BLManager bl=new BLManager();

		Candidate c=bl.SearchCandidateById(cid);
			

		
		if(!bl.isAttempted(c, questionno))
		{
			Candidateans ca=new Candidateans();			
			ca.setQuestionno(questionno);
			ca.setCandidate(c);
			ca.setAns(ans);
			bl.SaveCandidateans(ca);
		}
		else
		{
			Candidateans ca=bl.SearchByCidQnoCandidateAns(c, questionno);
			ca.setAns(ans);
			bl.UpdateCandidateans(ca);
		}
		System.out.println(ans+" "+questionno);
		System.out.println("Answer Saved Successfully..");
		response.sendRedirect("Exam.jsp");
		
	}

}
