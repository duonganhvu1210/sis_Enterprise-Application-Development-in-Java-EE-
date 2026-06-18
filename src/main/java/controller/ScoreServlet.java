package controller;

import dao.ScoreDAO;
import dao.StudentDAO;
import dao.SubjectDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import model.Score;

import java.io.IOException;

@WebServlet("/score")
public class ScoreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        StudentDAO studentDAO = new StudentDAO();
        SubjectDAO subjectDAO = new SubjectDAO();

        request.setAttribute(
                "students",
                studentDAO.getAll()
        );

        request.setAttribute(
                "subjects",
                subjectDAO.getAll()
        );

        request.getRequestDispatcher("add-score.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        Score score = new Score();

        score.setStudentId(
                Integer.parseInt(
                        request.getParameter("studentId")
                )
        );

        score.setSubjectId(
                Integer.parseInt(
                        request.getParameter("subjectId")
                )
        );

        score.setScore1(
                Double.parseDouble(
                        request.getParameter("score1")
                )
        );

        score.setScore2(
                Double.parseDouble(
                        request.getParameter("score2")
                )
        );

        ScoreDAO dao = new ScoreDAO();

        dao.insert(score);

        response.sendRedirect("home");
    }
}