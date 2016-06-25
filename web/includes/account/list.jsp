<%@page contentType="text/html; charset=UTF-8" %>.
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1>Contas</h1>
<hr>

<c:forEach var="userAccount" items="${accounts}">
    <c:set var="allBalance" value="${allBalance + userAccount.balance}"/>
    <c:set var="allBalanceWithLimit" value="${allBalanceWithLimit + userAccount.balance + userAccount.limit}"/>
</c:forEach>
<h2>Saldo total: <fmt:formatNumber value="${allBalance}" type="currency"/></h2>
<h2>Limite total: <fmt:formatNumber value="${allBalanceWithLimit}" type="currency"/></h2>				

<table class="table table-striped">
	<thead>
		<td class="col-md-2"> <b> Agência </b> </td>
		<td class="col-md-2"> <b> Número da Conta <b> </td>
		<td class="col-md-3"> <b> Saldo <b> </td>
		<td class="col-md-4"> <b> Situação <b> </td>
		<td class="col-md-1"> <b> Ações</b> </td>
	</thead>
        <c:forEach var="userAccount" items="${accounts}">
            <tbody>
                    <td>${userAccount.agency.number}</td>
                    <td>${userAccount.number}</td>
                    <td><fmt:formatNumber value="${userAccount.balance}" type="currency"/></td>
                    <td>${fn:escapeXml(userAccount.status)}</td>
                    <td></td>
            </tbody>
        </c:forEach>
</table>