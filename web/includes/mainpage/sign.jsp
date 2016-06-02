<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page contentType="text/html; charset=UTF-8" %>

<h1>Não possui cadastro ainda?</h1>                                
<hr>

<form action="../addUser" method="POST">
  <div class="col-md-12">
    <div class="form-group">
      <label for="">Tipo de Pessoa:</label>
      <br>
      <input type="radio" name="personType" value="1" id="123" checked> Pessoa Física
      <br>
      <br>      
      <input type="radio" name="personType" value="2"> Pessoa Jurídica
    </div>
  </div>

  <jsp:include page="../person/person/new.jsp" />
  
  <jsp:include page="../person/enterprise/new.jsp" />

  <div class="text-center">
    <button type="submit" class="btn btn-lg btn-primary">Cadastrar</button>
  </div> 
</form>
