<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Nova Transação</h1>
<hr>


<p>

</p>


<form action="action" class="form">

    <div class="row">
        <div class="col-md-12">
            <div class="form-group">

                <label>Destino da tranferência:</label><br>
                <input type="radio" name="personType" id="" value="1">&nbsp; Para uma de minhas contas.<br>
                <input type="radio" name="personType" id="" value="2">&nbsp; Para uma conta de Terceiros.<br>

            </div>
        </div>

        <div class="col-md-6">                                    
            <div class="form-group">
                <label>Valor da Tranferência:</label>
                <input type="text" class="form-control" name="value" value="" />
            </div>
        </div>
    </div>


    <div id="my_accounts" class="row">
        <h4> Para uma de minhas contas</h4>
        <div class="col-md-6">
            <div class="form-group">
                <select class="form-control">
                    <option value="12345-12332">12345-12332</option>
                    <option value="12345-12332">12345-12332</option>
                    <option value="12345-12332">12345-12332</option>
                    <option value="12345-12332">12345-12332</option>
                    <option value="12345-12332">12345-12332</option>
                    <option value="12345-12332">12345-12332</option>
                    <option value="12345-12332">12345-12332</option>
                </select>
            </div>
        </div>
    </div>

    <div id="other_accounts" class="row">
        <h4> Para conta de terceiros</h4>

        <div class="col-md-6">                                    
            <div class="form-group">
                <label>CPF:</label>
                <input type="text" class="form-control" name="cpf" value="" />
            </div>
        </div>

        <div class="col-md-2">                                    
            <div class="form-group">
                <label>Agência:</label>
                <input type="text" class="form-control" name="other_account_agency" value="" />
            </div>
        </div>

        <div class="col-md-2">                                    
            <div class="form-group">
                <label>Conta:</label>
                <input type="text" class="form-control" name="other_account_number" value="" />
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">                                    
            <div class="form-group">
                <label>Sua senha:</label>
                <input type="password" class="form-control" name="password" value="" />
            </div>
        </div>
    </div>

    <div class="row text-center">
        <input type="submit" class="btn btn-primary" value="Realizar transferência" />
    </div>

</form>
