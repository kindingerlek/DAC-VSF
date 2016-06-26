<%@ page contentType="text/html; charset=UTF-8" %>
<form action="addUser?personType=2" method="POST" id="enterprise-section" style="display: none;">

    <!-- inputs for enterprise -->
    <div>
        <div class="col-md-12">                                    
            <div class="form-group">
                <label for="">Nome da Empresa:</label>
                <input type="text" name="name" class="form-control" placeholder="Nome da Empresa" required>
            </div>
        </div>

        <div class="col-md-12">                                    
            <div class="form-group">
                <label for="">Email da Empresa:</label>
                <input type="email" name="email" id="emailPj" class="form-control" placeholder="gerencia@suaempresa.com" required>
            </div>
        </div>

        <div class="col-md-6">                                    
            <div class="form-group">
                <label for="">Nome Fantasia:</label>
                <input type="text" name="fantasyName" class="form-control"  placeholder="Nome Fantasia da sua empresa" required>
            </div>
        </div>             

        <div class="col-md-6">                                    
            <div class="form-group">
                <label for="">CNPJ:</label>
                <input type="text" name="cnpj" class="form-control cnpj" id="cnpj" placeholder="99.999.999/9999-99" required>
            </div>
        </div>


        <div class="col-md-6">                                    
            <div class="form-group">
                <label for="">Senha:</label>
                <input type="password" name="password" id="passwordPj" class="form-control"  placeholder="********" required>
            </div>
        </div>

        <div class="col-md-6">                                    
            <div class="form-group">
                <label for="">Confirmar senha:</label>
                <input type="password" name="confirmPassword" id="confirmPasswordPj" class="form-control"  placeholder="********" required>
            </div>
        </div>                          
    </div>
    <div class="text-center">
        <span class="error-person" style="color:red"></span>
        <button type="submit" class="btn btn-lg btn-primary submit-button">Cadastrar</button>
    </div> 
</form>