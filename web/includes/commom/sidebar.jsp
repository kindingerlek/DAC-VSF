<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="sidebar-menu">
	<a href="home.jsp">
		<div class="sidebar-item">
			<div class="item-icon">
				<i class="fa fa-home fa-2x" aria-hidden="true"></i>					
			</div>
			<div class="item-text">
				Home
			</div>
		</div>
	</a>

	<a href="Extract">
		<div class="sidebar-item">
			<div class="item-icon">
				<i class="fa fa-file-text fa-2x" aria-hidden="true"></i>					
			</div>
			<div class="item-text">
				Extrato
			</div>
		</div>
	</a>

	<a href="deposit.jsp">
		<div class="sidebar-item">
			<div class="item-icon">
				<i class="fa fa-credit-card-alt fa-2x" aria-hidden="true"></i>					
			</div>
			<div class="item-text">
				Depósito Virtual
			</div>
		</div>
	</a>

    <c:if test="${user.type == 2}">
        <a href="withdraw.jsp">
            <div class="sidebar-item">
                <div class="item-icon">
                    <i class="fa fa-money fa-2x" aria-hidden="true"></i>					
                </div>
                <div class="item-text">
                    Saque Virtual
                </div>
            </div>
        </a>
    </c:if>

	<a href="transaction.jsp">
		<div class="sidebar-item">
			<div class="item-icon">
				<i class="fa fa-exchange fa-2x" aria-hidden="true"></i>					
			</div>
			<div class="item-text">
				Transferência
			</div>
		</div>
	</a>

	<a href="myregister.jsp">
		<div class="sidebar-item">
			<div class="item-icon">
				<i class="fa fa-user fa-2x" aria-hidden="true"></i>					
			</div>
			<div class="item-text">
				Meu Cadastro
			</div>
		</div>
	</a>

	<a href="accounts.jsp">
		<div class="sidebar-item">
			<div class="item-icon">
				<i class="fa fa-gear fa-2x" aria-hidden="true"></i>					
			</div>
			<div class="item-text">
				Gerenciar Contas
			</div>
		</div>
	</a>
</div>
