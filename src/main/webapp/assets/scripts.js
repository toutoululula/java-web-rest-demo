
jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    $.backstretch("assets/img/backgrounds/1.jpg");
    
    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    $('.login-form').on('submit', function(e) {
    	
    	/*$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');*/
    			var req_user = new Object();
		req_user.userName = document.getElementById("form-username").value;
		req_user.password = document.getElementById("form-password").value;
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
    		
    	
    	
    });
   
    
});
