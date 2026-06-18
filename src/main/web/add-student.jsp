<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>

<title>Add Student</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

</head>

<body class="container mt-5">

<h2>Add Student</h2>

<form method="post" action="student">

    <div class="mb-3">
        <label>Student Code</label>
        <input type="text"
               name="studentCode"
               class="form-control">
    </div>

    <div class="mb-3">
        <label>Full Name</label>
        <input type="text"
               name="fullName"
               class="form-control">
    </div>

    <div class="mb-3">
        <label>Address</label>
        <input type="text"
               name="address"
               class="form-control">
    </div>

    <button class="btn btn-success">
        Save
    </button>

</form>

</body>
</html>