<%@ page contentType="text/html; charset=UTF-8" %>
<form action="addUser?personType=2" method="POST" id="enterprise-section" style="display: none;">

    <!-- inputs for enterprise -->
    <div>
        <div class="col-md-12">                                    
            <div class="form-group">
                <label for="">Nome da Empresa:</label>
                <input type="text" name="name" class="form-control" placeholder="Nome da Empresa">
            </div>
        </div>

        <div class="col-md-12">                                    
            <div class="form-group">
                <label for="">Email da Empresa:</label>
                <input type="email" name="email" class="form-control" placeholder="gerencia@suaempresa.com">
            </div>
        </div>

        <div class="col-md-6">                                    
            <div class="form-group">
                <label for="">Nome Fantasia:</label>
                <input type="text" name="fantasyName" class="form-control"  placeholder="Nome Fantasia da sua fantasia">
            </div>
        </div>             

        <div class="col-md-6">                                    
            <div class="form-group">
                <label for="">CNPJ:</label>
                <input type="text" name="cnpj" class="form-control"  placeholder="99.999.999/9999-99">
            </div>
        </div>


        <div class="col-md-6">                                    
            <div class="form-group">
                <label for="">Senha:</label>
                <input type="password" name="password" class="form-control"  placeholder="********">
            </div>
        </div>

        <div class="col-md-6">                                    
            <div class="form-group">
                <label for="">Confirmar senha:</label>
                <input type="password" name="confirmPassword" class="form-control"  placeholder="********">
            </div>
        </div>                          
    </div>
    <div class="text-center">
        <button type="submit" class="btn btn-lg btn-primary">Cadastrar</button>
    </div> 
</form>