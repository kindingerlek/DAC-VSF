<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
  <title>VSF - Tela Inicial</title>
  <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/bootflat/css/bootflat.css">
  <link rel="stylesheet" href="assets/css/application.css">
  <link rel="stylesheet" href="assets/square/blue.css">
  
  <!-- JQuery file-->
  <script src="assets/js/jquery.js"></script>

  <!-- Bootstrap Files -->
  <script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

  <!-- Bootflat's JS files.-->
  <script src="assets/bootflat/js/icheck.min.js"></script>
  <script src="assets/bootflat/js/jquery.fs.selecter.min.js"></script>
  <script src="assets/bootflat/js/jquery.fs.stepper.min.js"></script>

  
</head>

<body>

  <header>
    <h1>Header</h1>
  </header>

  <div class="section">                    
    <div class="col-md-6">
      <div class="panel">
        <div class="panel-body">

          <div class="container-fluid">
            <h1>Não possui cadastro ainda?</h1>                                
          </div> 

          <form>
            <div class="col-md-12">
              <div class="form-group">
                <label for="">Tipo de Pessoa:</label>
                <br>
                <input type="radio" name="typePerson" value="PF" id="123" checked> Pessoa Física
                <br>
                <br>      
                <input type="radio" name="typePerson" value="PJ"> Pessoa Jurídica
              </div>
            </div>

            <!-- inputs for person -->
            <div id="person-section">
              <div class="col-md-12">                                    
                <div class="form-group">
                  <label for="">Nome Completo:</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Nome">
                </div>
              </div>

              <div class="col-md-12">                                    
                <div class="form-group">
                  <label for="">Email:</label>
                  <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                </div>
              </div>

              <div class="col-md-6">                                    
                <div class="form-group">
                  <label for="">CPF:</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" placeholder="CPF">
                </div>
              </div>

              <div class="col-md-6">                                    
                <div class="form-group">
                  <label for="">RG:</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" placeholder="RG">
                </div>
              </div>

              <div class="col-md-6">                                    
                <div class="form-group">
                  <label for="">Senha:</label>
                  <input type="password" class="form-control" id="exampleInputEmail1" placeholder="Senha">
                </div>
              </div>

              <div class="col-md-6">                                    
                <div class="form-group">
                  <label for="">Confirmar senha:</label>
                  <input type="password" class="form-control" id="exampleInputEmail1" placeholder="Confirmação da Senha">
                </div>
              </div>                          
            </div>

            <!-- inputs for enterprise -->
            <div id="enterprise-section" style="display: none;">
              <div class="col-md-12">                                    
                <div class="form-group">
                  <label for="">Nome da Empresa:</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Nome da Fantasia">
                </div>
              </div>

              <div class="col-md-12">                                    
                <div class="form-group">
                  <label for="">Email da Empresa:</label>
                  <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email da Empresa">
                </div>
              </div>

              <div class="col-md-6">                                    
                <div class="form-group">
                  <label for="">Nome Fantasia:</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Nome Dantasia">
                </div>
              </div>             

              <div class="col-md-6">                                    
                <div class="form-group">
                  <label for="">CNPJ:</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" placeholder="CNPJ">
                </div>
              </div>


              <div class="col-md-6">                                    
                <div class="form-group">
                  <label for="">Senha:</label>
                  <input type="password" class="form-control" id="exampleInputEmail1" placeholder="Senha">
                </div>
              </div>

              <div class="col-md-6">                                    
                <div class="form-group">
                  <label for="">Confirmar senha:</label>
                  <input type="password" class="form-control" id="exampleInputEmail1" placeholder="Confirmação da Senha">
                </div>
              </div>                          
            </div>

            <div class="text-center">
              <button type="submit" class="btn btn-lg btn-primary">Cadastrar</button>
            </div> 
          </form>
        </div>
      </div>
    </div>

    <div class="col-md-6">
     <div class="panel">
      <div class="panel-body">

        <div class="container-fluid">
          <h1>Criar uma nova conta no banco?</h1>                          
        </div>

        <div class="container-fluid text-justified">          
          <p>
            Criar uma nova conta no banco é simples, rápido e prático. Basta inserir seu e-mail e sua senha nos campos abaixo e então validar com o seu Token.
          </p>

          <p>
            Torne o gerenciamento dos seus gastos mais facil, com múltiplas contas.
          </p>
        </div>

        <form>
          <div class="col-md-12">                                    
            <div class="form-group">
              <label for="">Email:</label>
              <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Seu email">
            </div>
          </div>

          <div class="col-md-12">                                    
            <div class="form-group">
              <label for="">Senha:</label>
              <input type="password" class="form-control" id="exampleInputEmail1" placeholder="Sua senha">
              <a href="#"> Esqueceu sua senha?</a>
            </div>
          </div>

          <div class="text-center">
            <button type="submit" class="btn btn-lg btn-primary">Criar uma nova conta</button>
          </div>
          <!-- fim do form -->
        </form>

      </div>

      <!-- fim do panel -->
    </div>
  </div>   
</div>

<script>
  $(document).ready(function(){
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
    });

    $("input[name=typePerson]:radio").on('ifChecked', function(event){
      if (this.value == 'PF') {
        $('#person-section').show();            
        $('#enterprise-section').hide();
      }
      else {            
        $('#person-section').hide();            
        $('#enterprise-section').show();
      }
    });

  });

</script>

</body>
</html>