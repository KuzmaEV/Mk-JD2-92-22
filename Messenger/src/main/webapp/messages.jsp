<%@ page language="java" contentType="text/html;charset=UTF-8" %><%--pageEncoding="UTF-8"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Messages</title>
    </head>
    <body>

                    <c:forEach items="${messagesList}" var="message">

                       <div> <c:out value="${message.date}"/></div>
                       <div> <c:out value="${message.from.getName()}"/></div>
                       <div> <c:out value="${message.text}"/></div>
                       <div>================================</div>

                    </c:forEach>

           <div> <a href="${pageContext.request.contextPath}/ui/user/message"><button>Отправить сообщение</button></a></div>

    </body>
    </html>
