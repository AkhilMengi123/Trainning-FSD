<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="bootstrap/bootstrap.html" %>
</head>
<body>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-8">
<h2 style="text-align:center;color:blue">Create Wallet<hr></h2>
<br><hr>
<%@ include file="nav.html" %>
<br><br><br>
<form action="create" class="was-validated">
    <div class="form-group">
      <label for="uname">Mobile Number:</label>
      <input type="text" class="form-control" id="uname" placeholder="Enter Mobile Number" name="mobile_no" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
     <div class="form-group">
      <label for="uname">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter username" name="name" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div>
    </div>
    
     
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>
<div class="col-sm-2"></div>
</div>
 
</body>
</html>