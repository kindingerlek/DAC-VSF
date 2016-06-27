<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="container-fluid">

                        <h1>Digite a senha da conta: ${param.number}</h1>
                        <hr>
                        <form action="AccountActions" method="POST">
                            <input type="hidden" name="action" value="${param.action}"/>
                            <input type="hidden" name="number" value="${param.number}"/>
                            <div class="col-md-8">
                                <br><p>
                                    Para que possamos fazer esta ação na sua conta, precisamos
                                    que você digite a senha desta conta.
                                </p><br><br>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label for="password">Senha:</label>
                                    <input type="password" class="form-control" name="password" maxlength=8/>
                                </div><br><br>
                            </div>
                            <div class="text-center">
                                <button type="submit" id="account-submit" class="btn btn-lg btn-primary">Ir</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>