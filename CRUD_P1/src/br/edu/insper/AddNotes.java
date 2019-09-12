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
 * Servlet implementation class AddNotes
 */
@WebServlet("/AddNotes")
public class AddNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNotes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("Título: <input type='text' name='title'><br>");
		out.println("Nota: <input type='text' name='note'><br>");
		out.println("<input type='submit' value='Enviar'>");
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

		
		if (request.getParameter("title").contentEquals("") || request.getParameter("note").contentEquals("")) {
			response.sendRedirect("Erro.jsp");
			return;
		}
		
		request.setAttribute("id", idUser);
		
		dao.adicionaNota(notes);
		dao.close();

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Sucesso.jsp"); ;
		requestDispatcher.forward(request, response);

	}
	
}
