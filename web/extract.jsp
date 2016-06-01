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

					<div class="row">						
						<div class="pull-right">
							<a href="#" class="btn btn-primary">
								Ver detalhes
							</a>			
						</div>
					</div>	


					<div class="row">
						<div class="col-md-2">
						</div>


						<div class="timeline">
							<dl>
								<dt>Abril de 2016</dt>
								<dd class="pos-right clearfix withdrawal">
									<div class="circ"></div>
									<div class="time">14 de Abril</div>
									<div class="events">
										<div class="events-body text-center">
											<h4 class="events-heading">Saque</h4>
											<p class="value">Valor: -R$1200,00</p>
											<p>Saldo: R$30000,00</p>
										</div>
									</div>
								</dd>

								<dd class="pos-right clearfix withdrawal">
									<div class="circ"></div>
									<div class="time">10 de Abril</div>
									<div class="events">
										<div class="events-body text-center">
											<h4 class="events-heading">Saque</h4>
											<p class="value">Valor: -R$200,00</p>
											<p>Saldo: R$31400,00</p>
										</div>
									</div>
								</dd>						

								<dd class="pos-left clearfix deposit">
									<div class="circ"></div>
									<div class="time">2 de Abril</div>
									<div class="events">
										<div class="events-body text-center">
											<h4 class="events-heading">Depósito</h4>
											<p class="value">Valor: +R$1800,00</p>
											<p>Saldo: R$30000,00</p>
										</div>
									</div>
								</dd>
							</dl>

							<dl>
								<dt>Maio de 2016</dt>
								<dd class="pos-left clearfix deposit">
									<div class="circ"></div>
									<div class="time">24 de Maio</div>
									<div class="events">
										<div class="events-body text-center">
											<h4 class="events-heading">Transferência</h4>
											<p class="value">Valor: +R$10000,00</p>
											<p>Saldo: R$30000,00</p>
										</div>
									</div>
								</dd>

								<dd class="pos-right clearfix withdrawal">
									<div class="circ"></div>
									<div class="time">18 de Maio</div>
									<div class="events">
										<div class="events-body text-center">
											<h4 class="events-heading">Saque</h4>
											<p class="value">Valor: -R$200,00</p>
											<p>Saldo: R$31400,00</p>
										</div>
									</div>
								</dd>						

								<dd class="pos-left clearfix deposit">
									<div class="circ"></div>
									<div class="time">12 de Maio</div>
									<div class="events">
										<div class="events-body text-center">
											<h4 class="events-heading">Depósito</h4>
											<p class="value">Valor: +R$1800,00</p>
											<p>Saldo: R$30000,00</p>
										</div>
									</div>
								</dd>
							</dl>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>