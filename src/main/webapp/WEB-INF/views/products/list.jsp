<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
    <security:authorize access="isAuthenticated()">
        <security:authentication property="principal" var="user"/>
        <div><spring:message code="users.welcome" arguments="${user.name}" /></div>
    </security:authorize>
    <div>
        ${sucesso}
    </div>
    <ul class="menu">
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="${spring:mvcUrl('PC#form').build()}">Cadastrar novo produto</a></li>
        </sec:authorize>
    </ul>
    <table>
        <th>
        <td>Titulo</td>
        <td>Data</td>
        <td>Valores</td>
    </th>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.title}</td>
            <!--<td>${product.releaseDate}</td>-->
            <td><a href="${spring:mvcUrl('PC#show').arg(0,product.id).build()}" >${product.title}</td>
            <td>
                <c:forEach items="${product.prices}" var="price">
                    [${price.value} - ${price.bookType}]
                </c:forEach>
            </td>
        </tr>    
    </c:forEach>
</table>
</body>
</html>
