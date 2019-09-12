package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveNota
 */
@WebServlet("/RemoveNota")
public class RemoveNota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("Remover nota por título: <input type='text' name ='title'><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("<body><html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		Notes notes = new Notes();
		
		Integer idUser = Integer.parseInt(request.getParameter("id"));
		
		notes.setTitle(request.getParameter("title"));
		notes.setNote(request.getParameter("note"));
		notes.setIdUser(idUser);
		
		dao.removeNota(request.getParameter("title"));
		dao.close();
		
		request.setAttribute("id", idUser);
			
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Removido.jsp"); ;
		requestDispatcher.forward(request, response);
	}
	
}
