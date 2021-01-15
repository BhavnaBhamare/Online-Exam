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
import com.pojo.Exampaper;
import com.pojo.Score;
import com.pojo.Testseries;

/**
 * Servlet implementation class GenerateResult
 */
@WebServlet("/GenerateResult")
public class GenerateResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess=request.getSession();
		int candid=(Integer)sess.getAttribute("cid");
		int studid=(Integer)sess.getAttribute("sid");
		int marks=0;
		
		BLManager bl=new BLManager();
		Candidate c=bl.SearchCandidateById(candid);
		
		Testseries ts=c.getTestseries();
		
		List<Candidateans> calist=bl.getAllCandidateAnswers(c);
		
		for(Candidateans cdAns:calist)
		{
			int exid=Integer.parseInt(cdAns.getQuestionno());
			Exampaper ex=bl.SearchExampaperById(exid);
			if(ex.getAns().equals(cdAns.getAns()))
			{
				int qmks=Integer.parseInt(ex.getQuestionmarks());
				marks+=qmks;
			}
		}
				
		Score score=new Score();
		score.setCandidate(c);
		score.setTestseries(ts);
		score.setScore(marks+"");
		
		bl.SaveScore(score);
		
		System.out.println("Cid"+c.getCid());
		System.out.println("Score"+marks);
		System.out.println("tsid"+ts.getTsid());
		System.out.println("Score Saved Successfully...");
		response.sendRedirect("CViewResult.jsp?score="+marks);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
