package com.model;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.pojo.Candidate;
import com.pojo.Candidateans;
import com.pojo.Exampaper;
import com.pojo.Score;
import com.pojo.Student;
import com.pojo.Teacher;
import com.pojo.Testseries;

public class BLManager {

	SessionFactory sf=new Configuration().configure().buildSessionFactory();

//search by cid and questionno
	public Candidateans SearchByCidQnoCandidateAns(Candidate cd,String questionno)
	{
		Session s=sf.openSession();
		Criteria c=s.createCriteria(Candidateans.class);
		c.add(Restrictions.eq("candidate", cd));
		c.add(Restrictions.eq("questionno", questionno));
		Candidateans ca=(Candidateans)c.uniqueResult();
		return ca;
	}
	
	
//check if question is attempted 
	
	public boolean isAttempted(Candidate cd,String questionno)
	{
		Session s=sf.openSession();
		Criteria c=s.createCriteria(Candidateans.class);
		c.add(Restrictions.eq("candidate",cd));
		c.add(Restrictions.eq("questionno", questionno));
		List<Candidateans> calist=c.list();
		if(calist.isEmpty())
			return false;
		else
			return true;
	}

	
//Save	
	public void SaveCandidate(Candidate c)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.save(c);
		tr.commit();
		s.close();
	}

	public void SaveCandidateans(Candidateans ca)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.save(ca);
		tr.commit();
		s.close();
	}	
	
	public void SaveExampaper(Exampaper e)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.save(e);
		tr.commit();
		s.close();
	}
	
	public void SaveScore(Score sc)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.save(sc);
		tr.commit();
		s.close();
	}
	
	public void SaveStudent(Student st)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.save(st);
		tr.commit();
		s.close();
	}	
	
	public void SaveTeacher(Teacher t)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.save(t);
		tr.commit();
		s.close();
	}
	
	public void SaveTestseries(Testseries ts)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.save(ts);
		tr.commit();
		s.close();
	}	
	
//List Ques for Candidate with proper std and test series	
	public List<Exampaper> prepareExam(Candidate c)
	{
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Exampaper.class);
		Testseries tst=c.getTestseries();
		
		cr.add(Restrictions.eq("std", c.getStandard()));
		cr.add(Restrictions.eq("testseries", tst));
		
		List<Exampaper> exlist=cr.list();
		return exlist;
	}

//List Candidateans by cid
	public List<Candidateans> getAllCandidateAnswers(Candidate c)
	{
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Candidateans.class);
		cr.add(Restrictions.eq("candidate", c));
		List<Candidateans> calist = cr.list();
		return calist;
	}
	
	
//List All
	
	public List<Candidate> ListAllCandidate()
	{
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Candidate.class);
		List<Candidate> candidatelist=cr.list();
		return candidatelist;
	}
	
	public List<Candidateans> ListAllCandidateans()
	{
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Candidateans.class);
		List<Candidateans> candidateanslist=cr.list();
		return candidateanslist;
	}

	public List<Exampaper> ListAllExampaper()
	{
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Exampaper.class);
		List<Exampaper> exampaperlist=cr.list();
		return exampaperlist;
	}
	
	public List<Score> ListAllScore()
	{
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Score.class);
		List<Score> scorelist=cr.list();
		return scorelist;
	}
	
	public List<Student> ListAllStudent()
	{
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Student.class);
		List<Student> studentlist=cr.list();
		return studentlist;
	}
	
	public List<Teacher> ListAllTeachers()
	{
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Teacher.class);
		List<Teacher> teacherlist=cr.list();
		return teacherlist;
	}
	
	public List<Testseries> ListAllTestseries()
	{
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Testseries.class);
		List<Testseries> testserieslist=cr.list();
		return testserieslist;
	}	

//Search By Id
	
	public Candidate SearchCandidateById(int cid)
	{
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Candidate.class);
		cr.add(Restrictions.eq("cid", cid));
		Candidate c=(Candidate)cr.uniqueResult();
		return c;
	}
	
	public Candidateans SearchCandidateansById(int caid)
	{
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Candidateans.class);
		cr.add(Restrictions.eq("caid", caid));
		Candidateans c=(Candidateans)cr.uniqueResult();
		return c;
	}
	
	public Exampaper SearchExampaperById(int eid)
	{
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Exampaper.class);
		cr.add(Restrictions.eq("eid", eid));
		Exampaper c=(Exampaper)cr.uniqueResult();
		return c;
	}	
	
	public Score SearchScoreById(int sid)
	{
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Score.class);
		cr.add(Restrictions.eq("sid", sid));
		Score c=(Score)cr.uniqueResult();
		return c;
	}
	
	public Student SearchStudentById(int sid)
	{
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Student.class);
		cr.add(Restrictions.eq("sid", sid));
		Student sc=(Student)cr.uniqueResult();
		return sc;
	}	
	
	public Teacher SearchTeacherById(int tid)
	{
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Teacher.class);
		cr.add(Restrictions.eq("tid", tid));
		Teacher t=(Teacher)cr.uniqueResult();
		return t;
	}

	public Testseries SearchTestseriesById(int tsid)
	{
		Session s=sf.openSession();
		Criteria cr=s.createCriteria(Testseries.class);
		cr.add(Restrictions.eq("tsid", tsid));
		Testseries t=(Testseries)cr.uniqueResult();
		return t;
	}	
	
//Update
	
	public void UpdateCandidate(Candidate c)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.update(c);
		tr.commit();
		s.close();
	}	
	
	public void UpdateCandidateans(Candidateans c)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.update(c);
		tr.commit();
		s.close();
	}	
	
	public void UpdateExampaper(Exampaper e)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.update(e);
		tr.commit();
		s.close();
	}	
	
	public void UpdateScore(Score sc)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.update(sc);
		tr.commit();
		s.close();
	}	

	public void UpdateStudent(Student st)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.update(st);
		tr.commit();
		s.close();
	}	
	
	public void UpdateTeacher(Teacher t)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.update(t);
		tr.commit();
		s.close();
	}	
	
	public void UpdateTestseries(Testseries t)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.update(t);
		tr.commit();
		s.close();
	}	
	
//Delete
	
	public void DeleteCandidate(Candidate c)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.delete(c);
		tr.commit();
		s.close();
	}	
	
	public void DeleteCandidateans(Candidateans c)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.delete(c);
		tr.commit();
		s.close();
	}	
	
	public void DeleteExampaper(Exampaper e)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.delete(e);
		tr.commit();
		s.close();
	}	
	
	public void DeleteScore(Score sc)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.delete(sc);
		tr.commit();
		s.close();
	}	
	
	public void DeleteStudent(Student st)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.delete(st);
		tr.commit();
		s.close();
	}		
	
	public void DeleteTeacher(Teacher t)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.delete(tr);
		tr.commit();
		s.close();
	}
	
	public void DeleteTTestseries(Testseries t)
	{
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.delete(tr);
		tr.commit();
		s.close();
	}
	
//Get By logname
	
	public Student getStudentByLogname(String logname)
	{
		Session s=sf.openSession();
		Criteria c=s.createCriteria(Student.class);
		c.add(Restrictions.eq("logname", logname));
		Student st= (Student)c.uniqueResult();
		s.close();
		return st;
	}
	
	public Teacher getTeacherByLogname(String logname)
	{
		Session s=sf.openSession();
		Criteria c=s.createCriteria(Teacher.class);
		c.add(Restrictions.eq("logname", logname));
		Teacher st= (Teacher)c.uniqueResult();
		s.close();
		return st;
	}
	
//Get by tsname
	
	public Testseries getTestseriesByTsname(String tsname)
	{
		Session s=sf.openSession();
		Criteria c=s.createCriteria(Testseries.class);
		c.add(Restrictions.eq("tsname", tsname));
		Testseries ts=(Testseries)c.uniqueResult();
		s.close();
		return ts;
	}
}
