<%@ page language="java" contentType="text/html;charset=UTF-8" %><%--pageEncoding="UTF-8"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Messages</title>
    </head>
    <body>

                    <h1>Main</h1>

            <div> <a href="${pageContext.request.contextPath}/ui/singUp.jsp"><button>singUp</button></a></div>
            <div> <a href="${pageContext.request.contextPath}/ui/singIn.jsp"><button>singIn</button></a></div>
            <div> <a href="${pageContext.request.contextPath}/api/admin/statistics"><button>statistics</button></a></div>

    </body>
    </html>
