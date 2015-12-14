<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <div>
            ${sucesso}
        </div>
        <table>
            <th>
                <td>Titulo</td>
                <td>Data</td>
                <td>Valores</td>
            </th>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.title}</td>
                    <td><a href="${spring:mvcUrl('PC#show').arg(0,product.id).build}" >${product.releaseDate}</td>
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
    