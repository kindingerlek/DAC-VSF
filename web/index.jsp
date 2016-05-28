<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
  <title>VSF - Tela Inicial</title>

  <jsp:include page="includes/commom/head/assets.jsp" />  

  <link rel="stylesheet" href="assets/css/mainpage.css">  
  <link rel="stylesheet" href="assets/css/main-header.css">
</head>

<body>
  <jsp:include page="includes/mainpage/header.jsp" />  


  <div class="section container-fluid">                    
    <div class="col-md-6">      
      <jsp:include page="includes/mainpage/panel/sign.jsp" />
    </div>

    <div class="col-md-6">
     <jsp:include page="includes/mainpage/panel/new_account.jsp" />
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