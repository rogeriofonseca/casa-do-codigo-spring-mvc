<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Cadastro de Produtos</title>
    </head>
    <body>
        <div>
        <spring:hasBindErrors name="product">
            <ul>
                <c:forEach var="error" items="${errors.allErrors}">
                    <li>${error.code}</li>
                </c:forEach>
            </ul>
        </spring:hasBindErrors>
        </div>
        <form method="post" action="/casadocodigo/produtos">
            <div>
                <label for="title">Título</label>
                <input type="text" name="title" id="title"/>
            </div>
            <div>
                <label for="description">Descrição</label>
                <textarea rows="10" cols="20" name="description" id="description"></textarea>
            </div> <div>
                <label for="pages">Número de páginas</label>
                <input type="text" name="pages" id="pages"/>
            </div>
            <c:forEach items="${types}" var="bookType" varStatus="status">
                <div>
                    <label for="price_${bookType}">${bookType}</label>
                    <input type="text" name="prices[${status.index}].value" id="price_${bookType}"/>
                    <input type="hidden" name="prices[${status.index}].bookType" value="${bookType}"/>
                </div>
            </c:forEach>
            <div>
                <input type="submit" value="Enviar">
            </div>
        </form>
    </body>
</html>
