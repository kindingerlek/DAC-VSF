
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

            <div id="alerts"></div>

            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="container-fluid">
                        <h1>Verificação de autenticidade</h1>
                        <hr>

                        <p>
                            Para sua proteção, este sistema possui uma interface
                            de segurança chamada token. Assim, você não precisa se
                            preocupar caso alguém descubra sua senha, pois ela 
                            precisará do seu código token!</p>

                        <div class="text-center" id="insert-token">
                            <p>
                                Insira este código no app do token:
                            </p>
                            <h2 id="code">1234</h2>
                        </div>                        

                        <form action="AccountValidation?id=${sessionScope.id}" method="POST" class="form">                            
                            <div class="col-md-12">                                    
                                <div class="form-group">
                                    <label for="">Código token gerado:</label>
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