<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>电影主页</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">电影网站</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="#">首页 <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="MoviePage.jsp">电影列表</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-5">
    <h2>热门电影</h2>
    <div class="row">
        <c:forEach var="movie" items="${popularMovies}">
            <div class="col-md-3">
                <div class="card mb-3">
                    <img src="${movie.image}" class="card-img-top movie-poster" alt="${movie.name}">
                    <div class="card-body">
                        <h5 class="movie-title">${movie.name}</h5>
                        <p class="movie-info">评分: ${movie.score}</p>
                        <p class="movie-info">年份: ${movie.years}</p>
                        <p class="movie-info">国家: ${movie.country}</p>
                        <a href="MovieServlet?action=detail&id=${movie.id}" class="btn btn-primary">详情</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <h2>新增电影</h2>
    <div class="row">
        <c:forEach var="movie" items="${newMovies}">
            <div class="col-md-3">
                <div class="card mb-3">
                    <img src="${movie.image}" class="card-img-top movie-poster" alt="${movie.name}">
                    <div class="card-body">
                        <h5 class="movie-title">${movie.name}</h5>
                        <p class="movie-info">评分: ${movie.score}</p>
                        <p class="movie-info">年份: ${movie.years}</p>
                        <p class="movie-info">国家: ${movie.country}</p>
                        <a href="MovieServlet?action=detail&id=${movie.id}" class="btn btn-primary">详情</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<footer class="footer mt-auto py-3 bg-light">
    <div class="container">
        <span class="text-muted">版权所有 &copy; 2024 电影网站</span>
    </div>
</footer>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
