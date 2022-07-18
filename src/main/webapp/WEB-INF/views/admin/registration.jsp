<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<form action="/admin/registration1" method="post">
    <div class="form-group row">
        <label class="col-sm-4 col-form-label">Email</label>
        <div class="col-sm-8">
            <input type="email" class="form-control" placeholder="Email" name="user_email">
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-4 col-form-label">Password</label>
        <div class="col-sm-8">
            <input type="password" class="form-control" placeholder="Password" name="user_password" >
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-4 col-form-label">Full Name</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" placeholder="Full Name" name="full_name" >
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-4 col-form-label">Role</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" placeholder="Role" name="role" >
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-12">
            <button type="submit" class="btn btn-success float-right">REGISTER</button>
        </div>
    </div>
</form>



</body>
</html>
