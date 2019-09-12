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
 * Servlet implementation class AtualizaNotas
 */
@WebServlet("/AtualizaNotas")
public class AtualizaNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizaNotas() {
        super();
        // TODO Auto-generated constructor stub
    }


	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("Título: <input type='text' name='title'><br>");
		out.println("Nota: <input type='text' name='note'><br>");
		out.println("<input type='submit' value='Enviar'>");
		out.println("</form>");
		out.println("<form action='./Editado'>");
		out.println("<input type='button' value='Nova nota'>");
		out.println("</form>");
		out.println("<body><html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Notes notes = new Notes();
		notes.setIdUser(Integer.valueOf(request.getParameter("id")));
		notes.setTitle(request.getParameter("title"));
		notes.setNote(request.getParameter("note"));
		
		Integer idUser = Integer.parseInt(request.getParameter("id"));
		
		DAO dao = new DAO();
		dao.alteraNota(notes);
		
		request.setAttribute("id", idUser);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Editado.jsp"); ;
		requestDispatcher.forward(request, response);
		
		dao.close();
	}

}
