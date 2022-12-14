<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<title>Atualizar Pedido</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-light">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">ForTur</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="index.html" style="color: #02cb5c;"><strong>Homepage</strong></a>
	        </li>
	        
	                
	        <li class="nav-item dropdown">
			    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Cliente</a>
			    <ul class="dropdown-menu">
			      <li><a class="dropdown-item" href="index.html">Cadastro de Cliente</a></li>
			      <li><a class="dropdown-item" href="CreateAndFind">Consulta/Alteracao/Exclusao</a></li>
			    </ul>
			 </li>  
	         
	          <li class="nav-item dropdown">
		    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Pedido</a>
		    <ul class="dropdown-menu">
		      <li><a class="dropdown-item" href="cadastroPedido.html">Cadastro de Pedido</a></li>
		      <li><a class="dropdown-item" href="PedidooCreateAndFind">Consulta/Alteracao/Exclusao</a></li>
		    </ul>
		 	</li>
	         
	         <li class="nav-item dropdown">
		    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Pacotes</a>
		    <ul class="dropdown-menu">
		      <li><a class="dropdown-item" href="cadastroProduto.html">Cadastro de Pacote</a></li>
		      <li><a class="dropdown-item" href="ProdutoCreateAndFind">Consulta/Alteracao/Exclusao</a></li>
		    </ul>
		 </li>
	      </ul>
	      
	      <!-- CAMPO DE BUSCA-->
	      <form action ="PedidoCreateAndFind" method = "GET" class="d-flex" >
	        <input name="pesquisa" class="form-control me-2" type="search" placeholder="Digite o id do pedido" aria-label="Search">
	        <button class="btn btn-outline-success" type="submit">Busca</button>
	      </form>
	      
	    </div>
	  </div>
	</nav>
	
	<div class="container">
		<div class="row">
			<div class="cold-md-7">
				<hr>
				<h3>Atualizar Pedido</h3>
				<hr>
				<form action= "PedidoUpdate" method="POST">
						<div class="form-floating mb-3">
						<input  value="${pedido.id}" name ="id" maxlength="40" type="text" class="form-control" readonly="readonly" >
						<label>ID</label>
						</div>
						<div class="form-floating mb-3">
							<input value="${pedido.idCliente}" name="idCLiente" maxlength="40" type="text" class="form-control" readonly="readonly"> 
							<label>ID Cliente</label>
						</div>
						<div class="form-floating mb-3">
							<input value="${pedido.quantidade}" name="quantidade" maxlength="11" type="text" class="form-control"> 
							<label>Quantidade (apenas n??meros)</label>
						</div>
						
						<div class="form-floating mb-3">
							<input value="${pedido.idProduto}" name="idProduto" maxlength="40" type="text" class="form-control"> 
							<label>ID Produto</label>
						</div>
						
						<div class="form-floating mb-3">
							<input value="${pedido.dataPedido}" name="dataPedido" type="date" class="form-control" readonly="readonly"> 
							<label>Data do Pedido</label>
						</div>
						
						<div class="form-floating mb-3">
							<input value="${pedido.dataViagem}" name="dataViagem" type="date" class="form-control" >
							<label>Data da Viagem</label>
						</div>
							
						<button class="btn btn-warning" type="submit">Atualizar</button>
						<button class="btn btn-warning" type="reset">Limpar Formul??rio</button>
				</form>
				<br>
			</div>
		</div>
	</div>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
	



</body>
</html>