<-- при Гет запросе будет отображаться форма для отправки сообщения(логин кому/текст) .
 Отпр на Пост api/message -->

 <%@ page language="java" contentType="text/html; charset=UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <!DOCTYPE html>
     <html lang="en">
     <head>
         <meta charset="UTF-8">
         <title>Registration</title>
     </head>
     <body>
         <h1>Сообщение</h1>
             <form  accept-charset="UTF-8" method="post"
             action="${pageContext.request.contextPath}/api/message" >

                 <div>Логин кому отправить сообщение<br>
                 <input tabindex="1" required type="text" name="login"></input>
                 </div>

                  <label>Сообщение<br>
                  <textarea tabindex="4" name="description" placeholder="Напиши сюда текс сообщения"></textarea></label>
                 <br>


             <button tabindex="5" type="submit">Отправить</button>
             <button tabindex="6" type="reset">Сбросить</button><br>
             </form>
            <div> <a href="${pageContext.request.contextPath}">
            <button>Главная</button></a></div>


     </body>
     </html>