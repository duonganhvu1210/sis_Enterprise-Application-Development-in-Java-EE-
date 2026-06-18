package dao;

import model.Score;
import model.StudentResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAO {

    public void insert(Score score) {

        String sql =
                "INSERT INTO student_score_t(student_id,subject_id,score1,score2) VALUES(?,?,?,?)";

        try (
                Connection con = DBContext.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, score.getStudentId());
            ps.setInt(2, score.getSubjectId());
            ps.setDouble(3, score.getScore1());
            ps.setDouble(4, score.getScore2());

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public List<StudentResult> getAllResults() {

        List<StudentResult> list = new ArrayList<>();

        String sql =
                """
                SELECT
                    st.student_code,
                    st.full_name,
                    sb.subject_name,
                    ss.score1,
                    ss.score2
                FROM student_score_t ss
                JOIN student_t st
                    ON ss.student_id = st.student_id
                JOIN subject_t sb
                    ON ss.subject_id = sb.subject_id
                """;

        try (
                Connection con = DBContext.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                StudentResult result = new StudentResult();

                double score1 = rs.getDouble("score1");
                double score2 = rs.getDouble("score2");

                double average = score1 * 0.3 + score2 * 0.7;

                String grade;

                if (average >= 8) {
                    grade = "A";
                } else if (average >= 6) {
                    grade = "B";
                } else if (average >= 4) {
                    grade = "D";
                } else {
                    grade = "F";
                }

                result.setStudentCode(rs.getString("student_code"));
                result.setFullName(rs.getString("full_name"));
                result.setSubjectName(rs.getString("subject_name"));
                result.setScore1(score1);
                result.setScore2(score2);
                result.setAverage(average);
                result.setGrade(grade);

                list.add(result);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}