<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="container-fluid">					
	<div class="row">
		<h4>Para ter direito a uma conta no banco, por favor complete seu cadastro:</h4>	
                <h6>Os campos com asterisco são obrigatórios.</h6>
	</div>
</div>

<form class="form" action="CompleteRegistration" method="POST">
	<input type="hidden" class="form-control" name="personType" value="${fn:escapeXml(user.type)}">

	<div class="col-md-12">                                    
		<div class="form-group">
			<label for="">Nome*:</label>
			<input type="text" class="form-control" id="name" name="name" value="${fn:escapeXml(user.name)}">
		</div>
	</div>

	<div class="col-md-12">                                    
		<div class="form-group">
			<label>Email*:</label>
			<input type="text" class="form-control" name="email" id="email" placeholder="example@domain.com" value="${fn:escapeXml(user.email)}" readonly>
		</div>
	</div>
<c:if test="${user.type == 1}">
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
        </c:if>
        <c:if test="${user.type == 2}">
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
        </c:if>
	<div class="col-md-6">
		<div class="form-group">
			<label>CEP*:</label>
                        <input type="text" class="form-control" name="zipCode" id="cep" value="${fn:escapeXml(user.zipCode)}">
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
                    <label>Estado*:</label>
                    <select name="state" class="form-control">
                            <option value="AC" ${user.state.equals("AC") ? 'selected' : ''}> Acre </option>
                            <option value="AL" ${user.state.equals("AL") ? 'selected' : ''}> Alagoas </option>
                            <option value="AP" ${user.state.equals("AP") ? 'selected' : ''}> Amapá </option>
                            <option value="AM" ${user.state.equals("AM") ? 'selected' : ''}> Amazonas </option>
                            <option value="BA" ${user.state.equals("BA") ? 'selected' : ''}> Bahia </option>
                            <option value="CE" ${user.state.equals("CE") ? 'selected' : ''}> Ceará </option>
                            <option value="DF" ${user.state.equals("DF") ? 'selected' : ''}> Distrito Federal </option>
                            <option value="ES" ${user.state.equals("ES") ? 'selected' : ''}> Espírito Santo </option>
                            <option value="GO" ${user.state.equals("GO") ? 'selected' : ''}> Goiás </option>
                            <option value="MA" ${user.state.equals("MA") ? 'selected' : ''}> Maranhão </option>
                            <option value="MT" ${user.state.equals("MT") ? 'selected' : ''}> Mato Grosso </option>
                            <option value="MS" ${user.state.equals("MS") ? 'selected' : ''}> Mato Grosso do Sul </option>
                            <option value="MG" ${user.state.equals("MG") ? 'selected' : ''}> Minas Gerais </option>
                            <option value="PA" ${user.state.equals("PA") ? 'selected' : ''}> Pará </option>
                            <option value="PB" ${user.state.equals("PB") ? 'selected' : ''}> Paraíba </option>
                            <option value="PR" ${user.state.equals("PR") ? 'selected' : ''}> Paraná </option>
                            <option value="PE" ${user.state.equals("PE") ? 'selected' : ''}> Pernambuco </option>
                            <option value="PI" ${user.state.equals("PI") ? 'selected' : ''}> Piauí </option>
                            <option value="RJ" ${user.state.equals("RJ") ? 'selected' : ''}> Rio de Janeiro </option>
                            <option value="RN" ${user.state.equals("RN") ? 'selected' : ''}> Rio Grande do Norte </option>
                            <option value="RS" ${user.state.equals("RS") ? 'selected' : ''}> Rio Grande do Sul </option>
                            <option value="RO" ${user.state.equals("RO") ? 'selected' : ''}> Rondônia </option>
                            <option value="RR" ${user.state.equals("RR") ? 'selected' : ''}> Roraima </option>
                            <option value="SC" ${user.state.equals("SC") ? 'selected' : ''}> Santa Catarina </option>
                            <option value="SP" ${user.state.equals("SP") ? 'selected' : ''}> São Paulo </option>
                            <option value="SE" ${user.state.equals("SE") ? 'selected' : ''}> Sergipe </option>
                            <option value="TO" ${user.state.equals("TO") ? 'selected' : ''}> Tocantins</option>
                    </select>
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>Cidade*:</label>
                        <input type="text" class="form-control" name="city" id="city" value="${fn:escapeXml(user.city)}">
		</div>
	</div>

	<div class="col-md-6">                                    
		<div class="form-group">
			<label>Bairro*:</label>
                        <input type="text" class="form-control" name="neighborhood" id="neighborhood" value="${fn:escapeXml(user.neighborhood)}">
		</div>
	</div>

	<div class="col-md-10">                                    
		<div class="form-group">
			<label>Rua*:</label>
                        <input type="text" class="form-control" name="street" id="street" value="${fn:escapeXml(user.street)}">
		</div>
	</div>

	<div class="col-md-2">                                    
		<div class="form-group">
			<label>Numero*:</label>
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
			<label>Renda Declarada*:</label>
			<input type="text" class="form-control" name="income" id="income" placeholder="R$1000,00">
		</div>
	</div>

	<div class="col-md-12 text-center">                                    
		<button type="submit" class="btn btn-lg btn-primary">Salvar</button>
	</div>

</form>