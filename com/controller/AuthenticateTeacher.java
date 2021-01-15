package com.controller;

import java.io.IOException;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Teacher;

/**
 * Servlet implementation class AuthenticateTeacher
 */
@WebServlet("/AuthenticateTeacher")
public class AuthenticateTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticateTeacher() {
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

		String logname=request.getParameter("logname");
		String logpass=request.getParameter("logpass");
		
		BLManager bl=new BLManager();
		Teacher st;
		try{
			st=bl.getTeacherByLogname(logname);
			
			if(logpass.equals(st.getLogpass()))
			{
				HttpSession sess=request.getSession();
				sess.setAttribute("tid", st.getTid());
				sess.setAttribute("teacherUsername", st.getLogname());
				response.sendRedirect("AddExampaper.jsp");
			}
			else
			{
				System.out.println("Password does Not Match\n Try again.....");
				response.sendRedirect("TeacherLogin.jsp");
			}
		}
		catch(Exception e)
		{
			System.out.println("Username Incorrect ");
			response.sendRedirect("StudentLogin.jsp");
		}
		
	}

}
