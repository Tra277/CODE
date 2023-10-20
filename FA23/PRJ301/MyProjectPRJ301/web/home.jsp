<%-- 
    Document   : home
    Created on : Oct 19, 2023, 11:30:56 AM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Game4U VN</title>
        <link rel="stylesheet" href="assets/css/bootstrap-grid.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
    </head>

    <body>
        <div class="header">
            <div class="logo">
                <a href="home">
                    <img src="assets/img/logo.png" alt="logo">
                </a>

            </div>
            <nav class="nav-bar">
                <ul>
                    <li><a href="#">Manager account</a></li>
                    <li><a href="#">Xin chào Son Tra Do</a></li>
                    <li><a href="#">Đăng nhập</a></li>
                    <li><a href="#">Đăng ký </a></li>
                </ul>
            </nav>
            <div class="cart">
                <a href="">
                    <i class="fa-solid fa-cart-plus fa-lg" style="color: #ffffff;"></i>
                    <p>Cart</p>
                </a>

            </div>
        </div>
        <div class="intro mt-32">
            <div class="grid">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-9">
                            <div class="latest-game">
                                <c:forEach items="${sessionScope.latestGame}" var="latest">
                                    <a href="">
                                        <img src="${latest.image}" alt="spiderman">
                                        <div class="game-name">
                                            <p>Khả dụng</p>
                                            <h2>${latest.name}</h2>
                                            <h4>Chỉ từ $${latest.price}</h4>
                                        </div>

                                    </a>
                                </c:forEach>
                            </div>

                        </div>
                        <div class="col-xs-12 col-sm-12 col-md-3">
                            <div class="latest-game-list">
                                <ul>
                                    <!-- lặp lại cái li -->
                                    <c:forEach items="${requestScope.listLatest}" var="l">
                                        <li>
                                            <a href="home?service=selectLatest&id=${l.gameID}">
                                                <div class="latest-item">
                                                    <img src="${l.image}" alt="">
                                                    <div>${l.name}</div>
                                                </div>
                                            </a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="main-content mt-32">
                <div class="grid">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-3">
                                <div class="Genres">
                                    <h1>Thể loại</h1>
                                    <hr />
                                    <ul class="mt-8">
                                        <c:forEach items="${requestScope.listGenre}" var="g">
                                            <li><a href="home?service=selectGenre&id=${g.genreID}">${g.name}</a></li>
                                            </c:forEach>
                                    </ul>
                                    <br/>
                                    <hr/>
                                </div>
                                <div class="search-bar mt-32">
                                    <div class="search-bar-heading">
                                        <h1>Bộ lọc game</h1>
                                        <hr/>
                                        <br/>
                                    </div>
                                    <div class="search-bar-form mt-8">
                                        <form action="">
                                            <label for="search">Tìm kiếm:</label><br>
                                            <input placeholder="Tìm kiếm..." type="text" id="search" name="search"><br>
                                            <label for="from-date">Thời gian từ:</label><br>
                                            <input type="date" id="from-date" name="from-date"><br>
                                            <label for="to-date">đến:</label><br>
                                            <input type="date" id="to-date" name="to-date"><br>
                                            <label for="from-price">Giá từ:</label><br>
                                            <input placeholder="Giá từ..." type="number" id="from-price"
                                                   name="from-price"><br>
                                            <label for="to-price">đến:</label><br>
                                            <input placeholder="Đến..." type="number" id="to-price" name="to-price"><br>
                                            <br>
                                            <input type="submit" value="Tìm kiếm" name="submit">
                                        </form>
                                    </div>

                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-12 col-md-9">
                                <div class="list-game-title">
                                    <h1>${sessionScope.listGameTitle}</h1>
                                </div>
                                <div class="display-game">
                                    <div class="row">
                                        <c:forEach items="${sessionScope.listGame}" var="i">
                                            <!-- lặp lại cái này  -->
                                            <div class="col-md-4">
                                                <div class="display-game-item mt-16">
                                                    <div class="game-item-img">
                                                        <img src="${i.image}" alt="">
                                                    </div>
                                                    <div class="game-item-content">
                                                        <h2>${i.name}</h2>
                                                        <p class="description">${i.description}</p>
                                                        <h3>$${i.price}</h3>
                                                        <div class="add-to-cart">

                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                            <!--  -->
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <br/>
            <footer class="mt-32">
                <div class="contact">
                    <h3>Theo dõi Game4U để không bỏ lỡ game hay nhé</h3>
                    <div class="social-app">
                        <div><a href="">Facebook <i class="fa-brands fa-facebook-f fa-sm"></i></a></div>
                        <div><a href="">Youtube <i class="fa-brands fa-youtube fa-sm"></i></a></div>
                        <div><a href="">Send email <i class="fa-solid fa-envelope fa-sm"></i></a></div>
                        <div><a href="">Github <i class="fa-brands fa-github fa-sm"></i></a></div>

                    </div>
                </div>
                <div class="copyright">Bản quyền thuộc về <a href="https://www.facebook.com/profile.php?id=100025055868952">@Sơn Trà Đỗ</a></div>
            </footer>
            <!-- add font -->
            <script src="https://kit.fontawesome.com/8922b65fb8.js" crossorigin="anonymous"></script>
    </body>

</html>
