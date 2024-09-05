<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
 <script src="js/popup.js"></script> 

</head>
<body>

<header>
<div id="header_container">
<div style="background: white; width: 100px; height: 100px;">
<img alt="" src="img/logo.png" id="logo">
</div>
<h1 id="title">StuQuiz</h1>
</div>
<div id="bt_box">
<button class="nav_bt" onclick="">FREE EXAM</button>
<button class="nav_bt" onclick="openPopup()">SIGN IN</button>
<button class="nav_bt"  onclick="openPopup2()">SIGN UP</button>
</div>
</header>

<div id="popup" class="popup-container">
    <div class="popup-content">
        <span class="close-btn" onclick="closePopup()">&times;</span>
        <button onclick="closePopup()" id="popup_close">X</button>
        <h2 class="popup_title">SIGN IN</h2>
        <form action="login.go" method="post">
        <input type="text" name="username" required="required" placeholder="Username">
        <input type="password" name="password" required="required" placeholder="Password">
        <input type="submit" id="submit_btn" value="LOG IN" onclick="">
       <a href="javascript:void(0)" onclick="showRegisterPopup2()">
                <p style="color: white; margin-top: -10px;">Register Now</p>
            </a>
        </form>
       
    </div>
</div>

<div id="popup2" class="popup-container">
    <div class="popup-content">
        <span class="close-btn" onclick="closePopup()">&times;</span>
        <button onclick="closePopup()" id="popup_close">X</button>
        <h2 class="popup_title">SIGN UP</h2>
        <form action="signup.go" method="post">
        <input type="text" name="username" required="required" placeholder="Username">
        <input type="email" name="email" required="required" placeholder="Email">
        <input type="password" name="password" required="required" placeholder="Password">
        <input type="password" name="confirm_password" required="required" placeholder="Confirm Password">
        <input type="submit" id="submit_btn" value="REGISTER">
          <a href="javascript:void(0)" onclick="showRegisterPopup()"> <p style="color: white; margin-top: -10px;">Log in</p></a>
        </form>
        
        
       
    </div>
</div>

<div id="popup2" class="popup-container" style="display:none;"> <!-- Inicialmente oculto -->
    <div class="popup-content">
        <span class="close-btn" onclick="closePopup()">&times;</span>
        <button onclick="closePopup()" id="popup_close">X</button>
        <h2 class="popup_title">ERROR DE LOGIN</h2>
        <p style="color: red;">Usuario o contraseña incorrectos. Inténtalo de nuevo.</p>
        <form action="signin.go" method="post"> 
            <input type="text" name="username" required="required" placeholder="Username">
            <input type="email" name="email" required="required" placeholder="Email">
            <input type="password" name="password" required="required" placeholder="Password">
            <input type="password" name="confirm_password" required="required" placeholder="Confirm Password">
            <input type="submit" id="submit_btn" value="REGISTER">
            <a href="javascript:void(0)" onclick="showRegisterPopup()">
                <p style="color: white; margin-top: -10px;">Log in</p>
            </a>
        </form>
    </div>
</div>

</body>
</html>