<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Notes</title>
</head>
<body>
<%@ page import="java.util.*,br.edu.insper.*" %>
 
 
<% 	String user = request.getParameter("user"); 
	Integer id = Integer.parseInt(request.getParameter("id"));
%>
<div>
<%= "Bloco de notas de " + user%>
<%= "Bloco de notas de " + id%>
</div>


<% DAO dao = new DAO();
	List<Notes> notes = dao.getUserNotes(id);
	for (Notes note : notes) { %>
	
	<table border='1'>
	<td><%=note.getTitle() %></td>
	<tr>
	<td><%=note.getNote() %></td>
	</table>
	
 <% }
	dao.close();
	 %>
	 
	 
<div>
	<form action='./AddNotes' method='get'>
		<input type='hidden' value=<%= id%> name='id'>
		<input type='submit' value='Nova nota'>
	</form>
</div>
<tr>
<div>
	<form action='./RemoveNota' method='get'>
		<input type='hidden' value=<%= id%> name='id'>
		<input type='submit' value='Apagar nota'>
	</form>
</div>
</tr>
<div>
	<form action='./AtualizaNotas' method='get'>
		<input type='hidden' value=<%= id%> name='id'>
		<input type='submit' value='Editar nota'>
	</form>
</div>

</body>
</html>