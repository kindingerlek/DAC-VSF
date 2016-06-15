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
                <input type="email" name="email" id="emailPj" class="form-control" placeholder="gerencia@suaempresa.com">
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
                <input type="text" name="cnpj" class="form-control" id="cnpj" placeholder="99.999.999/9999-99">
            </div>
        </div>


        <div class="col-md-6">                                    
            <div class="form-group">
                <label for="">Senha:</label>
                <input type="password" name="password" id="passwordPj" class="form-control"  placeholder="********">
            </div>
        </div>

        <div class="col-md-6">                                    
            <div class="form-group">
                <label for="">Confirmar senha:</label>
                <input type="password" name="confirmPassword" id="confirmPasswordPj" class="form-control"  placeholder="********">
            </div>
        </div>                          
    </div>
    <div class="text-center">
        <span id="errorPj" style="color:red"></span>
        <button type="submit" id="cadastrar" class="btn btn-lg btn-primary">Cadastrar</button>
    </div> 
</form>
<script>
    $('#cnpj').on('blur', testCnpj);
    $('#confirmPasswordPj').on('blur', testPassword);
    $('#passwordPj').on('blur', testPassword);
    $('#emailPj').on('blur', testEmail);

    function testEmail() {
        var email = $('#emailPj').val();
        if (!/@/i.test(email)) {
            $('#errorPj').html('<p>Email inválido.</p>');
            $('#cadastrarPj').attr('disabled', 'disabled');
        } else {
            $('#errorPj').html('');
            $('#cadastrarPj').removeAttr('disabled');
        }
    }

    function testCnpj() {
        var cnpj = $('#cnpj').val().replace(/[.-]/g, '');
        if (!isNumeric(cnpj)) {
            $('#errorPj').html('<p>CNPJ com caracteres inválidos.</p>');
            $('#cadastrarPj').attr('disabled', 'disabled');
        } else if (!validateCnpj(cnpj)) {
            $('#errorPj').html('<p>CNPJ inválido.</p>');
            $('#cadastrarPj').attr('disabled', 'disabled');
        } else {
            $('#errorPj').html('');
            $('#cadastrarPj').removeAttr('disabled');
        }
    }

    function testPassword() {
        var password = $('#passwordPj').val();
        var confirmPassword = $('#confirmPasswordPj').val();
        if (password !== confirmPassword) {
            $('#errorPj').html('<p>Senhas incorretas.</p>');
            $('#cadastrarPj').attr('disabled', 'disabled');
        } else if (password === '' || confirmPassword === '') {
            $('#cadastrarPj').attr('disabled', 'disabled');
            $('#errorPj').html('<p>A senha em branco.</p>');
        } else if (!isAlphanumeric(password)) {
            $('#cadastrarPj').attr('disabled', 'disabled');
            $('#errorPj').html('<p>A senha tem caracteres inválidos.</p>');
        } else {
            $('#cadastrarPj').removeAttr('disabled');
            $('#errorPj').html('');
        }
    }
    
    function isAlphanumeric(str) {
        return /^[0-9a-zA-Z]+$/.test(str);
    }
    
    function isNumeric(str) {
        return /^[0-9]+/.test(str);
    }
    
    function validateCnpj(cnpj) {

        cnpj = cnpj.replace(/[^\d]+/g, '');

        if (cnpj === '')
            return false;

        if (cnpj.length !== 14)
            return false;

        // Elimina CNPJs invalidos conhecidos
        if (cnpj === "00000000000000" ||
                cnpj === "11111111111111" ||
                cnpj === "22222222222222" ||
                cnpj === "33333333333333" ||
                cnpj === "44444444444444" ||
                cnpj === "55555555555555" ||
                cnpj === "66666666666666" ||
                cnpj === "77777777777777" ||
                cnpj === "88888888888888" ||
                cnpj === "99999999999999")
            return false;

        // Valida DVs
        length = cnpj.length - 2;
        numbers = cnpj.substring(0, length);
        digits = cnpj.substring(length);
        add = 0;
        pos = length - 7;
        for (i = length; i >= 1; i--) {
            add += numbers.charAt(length - i) * pos--;
            if (pos < 2)
                pos = 9;
        }
        result = add % 11 < 2 ? 0 : 11 - add % 11;
        if (result !== digits.charAt(0))
            return false;

        length = length + 1;
        numbers = cnpj.substring(0, length);
        add = 0;
        pos = length - 7;
        for (i = length; i >= 1; i--) {
            add += numbers.charAt(length - i) * pos--;
            if (pos < 2)
                pos = 9;
        }
        result = add % 11 < 2 ? 0 : 11 - add % 11;
        if (result !== digits.charAt(1))
            return false;

        return true;

    }
</script>