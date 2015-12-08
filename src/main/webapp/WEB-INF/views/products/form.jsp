<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Cadastro de Produtos</title>
    </head>
    <body>
        <div>
        </div>
        <form:form action="${spring:mvcUrl('PC#save').build()}" method="post" commandName="product" enctype="multipart/form-data">
            <div>
                <label for="title">Título</label>
                <form:input path="title"/>
                <form:errors path="title"/>
            </div>
            <div>
                <label for="description">Descrição</label>
                <form:textarea path="description" rows="10" cols="20"/>
                <form:errors path="description"/>
            </div> <div>
                <label for="pages">Número de páginas</label>
                <form:input path="pages"/>
                <form:errors path="pages"/>
            </div>
            <c:forEach items="${types}" var="bookType" varStatus="status">
                <div>
                    <label for="price_${bookType}">${bookType}</label>
                    <input type="text" name="prices[${status.index}].value" id="price_${bookType}"/>
                    <input type="hidden" name="prices[${status.index}].bookType" value="${bookType}"/>
                </div>
            </c:forEach>
            <div>
                <label for="releaseDate">Data de lançamento</label>
                <form:input path="releaseDate" type="date"/>
                <form:errors path="releaseDate"/>
            </div>
            
            <div>
                <label for="summary">Sumário do livro</label>
                <input type="file" name="summary"/>
            </div>
            <div>
                <input type="submit" value="Enviar">
            </div>
        </form:form>
    </body>
</html>
