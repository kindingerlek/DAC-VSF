<%@ page contentType="text/html; charset=UTF-8" %>

<div class="page-header container-fluid">

	<div class="col-md-5">
	<h1>Banco VSF</h1>
	</div>

	<div class="col-md-7">
		<div class="pull-right">
			<form class="form-inline" action="Login" method="POST">
				<label for="">Agência / Conta / Senha:</label>
				<div class="form-group">
                                    <input type="text" class="form-control agency" id="agency_input" name="agency_input" placeholder="00000" size=5 maxlength=5 required>
				</div>

				<div class="form-group">
					<input type="text" class="form-control account" id="account_input" name="account_input" placeholder="00000-0" size=7 maxlength=7 required>
				</div>

				<div class="form-group">
					<input type="password" class="form-control" id="password_input" name="password_input" placeholder="********" size=8 maxlength=8 required>
				</div>

				<button type="submit" class="btn btn-lg btn-primary">
					<i class="fa fa-lock fa-fw" aria-hidden="true"></i>&nbsp; Acessar
				</button>
			</form>
		</div>
	</div>
</div>	