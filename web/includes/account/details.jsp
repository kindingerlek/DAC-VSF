<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h1>Esta Conta</h1>
<hr>

<p>Número da Conta: ${fn:escapeXml(account.number)}</p>
<p>Agência: ${fn:escapeXml(account.agency.number)}</p>
<p>Saldo: ${fn:escapeXml(account.balance)}</p>
<p>Limite: ${fn:escapeXml(account.limit)}</p>
<p>Situação: ${fn:escapeXml(account.status)}</p>

<div class="text-center">
	<a href="#" class="btn btn-danger btn-lg">
		FECHAR ESTA CONTA
	</a>
</div>	
