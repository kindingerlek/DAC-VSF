<%@ page contentType="text/html; charset=UTF-8" %>

<h1>Criar uma nova conta bancária?</h1>

<hr>

<div class="text-justified">          
  <p>
    Criar uma nova conta no banco é simples, rápido e prático. Basta inserir seu e-mail e sua senha nos campos abaixo e então validar com o seu Token.
  </p>

  <p>
    Torne o gerenciamento dos seus gastos mais facil, com múltiplas contas.
  </p>
</div>

<form action="OpenAccount" method="POST">
  <div class="col-md-12">                                    
    <div class="form-group">
      <label for="">Email:</label>
      <input type="text" class="form-control" id="account-email" name="email" placeholder="exemplo@dominio.com">
    </div>
  </div>

  <div class="col-md-12">                                    
    <div class="form-group">
      <label for="">Senha:</label>
      <input type="password" class="form-control" id="account-password" name="password" placeholder="********">
    </div>
  </div>

  <div class="text-center">
    <button type="submit" id="account-submit" class="btn btn-lg btn-primary">Criar uma nova conta</button>
  </div>

</form>
