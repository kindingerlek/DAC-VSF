<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.user != null && sessionScope.account != null}">
    <c:redirect url="home.jsp" />
</c:if>
<!doctype html>
<html>
    <head>
        <title>VSF - Tela Inicial</title>

        <jsp:include page="includes/commom/head/assets.jsp" />  

        <link rel="stylesheet" href="assets/css/mainpage.css">  
        <link rel="stylesheet" href="assets/css/main-header.css">
    </head>

    <body>
        <jsp:include page="includes/commom/index-header.jsp" />  


        <div class="section container-fluid">

            <jsp:include page="includes/commom/alerts.jsp" />

            <div class="col-md-6">
                <div class="panel">
                    <div class="panel-body">
                        <div class="container-fluid">
                            <jsp:include page="includes/mainpage/sign.jsp" />
                        </div>
                    </div>        
                </div>
            </div>

            <div class="col-md-6">
                <div class="panel">
                    <div class="panel-body">
                        <div class="container-fluid">
                            <jsp:include page="includes/account/new.jsp" />
                        </div>
                    </div>
                </div>
            </div>
        </div>  

        
        <script src="./js/maskValidation.js"></script>
        <script src="./js/newPersonValidation.js"></script>
        <script src="./js/newAccountValidation.js"></script>
        <script src="./js/indexBehaviour.js"></script>

    </body>
</html>