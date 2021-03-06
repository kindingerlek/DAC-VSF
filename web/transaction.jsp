<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

                        <jsp:include page="includes/transaction/new.jsp" />

                    </div>
                        <div class="error error-person"></div>
                </div>
                
            </div>
        </div>


        <script src="js/transactionBehaviour.js"></script>
        <script type="text/javascript" src="js/maskValidation.js"></script>
        <script type="text/javascript" src="js/validation.js"></script>
    </body>
</html>