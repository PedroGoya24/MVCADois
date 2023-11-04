<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Destino</title>
<link rel="icon" href="img/Logo-removebg-preview.png">
    <link rel="stylesheet" href="css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">

</head>
<body>
	<!--Inicio Navbar-->
    <nav class="navbar navbar-expand-lg mb-5" id="bgNav">
        <div class="container-fluid">
            <a class="navbar-brand align-middle" href="#"><img src="img/Logo2.png" class=" d-inline-block"
                    style="width: 100%; height: 80px;" /></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link fs-5" aria-current="page" href="index.html">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link fs-5" href="destino.html">Destinos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link fs-5" href="promocoes.html">Promoções</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link fs-5" href="contato.html">Contato</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle fs-5 " href="#" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            Sazonais
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item fs-5" href="verao.html">Verão</a></li>
                            <li><a class="dropdown-item fs-5" href="inverno.html">Inverno</a></li>
                            <li><a class="dropdown-item fs-5" href="primavera.html">Primavera</a></li>
                            <li><a class="dropdown-item fs-5" href="outono.html">Outono</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link fs-5  active" href="home">Cadastro Destino</a>
                    </li>
                </ul>
                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Destinos" aria-label="Search">
                    <button class="btn btn-outline-success btnNavbar" type="submit">Buscar</button>
                </form>
            </div>
        </div>
    </nav>
    <!--Fim Navbar-->

    
		<div class="container">
		<h3>Cadastro Destino</h3>
		<form action="Inserir" method="post" class="form-control">
			<fieldset>
				<legend>Dados do Destino</legend>

				<p>
					<label for="nome">Nome:</label> <input type="text" id="nomeDest"
						name="nomeDest" size="40" class="form-control" required>
				</p>				

				<p>
					<input type="submit" value="Cadastrar Destino"
						class="btn btn-primary">
				</p>
			</fieldset>
		</form>
		
		<br>
		<h5>Destinos cadastrados</h5>
	
	<table class="table">
		<thead>
			<tr>
				<th>Nome</th>				
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>			
			
			<jstl:forEach items="${listaDestinos}" var="destino">
				<tr>
					<td>${destino.nomeDest}</td>					
					<td>
						<a href="editar?id=${destino.idDes}" class="btn btn-success">Editar</a>  
						<a href="excluir?id=${destino.idDes}" onclick="return confirm('Deseja Excluir?')" class="btn btn-danger">Excluir</a>
					</td>
				</tr>
			</jstl:forEach>
			
		</tbody>
	</table>
	</div>


	<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>	
</body>
</html>