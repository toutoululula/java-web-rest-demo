<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap Login Form Template</title>

       

    </head>

    <body>

       <form id="myform">
       name:<input type="text" value="" id="name"/>
       pwd:<input type="password" value="" id="pwd"/>
       <button id="bt">submit</button>
       </form>


        <!-- Javascript -->
        <script src="assets/jquery3.min.js"></script>
        <script src="assets/json2.js"></script>
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->
	<script>
	function $le(str){
		var flag=str.substring(0,1)
		str=str.substring(1)
		if(flag=='#')return document.getElementById(str)
		else if(flag=='.')return document.getElementByClassName(str)
		else return null
	}
	window.onload=function(){
		var btn=$le("#bt");
		btn.onclick=function(){
			var req_user = new Object();
			req_user.userName = $le("#name").value;
			req_user.password = $le("#pwd").value;
			//alert( JSON.stringify(req_user))
			
			$.ajax({
				  type: 'POST',
				  url: "http://localhost:8080/myWebapp/user/doLogin",
				  data: JSON.stringify(req_user),
				  processData: true,
				  cache:false,
		          async:false,
				  contentType: "application/json; charset=utf-8",			  
				  dataType: "json",
				  success:function(data){
					//var o = $.parseJSON(data);
					 if ( data.success && data.success == true){					 
						 $(function(){location.href='http://localhost:8080/myWebapp/welcome2.jsp'})
						 //alert(data.msg);
					 }else{
						 alert(data.msg);
					 } 
					//alert(data)
				  } ,
				  error: function (xhr) {alert(xhr.responseText)},
				  timeout:60000 
			}); 
		}
	}
	</script>
    </body>

</html>