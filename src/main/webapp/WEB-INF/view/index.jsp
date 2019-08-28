<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CSRF Token</title>
    </head>
    <body>
        <div align="center">
            <h1>CSRF Token Example</h1>
            <div style="margin:10%">
                <form id="saveMe" method="POST">
                    <input id="_csrf" name="_csrf" value="${sessionScope._CSRF}" type="hidden"/>
                    <input id="name" placeholder="Name" required/>
                    <button  type="submit">Save me</button>
                </form>
            </div>
        </div>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(function () {
            $("body").on("submit", "#saveMe", function () {
                $.ajax({
                    method: "POST",
                    url: "save",
                    data: {
                        _csrf: $("#_csrf").val(),
                        _name: $("#name").val()
                    }, success: function (data) {
                        alert(data.msg);
                    }, error: function (errorThrown) {
                        alert(data.errorThrown);
                    }
                });
                return false;
            });
        });
    </script>
</html>
