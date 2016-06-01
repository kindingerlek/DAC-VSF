<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>VSF</title>
	<jsp:include page="includes/commom/head/assets.jsp" />
</head>

<body>
	<div class="header container-fluid">		
		<jsp:include page="includes/commom/header.jsp" />
	</div>

	<div class="nav col-md-3">
		<jsp:include page="includes/commom/sidebar.jsp" />
	</div>

	<div class="section col-md-9">

		<div class="panel">
			<div class="panel-body">
				<div class="container-fluid">
					<h1>Esta Conta</h1>
					<hr>

					Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.	
					<div class="text-center">
						<a href="#" class="btn btn-danger btn-lg">
							FECHAR ESTA CONTA
						</a>
					</div>	
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			
			<div class="panel-body">

				<div class="container-fluid">
					<h1>Meu Cadastro</h1>
					<hr>

					<form class="form">
						<div class="col-md-12">                                    
							<div class="form-group">
								<label for="">Nome:</label>
								<input type="text" class="form-control" id="name" name="name">
							</div>
						</div>

						<div class="col-md-12">                                    
							<div class="form-group">
								<label>Email:</label>
								<input type="text" class="form-control" id="email" readonly>
							</div>
						</div>

						<div class="col-md-6">                                    
							<div class="form-group">
								<label>CPF:</label>
								<input type="text" class="form-control" id="rg" readonly>
							</div>
						</div>

						<div class="col-md-6">                                    
							<div class="form-group">
								<label>RG:</label>
								<input type="text" class="form-control" id="cpf" readonly>
							</div>
						</div>

						<div class="col-md-6">                                    
							<div class="form-group">
								<label>Nome Fantasia:</label>
								<input type="text" class="form-control" id="tradename">
							</div>
						</div>

						<div class="col-md-6">                                    
							<div class="form-group">
								<label>CNPJ:</label>
								<input type="text" class="form-control" id="cnpj" readonly>
							</div>
						</div>

						<div class="col-md-6">                                    
							<div class="form-group">
								<label>CEP:</label>
								<input type="text" class="form-control" id="cep">
							</div>
						</div>

						<div class="col-md-6">                                    
							<div class="form-group">
								<label>Estado:</label>
								<input type="text" class="form-control" id="state">
							</div>
						</div>

						<div class="col-md-6">                                    
							<div class="form-group">
								<label>Cidade:</label>
								<input type="text" class="form-control" id="city">
							</div>
						</div>

						<div class="col-md-6">                                    
							<div class="form-group">
								<label>Bairro:</label>
								<input type="text" class="form-control" id="neighborhood">
							</div>
						</div>

						<div class="col-md-10">                                    
							<div class="form-group">
								<label>Rua:</label>
								<input type="text" class="form-control" id="street">
							</div>
						</div>

						<div class="col-md-2">                                    
							<div class="form-group">
								<label>Numero:</label>
								<input type="text" class="form-control" id="number">
							</div>
						</div>

						<div class="col-md-12">                                    
							<div class="form-group">
								<label>Complemento:</label>
								<input type="text" class="form-control" id="complement">
							</div>
						</div>

						<div class="col-md-6">                                    
							<div class="form-group">
								<label>Telefone:</label>
								<input type="text" class="form-control" id="phone">
							</div>
						</div>

						<div class="col-md-6">                                    
							<div class="form-group">
								<label>Celular:</label>
								<input type="text" class="form-control" id="cellphone">
							</div>
						</div>



						<div class="col-md-12 pull-right">                                    
							<button type="submit" class="btn btn-lg btn-success">Salvar Modificações</button>
						</div>
					</form>

					<br>
					
				</div>
			</div>
		</div>


	</div>
</body>
</html>