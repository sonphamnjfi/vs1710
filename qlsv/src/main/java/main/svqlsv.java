package main;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class svqlsv
 */
@WebServlet("/svqlsv")
public class svqlsv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svqlsv() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		String parmasv=request.getParameter("parmasv").trim().toUpperCase();
		String parhodemsv=request.getParameter("parhodemsv").trim();
		String partensv=request.getParameter("partensv").trim();
		String partelsv=request.getParameter("partelsv").trim();
		String paremailsv=request.getParameter("paremailsv").trim();
		try {
			if((parmasv!=null && parmasv.length()>0) ||(partensv!=null && partensv.length()>0) || (parhodemsv!=null && parhodemsv.length()>0)  ){
				sv svobj = new sv();
				if(parmasv!=null && parmasv.length()>0) svobj.setMasv(parmasv);
				if(parhodemsv!=null && parhodemsv.length()>0) svobj.setHodem(parhodemsv);
				if(partensv!=null && partensv.length()>0) svobj.setTensv(partensv);
				if(partelsv!=null && partelsv.length()>0) svobj.setTelsv(partelsv);//System.out.println("partelsv="+partelsv);
				if(paremailsv!=null && paremailsv.length()>0) svobj.setEmailsv(paremailsv);
				svobj.themSV();
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
