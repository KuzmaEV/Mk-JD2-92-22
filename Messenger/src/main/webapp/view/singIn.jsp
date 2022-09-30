<-- Зделать форму для входа пользователя с запросом на /api/login -->

<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>SingIn</title>
    </head>
    <body>
        <h1>Войти</h1>
            <form  accept-charset="UTF-8" method="post"
            action="${pageContext.request.contextPath}/api/login" >

                <div>Логин<br>
                <input tabindex="1" required type="text" name="login"></input>
                </div>

                <div>Пороль<br>
                <input tabindex="2" required type="password" name="password"></input>
                </div>
                <br>


            <button tabindex="5" type="submit">Отправить</button>
            <button tabindex="6" type="reset">Сбросить</button><br>
            </form>
           <div> <a href="${pageContext.request.contextPath}">
           <button>Главная</button></a></div>


    </body>
    </html>