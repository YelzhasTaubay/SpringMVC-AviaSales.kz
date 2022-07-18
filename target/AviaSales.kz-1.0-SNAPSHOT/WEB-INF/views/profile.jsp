<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile!</title>
</head>
<body>

    <div>
    Welcome to Profile Page: ${user.fullname}

    </div>

    <form action="/signout" method="post">
        To Log Out: <button>Sign out</button>
    </form>

    <form action="/profile/delete">
        To Delete Myself: <input type="email" name="email" value="${user.email}">
        <button>Delete ${user.fullname}</button>
    </form>





</body>
</html>
