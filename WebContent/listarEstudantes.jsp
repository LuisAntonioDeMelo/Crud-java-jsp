
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,servlet.*,model.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Tracker</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Stay on the plan</h2>
		</div>
	</div>
	<br/>
	<div id="container">
		<div id="content">
		<input type="button" value="Adicionar " onclick="window.location.href='adicionarEstudantes.jsp'; return false;  "
			class="add-student-button" />
			<table>
				<tr>
					<th>Nome</th>
					<th>SobreNome</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<tbody>
				
					<c:forEach var="estudante" items="${lista_estudantes}">
						<c:url var="updateLink" value="SVEstudante">
							<c:param name="command" value="LOAD" />
							<c:param name="estudanteId" value="${estudante.idEstudante}" />
						</c:url>
						<c:url var="deleteLink" value="SVEstudante">
							<c:param name="command" value="DELETE" />
							<c:param name="estudanteId" value="${estudante.idEstudante}" />
						</c:url>
						
						
						<tr>
							<td>${estudante.nome}</td>
							<td>${estudante.sobrenome}</td>
							<td>${estudante.email}</td>
							<td><a href="${updateLink}">update</a>
							 |  <a href="${deleteLink}" onclick="if(!(confirm('Tem certeza que quer deletar'))) return false;" >Delete</a>
							</td>
							
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>
	</div>

</body>
</html>