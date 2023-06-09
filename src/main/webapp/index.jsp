<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>True Team Sign-Up</title>

</head>
<body>
<div align="center">
    <h1>로그인</h1>
    <div class="container">
        <form action="signUp" method="post">
            <label>ID : <input type="text" name="userId"></label><br>
            <label>PW : <input type="password" name="userPw"></label><br><br>
            <input type="submit" value="로그인" style="background-color: limegreen; border-color: limegreen; color: white">
        </form>
        <br>
        <form action="signIn" method="post">
        <button type="submit">회원가입</button>
        </form>
    </div>
    </div>
</div>
</body>
</html>