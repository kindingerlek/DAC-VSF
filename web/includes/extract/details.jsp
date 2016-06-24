<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Extrato</h1>
<hr>

<h2> Intervalo:</h2>

<form class="form-inline">

	<div class="form-group">
		<label for="">De: </label>
		<input type="date" name="fromDate" class="form-control" id="from-date" placeholder="dd/mm/aaaa">
	</div>
	<div class="form-group">
		<label for="">&nbsp até &nbsp</label>
		<input type="date" name="toDate" class="form-control" id="to-date" placeholder="dd/mm/aaaa">
	</div>
    
    <div class="form-group" name="periodDate">
        <label> &nbsp Ou escolha um período:</label>
        <select class="form-control">
            <option value="lastWeek">Nos últimos 7 dias</option>
            <option value="lastFortnight">Nos últimos 15 dias</option>
            <option value="lastMouth">Nos últimos 30 dias</option>
        </select>
    </div>

	<div class="pull-right">
		<button class="btn btn-primary">
			<i class="fa fa-search fa-1x"></i>
			Pesquisar
		</button>
	</div>
</form>

<br>

<table class="table table-striped">
	<thead>
		<td class="col-md-4"> <b> Descrição </b> </td>
		<td class="col-md-2"> <b> Entrada <b> </td>
		<td class="col-md-2"> <b> Saída <b> </td>
		<td class="col-md-2"> <b> Data <b> </td>
	</thead>
	<tbody>
    
        <c:forEach items="${account.transactions}" var="transaction">
            
            <c:set var="inAmmount" value="${transaction.ammount >= 0 ? transaction.ammount : ''}" />
            <c:set var="outAmmout" value="${transaction.ammount  < 0 ? transaction.ammount : ''}" />
            
            <td>${transaction.type}</td>
            <td>${inAmmount}</td>
            <td>${outAmmount}</td>
            <td><fmt:formatDate pattern="d/M/a" value="${transaction.date}"/></td>
        </c:forEach>
	</tbody>
</table>