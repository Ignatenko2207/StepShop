<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authorisatoin error</title>
<style>
   <%@include file='css/indexstyle.css' %>
</style>
</head>
<body>
<form action="authorisation" method="post" enctype="application/x-www-form-urlencoded">
   <div id="form">
    <div id="input-name">     
     <label for="username" id="label-name">Name:</label>
     
     
     
     <input id="input-name" size="24" type="text" name="username" placeholder="Your name">
    
    
    
    
    </div>
    <div id="input-pass"> 
     <label for="password" id="label-pass">Password:</label>
     
     
     
     <input  id="input-pass" size="24" type="password" name="password" placeholder="Your password">
    
    
    .
    
    </div>
    <div id="botton" >
     <input type="submit" class="btn-class" value="Submit">
    </div>
   </div>
  </form>
  
  <div>ERROR AUTHOROISATION!!!</div>
</body>
</html>