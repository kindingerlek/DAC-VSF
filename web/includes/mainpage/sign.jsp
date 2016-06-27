<%@ page contentType="text/html; charset=UTF-8" %>

<h1>Não possui cadastro ainda?</h1>                                
<hr>

<div class="col-md-12">
  <div class="form-group">
    <label for="">Tipo de Pessoa:</label>
    <br>
    <input type="radio" name="personType" id="pf" value="1" checked> Pessoa Física
    <br>
    <br>      
    <input type="radio" name="personType" id="pj" value="2"> Pessoa Jurídica
  </div>
</div>

<jsp:include page="../person/person/new.jsp" />

<jsp:include page="../person/enterprise/new.jsp" />
