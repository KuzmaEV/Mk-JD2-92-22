<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>AddProduct</title>
    </head>
    <body>
            <form  accept-charset="UTF-8" method="post" action="${pageContext.request.contextPath}/addProduct" >
                <div>Название продукта<br>
                <input tabindex="1" type="text" name="name"></input>
                </div>

                <div>Стоимость<br>
                <input tabindex="2" type="text" name="price"></input>
                </div>

                <div>Скидка<br>
                <input tabindex="3" type="text" name="sale"></input>
                </div>

                <label>Описание<br>
                <textarea tabindex="4" name="description" placeholder="Описание продукта"></textarea></label>
                <br>


            <button tabindex="5" type="submit">Отправить</button>
            <button tabindex="6" type="reset">Сбросить</button><br>
            </form>
           <div> <a href="${pageContext.request.contextPath}">
           <button>Список продуктов</button></a></div>
           <p style="color: green"><c:out value="${added}"/></p>

    </body>
    </html>