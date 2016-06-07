<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="container-fluid">					
	<div class="row">
		<h4>Para ter direito a uma conta no banco, por favor complete seu cadastro:</h4>	
	</div>
</div>

<form class="form" action="CompleteRegistration" method="POST">
        <input type="hidden" class="form-control" name="personType" value="${fn:escapeXml(user.type)}">

	<div class="col-md-12">                                    
		<div class="form-group">
			<label for="">Nome:</label>
			<input type="text" class="form-control" id="name" name="name" value="${fn:escapeXml(user.name)}">
		</div>
	</div>

	<div class="col-md-12">                                    
		<div class="form-group">
			<label>Email:</label>
                        <input type="text" class="form-control" name="email" id="email" value="${fn:escapeXml(user.email)}" readonly>
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>CPF:</label>
                        <input type="text" class="form-control" name="cpf" id="cpf" value="${fn:escapeXml(user.cpf)}" readonly>
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>RG:</label>
                        <input type="text" class="form-control" name="rg" id="cpf" value="${fn:escapeXml(user.rg)}" readonly>
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>Nome Fantasia:</label>
                        <input type="text" class="form-control" name="fantasyName" id="tradename" value="${fn:escapeXml(user.fantasyName)}" readonly>
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>CNPJ:</label>
                        <input type="text" class="form-control" name="cnpj" id="cnpj" value="${fn:escapeXml(user.cnpj)}" readonly>
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>CEP:</label>
                        <input type="text" class="form-control" name="zipCode" id="cep">
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>Estado:</label>
                        <input type="text" class="form-control" name="state" id="state">
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>Cidade:</label>
                        <input type="text" class="form-control" name="city" id="city">
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>Bairro:</label>
                        <input type="text" class="form-control" name="neighborhood" id="neighborhood">
		</div>
	</div>

	<div class="col-md-10">                                    
		<div class="form-group">
			<label>Rua:</label>
                        <input type="text" class="form-control" name="street" id="street">
		</div>
	</div>

	<div class="col-md-2">                                    
		<div class="form-group">
			<label>Numero:</label>
                        <input type="text" class="form-control" name="addressNumber" id="number">
		</div>
	</div>

	<div class="col-md-12">                                    
		<div class="form-group">
			<label>Complemento:</label>
                        <input type="text" class="form-control" name="complement" id="complement">
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>Telefone:</label>
                        <input type="text" class="form-control" name="landphone" id="phone">
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>Celular:</label>
                        <input type="text" class="form-control" name="cellphone" id="cellphone">
		</div>
	</div>



	<div class="col-md-12 text-center">                                    
		<button type="submit" class="btn btn-lg btn-primary">Salvar</button>
	</div>

</form>