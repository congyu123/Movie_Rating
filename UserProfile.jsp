<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人资料</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>个人资料</h2>
    <form action="UserServlet?action=updateProfile" method="post">
        <div class="form-group">
            <label for="username">用户名</label>
            <input type="text" class="form-control" id="username" name="username" value="${currentUser.username}" readonly>
        </div>
        <div class="form-group">
            <label for="gender">性别</label>
            <select class="form-control" id="gender" name="gender">
                <option value="male" ${currentUser.gender == 'male' ? 'selected' : ''}>男</option>
                <option value="female" ${currentUser.gender == 'female' ? 'selected' : ''}>女</option>
            </select>
        </div>
        <div class="form-group">
            <label for="email">邮箱</label>
            <input type="email" class="form-control" id="email" name="email" value="${currentUser.email}" required>
        </div>
        <div class="form-group">
            <label for="telephone">电话</label>
            <input type="text" class="form-control" id="telephone" name="telephone" value="${currentUser.telephone}">
        </div>
        <div class="form-group">
            <label for="introduce">自我介绍</label>
            <textarea class="form-control" id="introduce" name="introduce">${currentUser.introduce}</textarea>
        </div>
        <button type="submit" class="btn btn-primary">保存</button>
    </form>
</div>
</body>
</html>
