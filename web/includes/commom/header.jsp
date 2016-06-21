<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="pull-left">
	<h1>Banco VSF</h1>
</div>

<div class="pull-right">
        <form action="Logout">
	Bem vindo(a), ${user.name}!
        
        
	<button type="submit" class="btn btn-lg btn-primary">
		<i class="fa fa-sign-out fa-fw" aria-hidden="true"></i>&nbsp; Sair
	</button>
        </form>
</div>