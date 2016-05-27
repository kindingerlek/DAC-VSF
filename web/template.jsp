<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>VSF</title>
	<jsp:include page="includes/commom/head/assets.jsp" />
</head>

<body>
	<div class="header container-fluid">		
		<div class="pull-left">
			<h1>Banco VSF</h1>
		</div>

		<div class="pull-right">
			Bem vindo, Usuário!

			<button type="submit" class="btn btn-lg btn-primary">
				<i class="fa fa-sign-out fa-fw" aria-hidden="true"></i>&nbsp; Sair
			</button>
		</div>
	</div>

	<div class="nav col-md-3">
		<jsp:include page="includes/sidebar.jsp" />
	</div>

	<div class="section col-md-9">
		Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
	</div>
</body>
</html>