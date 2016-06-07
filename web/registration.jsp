<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id="user" class="model.User" />
<!doctype html>
<html>
<head>
	<title>VSF - Cadastro</title>

	<jsp:include page="includes/commom/head/assets.jsp" />  

	<link rel="stylesheet" href="assets/css/main-header.css">	
	<link rel="stylesheet" href="assets/css/signin.css">
</head>

<body>
	<jsp:include page="includes/commom/index-header.jsp" />

	<div class="section container-fluid">
		<div class="col-md-2">
			
		</div>

		<div class="col-md-8">
			<div class="panel">
				<div class="panel-body">
					<div class="container-fluid">
						<jsp:include page="includes/person/new.jsp" />
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>