<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Extrato</h1>
<hr>

<h2> Intervalo:</h2>

<form class="form-inline" action="ExtractDetailed" method="POST">
    
    <div class="form-group">
        <label> &nbsp Escolha um período:</label>
        <select class="form-control" name="periodDate">
            <option value="lastWeek">Nos últimos 7 dias</option>
            <option value="lastFortnight">Nos últimos 15 dias</option>
            <option value="lastMonth">Nos últimos 30 dias</option>
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
    
        <c:forEach items="${transactions}" var="transaction">
            
            <c:set var="inAmmount" value="${transaction.amount >= 0 ? transaction.amount : ''}" />
            <c:set var="outAmmout" value="${transaction.amount  < 0 ? transaction.amount : ''}" />
            
            <tr><td>${transaction.transactionType}</td>
            <td><fmt:formatNumber value="${inAmmount}" type="currency"/></td>
            <td><fmt:formatNumber value="${outAmmount}" type="currency"/></td>
            <td><fmt:formatDate pattern="d/MM/y" value="${transaction.date}"/></td></tr>
        </c:forEach>
	</tbody>
</table>