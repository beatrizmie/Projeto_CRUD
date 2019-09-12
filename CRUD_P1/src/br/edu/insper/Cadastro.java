package br.edu.insper;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cadastro")
public class Cadastro extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("Cadastre-se aqui!<br>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method='post'>");
		out.println("Nome: <input type='text' name='user' required='required'><br>");
		out.println("Senha: <input type='password' name='senha' required='required'><br>");
		out.println("Confirmar senha: <input type='password' name='confirma_senha' required='required'><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("<body><html>");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("senha");
		String confirmPassword = request.getParameter("confirma_senha");
		
		
		if (!password.contentEquals(confirmPassword)) {
			response.sendRedirect("Erro.jsp");
			return;
		}
		
		Login login = new Login();
		login.setName(user);
		login.setSenha(password);
		login.setConfirmaSenha(confirmPassword);
		
		DAO dao = new DAO();
		dao.adicionaLogin(login);
		dao.close();
		
		response.sendRedirect(request.getContextPath() + "/login");
		
	}
}