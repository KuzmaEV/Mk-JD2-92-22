<%@ page language="java" contentType="text/html;charset=UTF-8" %><%--pageEncoding="UTF-8"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Products</title>
    </head>
    <body>

    <table border="1">
                <caption>Продукты</caption>
                <tr>
                                <td>ID</td>
                                <td>Name</td>
                                <td>Price</td>
                                <td>Sale</td>
                                <td>Description</td>
                </tr>
                <c:forEach items="${products}" var="item">
                <tr>
                    <td><c:out value="${item.id}"/></td>
                    <td><c:out value="${item.name}"/></td>
                    <td><c:out value="${item.price}"/></td>
                    <td><c:out value="${item.sale}"/>%</td>
                    <td><c:out value="${item.description}"/></td>

                </tr>
                </c:forEach>
            </table>
           <div> <a href="view/addProduct.jsp"><button>Добавить продукт</button></a></div>

    </body>
    </html>
