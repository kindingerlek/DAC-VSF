<%@ page contentType="text/html; charset=UTF-8" %>

<div class="panel">
  <div class="panel-body">

    <div class="container-fluid">
      <h1>Não possui cadastro ainda?</h1>                                
    </div> 

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

      <jsp:include page="form/person.jsp" />
      
      <jsp:include page="form/enterprise.jsp" />

      <div class="text-center">
        <button type="submit" class="btn btn-lg btn-primary">Cadastrar</button>
      </div> 
    </form>
  </div>
</div>  