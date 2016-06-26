<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${user.type == 1}">
    <c:redirect url="home.jsp"/>
</c:if>
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
                        <jsp:include page="includes/withdraw/new.jsp"/>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="js/maskValidation.js"></script>           
    </body>
</html>