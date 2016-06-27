<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1>Esta conta</h1>
<hr>

<p>Número da Conta: ${fn:escapeXml(account.number)}</p>
<p>Agência: ${fn:escapeXml(account.agency.number)}</p>
<p>Saldo: <fmt:formatNumber value="${account.balance}" type="currency"/></p>
<p>Limite: <fmt:formatNumber value="${account.limit}" type="currency"/></p>
<p>Situação: ${fn:escapeXml(account.status)}</p>

<div class="text-center">
	<a href="CloseAccount" class="btn btn-danger btn-lg">
		FECHAR ESTA CONTA
	</a>
</div>	
