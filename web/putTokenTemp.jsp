
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>VSF</title>
        <jsp:include page="includes/commom/head/assets.jsp" />
    </head>

    <body>
        <div class="header container-fluid">		
            <jsp:include page="includes/commom/header.jsp" />
        </div>

        <div class="section col-md-6 col-md-offset-3">

            <jsp:include page="includes/commom/alerts.jsp" />

            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="container-fluid">
                        <h1>Verificação de autenticidade</h1>
                        <hr>

                        <p>
                            Para ativar sua conta, é necessário verificar sua 
                            autenticidade! Por favor verifique seu e-mail, e 
                            insira o código enviado no campo abaixo.
                        </p>     

                        <form action="AccountValidation?id=${sessionScope.id}" method="POST" class="form">                            
                            <div class="col-md-12">                                    
                                <div class="form-group">
                                    <label for="">Código token enviado no seu e-mail:</label>
                                    <input type="text" name="token" class="form-control">
                                </div>
                            </div>

                            <div class="col-md-12">                                    
                                <div class="form-group">
                                    <label for="">A senha da sua conta:</label>
                                    <input type="password" name="password" class="form-control">
                                </div>
                            </div>

                            <div class="text-center">
                                <input type="submit" value="Enviar" class="btn btn-primary"/>
                            </div>

                        </form>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>