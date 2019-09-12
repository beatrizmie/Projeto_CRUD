package br.edu.insper;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/atualiza")
public class AtualizaCadastro extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("Nome: <input type='text' name='user'><br>");
		out.println("Senha: <input type='password' name='senha'><br>");
		out.println("Confirmar senha: <input type='password' name='confirma_senha'><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("<body><html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Login login = new Login();
		login.setId(Integer.valueOf(request.getParameter("id")));
		login.setName(request.getParameter("nome"));
		login.setSenha(request.getParameter("senha"));
		login.setConfirmaSenha(request.getParameter("confirma_senha"));
		
		DAO dao = new DAO();
		dao.alteraLogin(login);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("atualizado" + login.getName());
		out.println("</body></html>");
		dao.close();
	}
}