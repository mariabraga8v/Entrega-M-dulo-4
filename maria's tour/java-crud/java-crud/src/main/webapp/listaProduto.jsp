<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

<title>Lista de Produtos</title>
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
	          <a class="nav-link active" aria-current="page" href="index.html" style="color: #02cb5c;"><strong>Home</strong></a>
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
		      <li><a class="dropdown-item" href="PedidoCreateAndFind">Consulta/Alteracao/Exclusao</a></li>
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
	      <form action ="ProdutoCreateAndFind" method = "GET" class="d-flex" >
	        <input name="pesquisa" class="form-control me-2" type="search" placeholder="Digite o nome do pacote" aria-label="Search">
	        <button class="btn btn-outline-success" type="submit">Busca</button>
	      </form>
	    </div>
	  </div>
	</nav>
	
	<div class="container">
		<div class="row">
			<div class="cold-md-7">
				<hr>
				<h3> Pacotes Cadastrados</h3>
				<hr>
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>Descri????o</th>
							<th>Valor</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${produto}" var="product">
							<tr>
								<td>${product.id}</td>
								<td>${product.descricao}</td>
								<td>${product.valor}</td>
								<td>
									<a href="ProdutoDestroy?produtoId=${product.id}">Deletar</a>
									<a href="ProdutoUpdate?produtoId=${product.id}">Atualizar</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					
				</table>
			</div>
		</div>
	</div>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>

</body>
</html>