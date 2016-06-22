<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<h1>Novo depósito</h1>
<hr>

<p>
    Pensando na sua comodidade, o Banco Virtude Financeira disponibiliza para seus
    clientes o deposito virtual. Assim, você pode depositar dinheiro <b>sem precisar</b>
    sair de casa.
    <br>
    Como funciona? O Banco Virtude financeira <b>possui uma grande</b>
    frota de motoboys para realizar a entrega de seu dinheiro.
    <br>
    <br>
    Quer mais comodidade que isso?
</p>


<form class="form" action="InsertToken?action=Deposit" method="POST">
	<div class="col-md-12">                                    
		<div class="form-group">
			<label>Valor do deposito:</label>
			<input type="number" class="form-control" id="value" name="amount" value="R$0000,00">
		</div>
	</div>
    
    <div class="text-center">
        <input type="submit" class="btn btn-primary" value="Depositar" />
    </div>
</form>