

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form  action="login" method="post" name="">
         
            Username: <input type="text" name="username" value="" /><br>
            Password: <input type="password" name="password" value="" /><br>
           
             <input type="submit" value="Log in" /> <br>
        </form>
        <br>
        <p name="msg" value="">${msg}
            
       
    </body>
</html>
