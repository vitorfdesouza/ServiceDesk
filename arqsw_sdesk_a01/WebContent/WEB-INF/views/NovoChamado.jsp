
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>

<html>

<head>
   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Novo Chamado</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navega��o -->
    <c:import url="Menu.jsp" />
    
    <!-- Container Principal -->
    <div id="main" class="container">
		<h3 class="page-header">Novo Chamado</h3>
		<form action="novo_chamado" method="post">
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="descricao">Descri��o:</label>
                    <input type="text" class="form-control" name="descricao" required maxlength="100" placeholder="descri&ccedil;&atilde;o do chamado">
                    <form:errors path="chamado.descricao" cssStyle="color:red"/>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="fila">Fila:</label>
                    <select class="form-control" name="fila.id">
                        <c:forEach var="fila" items="${lista}">
                            <option value="${fila.id}">${fila.nome}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="acao" value="Salvar">Salvar</button>
                    <a href="index" class="btn btn-default">Cancelar</a>
                </div>
			</div>
        </form>
    </div>
    
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
</body>

</html>