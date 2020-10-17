package com.ns.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ns.DAO.ProjectDAO;
import com.ns.clas.Project;

/**
 * Servlet implementation class ShowAllServ
 */
@WebServlet("/ShowAllServ")
public class ShowAllServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		ProjectDAO pdao=new ProjectDAO();
		List<Project> plist=pdao.showAll();
		pw.println("<table align='center' border='1'>"
		+"<tr><th>id</th><th>title</th><th>description</th><th>domain</th></tr>");
		for (Project p : plist) {
			pw.println("<tr><td>"+p.getId()+"</td><td>"+p.getTitle()+"</td><td>"+p.getDescription()+"</td><td>"+p.getDomain()+"</td></tr>");
		}
		pw.println("</table>");
	}

}
