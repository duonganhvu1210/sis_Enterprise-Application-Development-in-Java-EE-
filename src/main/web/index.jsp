<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"
uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>

<title>SIS</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

</head>

<body class="container mt-5">

<h2>Student Information System</h2>

<a href="student" class="btn btn-success">
    + Student
</a>

<a href="score" class="btn btn-primary">
    + Score
</a>

<hr>

<table class="table table-bordered">

    <tr>

        <th>Student Code</th>
        <th>Full Name</th>
        <th>Subject</th>
        <th>Score1</th>
        <th>Score2</th>
        <th>Average</th>
        <th>Grade</th>

    </tr>

    <c:forEach items="${list}" var="s">

        <tr>

            <td>${s.studentCode}</td>
            <td>${s.fullName}</td>
            <td>${s.subjectName}</td>
            <td>${s.score1}</td>
            <td>${s.score2}</td>
            <td>${s.average}</td>
            <td>${s.grade}</td>

        </tr>

    </c:forEach>

</table>

</body>
</html>