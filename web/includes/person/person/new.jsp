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
        <span id="error" style="color:red"></span>
        <button type="submit" id="cadastrar" class="btn btn-lg btn-primary">Cadastrar</button>
    </div> 
</form>
<script>
    $('#cpfInput').on('blur', testCpf);
    $('#confirmPassword').on('blur', testPassword);
    $('#password').on('blur', testPassword);
    $('#email').on('blur', testEmail);

    function testEmail() {
        var email = $('#email').val();
        if (!/@/i.test(email)) {
            $('#error').html('<p>Email inválido.</p>');
            $('#cadastrar').attr('disabled', 'disabled');
        } else {
            $('#error').html('');
            $('#cadastrar').removeAttr('disabled');
        }
    }

    function testCpf() {
        var cpf = $('#cpfInput').val().replace(/[.-]/g, '');
        if (!isNumeric(cpf)) {
            $('#error').html('<p>CPF com caracteres inválidos.</p>');
            $('#cadastrar').attr('disabled', 'disabled');
        } else if (!validateCpf(cpf)) {
            $('#error').html('<p>CPF inválido.</p>');
            $('#cadastrar').attr('disabled', 'disabled');
        } else {
            $('#error').html('');
            $('#cadastrar').removeAttr('disabled');
        }
    }

    function testPassword() {
        var password = $('#password').val();
        var confirmPassword = $('#confirmPassword').val();
        if (password !== confirmPassword) {
            $('#error').html('<p>Senhas incorretas.</p>');
            $('#cadastrar').attr('disabled', 'disabled');
        } else if (password === '' || confirmPassword === '') {
            $('#cadastrar').attr('disabled', 'disabled');
            $('#error').html('<p>A senha em branco.</p>');
        } else if (!isAlphanumeric(password)) {
            $('#cadastrar').attr('disabled', 'disabled');
            $('#error').html('<p>A senha tem caracteres inválidos.</p>');
        } else {
            $('#cadastrar').removeAttr('disabled');
            $('#error').html('');
        }
    }

    function isAlphanumeric(str) {
        return /^[0-9a-zA-Z]+$/.test(str);
    }
    
    function isNumeric(str) {
        return /^[0-9]+/.test(str);
    }

    function validateCpf(cpf) {
        var add;
        var mod;
        add = 0;
        if (cpf === "00000000000")
            return false;

        for (i = 1; i <= 9; i++)
            add = add + parseInt(cpf.substring(i - 1, i)) * (11 - i);
        mod = (add * 10) % 11;

        if ((mod === 10) || (mod === 11))
            mod = 0;
        if (mod !== parseInt(cpf.substring(9, 10)))
            return false;

        add = 0;
        for (i = 1; i <= 10; i++)
            add = add + parseInt(cpf.substring(i - 1, i)) * (12 - i);
        mod = (add * 10) % 11;

        if ((mod === 10) || (mod === 11))
            mod = 0;
        if (mod !== parseInt(cpf.substring(10, 11)))
            return false;
        return true;
    }


</script>