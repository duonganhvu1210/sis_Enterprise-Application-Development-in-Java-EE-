package controller;

import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import model.Student;

import java.io.IOException;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("add-student.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String code = request.getParameter("studentCode");
        String name = request.getParameter("fullName");
        String address = request.getParameter("address");

        Student s = new Student();

        s.setStudentCode(code);
        s.setFullName(name);
        s.setAddress(address);

        StudentDAO dao = new StudentDAO();

        dao.insert(s);

        response.sendRedirect("home");
    }
}