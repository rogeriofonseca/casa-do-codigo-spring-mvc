<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>	
<nav id="main-nav">
    <ul class="clearfix">

        <li><a href="${spring:mvcUrl('SCC#items').build()}" rel="nofollow">Seu carrinho (${shoppingCart.quantity}) </a></li>

        <li><a href="/pages/sobre-a-casa-do-codigo" rel="nofollow">Sobre
                nós </a></li>

        <li><a href="/pages/perguntas-frequentes" rel="nofollow">Perguntas
                Frequentes </a></li>

        <li>
            <a href="<c:url value="/produtos?locale=pt"/>">Português</a>
        </li>		
        <li>
            <a href="<c:url value="/produtos?locale=en_US"/>">Inglês</a>
        </li>		

    </ul>
</nav>