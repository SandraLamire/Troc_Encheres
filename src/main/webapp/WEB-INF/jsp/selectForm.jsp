<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%-- <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet"> --%>
<title>Insert title here</title>
</head>
<body>

<form>
<fieldset id="group1">
    <div class="shopping"><input type="radio" name="shopping" id="shopping" value="shopping" class="shopping"> Achats :
    <hr><br>
    <div><input type="radio" name="radio" value="radio" id="radio">
      <label for="check">Ench�res ouvertes</label></div>
      <br>
    <div><input type="radio" name="radio" value="radio" id="radio">
      <label for="check">Mes ench�res</label></div>
      <br>
    <div><input type="radio" name="radio" value="radio" id="radio">
      <label for="check">Mes ench�res remport�es</label></div>
      <br>
</div>
  <div class="shopping">
  <input type="radio" id="shopping" name="shopping" value="shopping" class="shopping">Mes ventes :
  <hr><br>
   <div><input type="radio" name="radio" value="radio" id="radio">
      <label for="check">Mes ventes en cours</label></div>
      <br>
    <div><input type="radio" name="radio" value="radio" id="radio">
      <label for="check">Ventes non d�but�es</label></div>
      <br>
    <div><input type="radio" name="radio" value="radio" id="radio">
      <label for="check">Ventes termin�es</label></div>
      <br>
      </div>
</fieldset> 

  </form>
</body>
</html>