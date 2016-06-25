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
			<input type="text" class="form-control" name="email" id="email" placeholder="example@domain.com" value="${fn:escapeXml(user.email)}" readonly>
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
			<input type="text" class="form-control" name="rg" id="rg" placeholder="999.999.999-99" value="${fn:escapeXml(user.rg)}" readonly>
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>Nome Fantasia:</label>
			<input type="text" class="form-control" name="fantasyName" id="tradename" value="${fn:escapeXml(user.fantasyName)}">
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
                        <input type="text" class="form-control" name="zipCode" id="cep" value="${fn:escapeXml(user.zipCode)}">
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
                    <label>Estado:</label>
                    <select name="state" class="form-control">
                            <option value="AC"> Acre </option>
                            <option value="AL"> Alagoas </option>
                            <option value="AP"> Amapá </option>
                            <option value="AM"> Amazonas </option>
                            <option value="BA"> Bahia </option>
                            <option value="CE"> Ceará </option>
                            <option value="DF"> Distrito Federal </option>
                            <option value="ES"> Espírito Santo </option>
                            <option value="GO"> Goiás </option>
                            <option value="MA"> Maranhão </option>
                            <option value="MT"> Mato Grosso </option>
                            <option value="MS"> Mato Grosso do Sul </option>
                            <option value="MG"> Minas Gerais </option>
                            <option value="PA"> Pará </option>
                            <option value="PB"> Paraíba </option>
                            <option value="PR"> Paraná </option>
                            <option value="PE"> Pernambuco </option>
                            <option value="PI"> Piauí </option>
                            <option value="RJ"> Rio de Janeiro </option>
                            <option value="RN"> Rio Grande do Norte </option>
                            <option value="RS"> Rio Grande do Sul </option>
                            <option value="RO"> Rondônia </option>
                            <option value="RR"> Roraima </option>
                            <option value="SC"> Santa Catarina </option>
                            <option value="SP"> São Paulo </option>
                            <option value="SE"> Sergipe </option>
                            <option value="TO"> Tocantins</option>
                    </select>
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>Cidade:</label>
                        <input type="text" class="form-control" name="city" id="city" value="${fn:escapeXml(user.city)}">
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>Bairro:</label>
                        <input type="text" class="form-control" name="neighborhood" id="neighborhood" value="${fn:escapeXml(user.neighborhood)}">
		</div>
	</div>

	<div class="col-md-10">                                    
		<div class="form-group">
			<label>Rua:</label>
                        <input type="text" class="form-control" name="street" id="street" value="${fn:escapeXml(user.street)}">
		</div>
	</div>

	<div class="col-md-2">                                    
		<div class="form-group">
			<label>Numero:</label>
                        <input type="text" class="form-control" name="addressNumber" id="number" value="${fn:escapeXml(user.addressNumber)}">
		</div>
	</div>

	<div class="col-md-12">                                    
		<div class="form-group">
			<label>Complemento:</label>
                        <input type="text" class="form-control" name="complement" id="complement" value="${fn:escapeXml(user.complement)}">
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>Telefone:</label>
                        <input type="text" class="form-control" name="landphone" id="phone" value="${fn:escapeXml(user.landPhone)}">
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>Celular:</label>
                        <input type="text" class="form-control" name="cellphone" id="cellphone" value="${fn:escapeXml(user.cellPhone)}">
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>Renda Declarada:</label>
			<input type="text" class="form-control" name="income" id="income" placeholder="R$1000,00">
		</div>
	</div>

	<div class="col-md-12 text-center">                                    
		<button type="submit" class="btn btn-lg btn-primary">Salvar</button>
	</div>

</form>