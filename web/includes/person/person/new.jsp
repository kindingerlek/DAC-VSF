<%@ page contentType="text/html; charset=UTF-8" %>
<form action="addUser?personType=1" method="POST" id="person-section">
    <!-- inputs for person -->
    <div>
        <div class="col-md-12">                                    
            <div class="form-group">
                <label for="">Nome Completo:</label>
                <input type="text" name="name" class="form-control" id="exampleInputEmail1" placeholder="Seu nome completo">
            </div>
        </div>

        <div class="col-md-12">                                    
            <div class="form-group">
                <label for="">Email:</label>
                <input type="email" name="email" class="form-control" id="email" placeholder="exemplo@dominio.com">
            </div>
        </div>

        <div class="col-md-6">                                    
            <div class="form-group">
                <label for="">CPF:</label>
                <input type="text" name="cpf" class="form-control" id="cpfInput" placeholder="000.000.000-00">
            </div>
        </div>

        <div class="col-md-6">                                    
            <div class="form-group">
                <label for="">RG:</label>
                <input type="text" name="rg" class="form-control" id="exampleInputEmail1" placeholder="">
            </div>
        </div>

        <div class="col-md-6">                                    
            <div class="form-group">
                <label for="">Senha:</label>
                <input type="password" name="password" id="password" class="form-control" id="exampleInputEmail1" placeholder="********">
            </div>
        </div>

        <div class="col-md-6">                                    
            <div class="form-group">
                <label for="">Confirmar senha:</label>
                <input type="password" name="confirmPassword" id="confirmPassword" class="form-control" id="exampleInputEmail1" placeholder="********">
            </div>
        </div>                          
    </div>
    <div class="text-center">
        <span class="error-person" style="color:red"></span>
        <button type="submit" class="btn btn-lg btn-primary submit-button">Cadastrar</button>
    </div> 
</form>