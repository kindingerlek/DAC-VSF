<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Nova Transação</h1>
<hr>

<p>

</p>


<form class="form" action="InsertTransferToken?action=Transfer" method="POST">

    <div class="row">
        <div class="col-md-12">
            <div class="form-group">

                <label>Destino da tranferência:</label><br>
                <input type="radio" name="destinationType" id="" value="1">&nbsp; Para uma de minhas contas.<br>

                <br>
                <input type="radio" name="destinationType" id="" value="2">&nbsp; Para uma conta de Terceiros.<br>

            </div>
        </div>

        <div class="col-md-6">                                    
            <div class="form-group">
                <label>Valor da Tranferência:</label>
                <input type="text" class="form-control" name="ammount" value="" />
            </div>
        </div>
    </div>


    <div id="myAccounts" class="row">
        <h4> Para uma de minhas contas</h4>

        <div class="col-md-6">
            <div class="form-group">
                <select class="form-control" name="same_account_number">
                    <c:forEach var="account" items="${sessionScope.user.activeAccounts}">
                        <option value="${account.number}">${account.number}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>

    <div id="otherAccounts" class="row">
        <h4> Para conta de terceiros</h4>

        <div class="col-md-6">                                    
            <div class="form-group">
                <label>CPF:</label>
                <input type="text" class="form-control" name="identifier" value="" />
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

    <div class="row text-center">
        <input type="submit" class="btn btn-primary" value="Realizar transferência" />
    </div>

</form>
