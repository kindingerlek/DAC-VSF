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
		<div class="panel">
			<div class="panel-body">
				<div class="container-fluid">
					<jsp:include page="includes/person/edit.jsp" />
				</div>
			</div>
		</div>

		<div class="panel">
			<div class="panel-body">				
				<div class="container-fluid">
					<jsp:include page="includes/account/details.jsp"/>
				</div>
			</div>			
		</div>
	</div>
</body>
</html>