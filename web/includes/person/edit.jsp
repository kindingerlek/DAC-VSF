<%@page contentType="text/html" pageEncoding="UTF-8"%>

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

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>Renda Declarada:</label>
			<input type="text" class="form-control" id="income" placeholder="R$1000,00">
		</div>
	</div>



	<div class="col-md-12">                                    
		<div class=" pull-right">								
			<button type="submit" class="btn btn-lg btn-success">Salvar Modificações</button>
		</div>
	</div>
</form>