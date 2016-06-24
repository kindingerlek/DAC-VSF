<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<h1>Extrato</h1>
<hr>

<div class="row">						
    <div class="pull-right">
        <a href="./extract_details.jsp" class="btn btn-primary">
            Ver detalhes
        </a>			
    </div>
</div>	


<div class="row" >
    <br>

    <div class="timeline container-fluid">

        <%-- Armazena o valor do saldo atual --%>
        <c:set var="balance" value="${extract.balance}" />

        <dl>

            <%-- Imprime o mês. (Ex: Junho de 2016) --%>
            <dt><fmt:formatDate pattern="M de a" value="${extract}" /></dt>

            <%-- Percorre as transações do mês --%>
            <c:forEach items="${account.transactions}" var="transaction">

                <%-- Define a classe CSS com base no valor da transação --%>
                <c:set var="transactionClass" value="${transaction.ammount < 0 ? 'pos-right clearfix withdrawal' : 'pos-left clearfix deposit'}" />
                <dd class="${transactionClass}">

                    <div class="circ"></div>

                    <%-- Imprime a data (Ex:23/06/2016)  --%>
                    <div class="time">
                        <fmt:formatDate pattern="d/M/a" value="${transaction.date}"/>
                    </div>

                    <div class="events">
                        <div class="events-body text-center">
                            <h4 class="events-heading">${transaction.type}</h4>
                            <p class="value">
                                Valor: 
                                <fmt:formatNumber type="CURRENCY" currencyCode="BRL" value="${transaction.ammount}"/>
                            </p>

                            <%-- Armazena o valor do saldo com o valor da transação--%>
                            <c:set var="balance" value="${balance-ammount}" />                            
                            <p>
                                Saldo: ${balance}
                                <fmt:formatNumber type="CURRENCY" currencyCode="BRL" value="${balance}"/>
                            </p>
                        </div>
                    </div>
                </dd>
            </c:forEach>
        </dl>
    </div>
</div>