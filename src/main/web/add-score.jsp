<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>

    <title>Add Score</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

</head>

<body class="container mt-5">

<h2>Add Score</h2>

<form method="post" action="score">

    <div class="mb-3">
        <label>Student</label>

        <select name="studentId" class="form-select">

            <c:forEach items="${students}" var="s">

                <option value="${s.studentId}">
                    ${s.studentCode} - ${s.fullName}
                </option>

            </c:forEach>

        </select>

    </div>

    <div class="mb-3">

        <label>Subject</label>

        <select name="subjectId" class="form-select">

            <c:forEach items="${subjects}" var="sub">

                <option value="${sub.subjectId}">
                    ${sub.subjectName}
                </option>

            </c:forEach>

        </select>

    </div>

    <div class="mb-3">

        <label>Score 1</label>

        <input type="number"
               step="0.01"
               name="score1"
               class="form-control">

    </div>

    <div class="mb-3">

        <label>Score 2</label>

        <input type="number"
               step="0.01"
               name="score2"
               class="form-control">

    </div>

    <button type="submit" class="btn btn-primary">
        Save Score
    </button>

    <a href="home" class="btn btn-secondary">
        Back
    </a>

</form>

</body>
</html>