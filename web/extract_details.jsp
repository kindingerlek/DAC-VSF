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

		<div class="panel panel-default">
			<div class="panel-body">
				<div class="container-fluid">
					<h1>Extrato</h1>
					<hr>

					<h2> Intervalo:</h2>

					<form>
						De: <input type="date" name=""/> à <input type="date" name="" \>

						<div class="pull-right">
							<button class="btn btn-primary">
								<i class="fa fa-search fa-1x"></i>
								Pesquisar
							</button>
						</div>
					</form>

					<br>

					<table class="table table-striped">
						<th>
							<td class="col-md-4">Descrição</td>
							<td class="col-md-2">Entrada</td>
							<td class="col-md-2">Saída</td>
							<td class="col-md-2">Data</td>
						</th>
					</table>
				</div>


			</div>

		</div>			
	</div>



	<div class="row">

	</div>
</div>
</body>
</html>