<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar Estudantes</title>
<link type="text/css" rel="stylesheets" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	

</head>


<body>
	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>
	<div id="container">
		<h3>Atualizar  Estudante </h3>
		
		<form action="SVEstudante" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />
			<input type="hidden" name="estudanteId" value="${_estudante.idEstudante}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><input type="text" name="firstName" value="${_estudante.nome}" /></td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><input type="text" name="lastName" value="${_estudante.sobrenome}"  /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" value="${_estudante.email }" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="SVEstudante">Voltar a Lista</a>
		</p>
	</div>
</body>
</html>