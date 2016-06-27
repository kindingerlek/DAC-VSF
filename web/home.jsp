<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
    <head>
        <title>VSF</title>
        <jsp:include page="includes/commom/head/assets.jsp" />
    </head>

    <body>
        <div class="header container-fluid">		
            <jsp:include page="includes/commom/header.jsp" />
        </div>

        <div class="nav col-md-3">
            <jsp:include page="includes/commom/sidebar.jsp" />
        </div>

        <div class="section col-md-9">			

            <jsp:include page="includes/commom/alerts.jsp" />

            <div class="panel">
                <div class="panel-body">
                    <div class="container-fluid">
                        <h1> Bem Vindo(a) ${user.name}! </h1>
                        
                        <hr>
                        
                        <h2>Seu saldo nesta conta: <fmt:formatNumber value="${account.balance}" type="currency"/></h2>
                        <h2>Movimentos no mês: <fmt:formatNumber value="${account.getMonthMovement()}" type="currency"/></h2>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>