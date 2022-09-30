<--надо сделать форму для регистрации и должна выполнять запрос на /api/user -->

<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <h1>Регистрация</h1>
            <form  accept-charset="UTF-8" method="post"
            action="${pageContext.request.contextPath}/api/user" >

                <div>Логин<br>
                <input tabindex="1" required type="text" name="login"></input>
                </div>

                <div>Пороль<br>
                <input tabindex="2" required type="password" name="password"></input>
                </div>

                <div>ФИО<br>
                <input tabindex="3" required type="text" name="name"></input>
                </div>

                <div>Дата рождения<br>
                <input tabindex="4" placeholder="form: dd-MM-yyyy"
                required type="text" name="dateOfBirth"></input>
                </div>
                <br>


            <button tabindex="5" type="submit">Отправить</button>
            <button tabindex="6" type="reset">Сбросить</button><br>
            </form>
           <div> <a href="${pageContext.request.contextPath}">
           <button>Главная</button></a></div>


    </body>
    </html>