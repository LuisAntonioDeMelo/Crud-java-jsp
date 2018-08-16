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

<script type="text/javascript">
</script>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>
	<div id="container">
		<h3>Add Student</h3>

		<form action="SVEstudante" method="GET" id="formulario" onsubmit="fun(this); return false;">

			<input type="hidden" name="command" value="ADD" />

			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><input id="nome" type="text" name="firstName" /><br /> <span
							id="val" style="background-color: #eee; color: red;"></span></td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><input type="text" name="lastName" id="sobrenome" /><br />
							<span id="val2" style="background-color: #eee; color: red;"></span>
						</td>

					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" id="email" /><br /> <span
							id="val3" style="background-color: #eee; color: red;"></span></td>

					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" ></input></td>
					</tr>

				</tbody>
			</table>
		</form>

		<div style="clear: both;"></div>

		<p>
			<a href="SVEstudante">Voltar a Lista</a>
		</p>
	</div>
	<script type="text/javascript">
	//window.onload = fun;
/*	var form = document.getElementById("formulario");

	 function fun(form){
			 if(form.nome.value == ""){
				document.getElementById("val").textContent =" insira seu nome ";
				return false;
			}
			 else if(form.sobrenome.value ==""){
			 document.getElementById("val2").textContent =" insira seu Sobrenome ";
				return false;
				}
			 else if (form.email.value==""){
			 document.getElementById("val3").textContent =" insira seu email ";
				return false;
			 }
			 else {
				 alert("Cadastrado com sucesso!");	
				 return true;
				 
					
				 }
			
	 }
*/
	</script>

</body>
</html>