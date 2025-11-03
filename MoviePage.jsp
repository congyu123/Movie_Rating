<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="entity.Movie "%>
<%@page import="dao.MovieDao"%>
<%@ page import="servlet.MovieServlet" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>电影详情</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<%





%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">电影网站</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="index.jsp">首页</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-5">
    <h1>${movie.name}</h1>
    <p>评分: ${movie.score}</p>
    <p>年份: ${movie.years}</p>
    <p>国家: ${movie.country}</p>
    <p>导演: ${movie.director}</p>
    <p>编剧: ${movie.scriptwriter}</p>
    <p>主演: ${movie.actor}</p>
    <p>语言: ${movie.languages}</p>
    <p>时长: ${movie.length}</p>
    <p>简介: ${movie.des}</p>
    <a href="${movie.url}" class="btn btn-primary">访问电影链接</a>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
