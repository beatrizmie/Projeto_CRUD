package br.edu.insper;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class FazerLogin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("Bem vindo ao seu bloco de notas virtual!<br>");
		out.println("</head>");
		out.println("<tr>");
		out.println("</tr>");
		out.println("<body>");
		out.println("Faça o login ou cadastre-se!");
		out.println("<form method='post'>");
		out.println("Nome: <input type='text' name='user'><br>");
		out.println("Senha: <input type='password' name='senha'><br>");
		out.println("<input type='submit' value='Login'>");
		out.println("</form>");
		out.println("<form action='./cadastro' method='get'>" );
		out.println("<input type='submit' value='Fazer cadastro'>");
		out.println("</form>");
		out.println("<body><html>");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		Login login = new Login();
		
		login.setName(request.getParameter("user"));
		login.setSenha(request.getParameter("senha"));
		login.setConfirmaSenha(request.getParameter("confirma_senha"));
		
		login = dao.getLogin(login);
		
		
		if (login.getId()!= null) {
			dao.adicionaLogin(login);
			dao.close();	
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Transition.jsp"); 
			String user = login.getName();
			request.setAttribute("user", user);
			int id = login.getId();
			request.setAttribute("id", id);
			requestDispatcher.forward(request, response);
			}
		else {
			response.sendRedirect("Erro.jsp");
		}
	}
	

}