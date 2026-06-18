package model;

public class Score {

    private int studentScoreId;
    private int studentId;
    private int subjectId;
    private double score1;
    private double score2;

    public Score() {
    }

    public Score(int studentScoreId,
                 int studentId,
                 int subjectId,
                 double score1,
                 double score2) {
        this.studentScoreId = studentScoreId;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.score1 = score1;
        this.score2 = score2;
    }

    // --- LOGIC TÍNH ĐIỂM VÀ ĐỔI GRADE ---
    public double getAverage() {
        return score1 * 0.3 + score2 * 0.7;
    }

    public String getGrade() {
        double avg = getAverage();
        if (avg >= 8) {
            return "A";
        }
        if (avg >= 6) {
            return "B";
        }
        if (avg >= 4) {
            return "D";
        }
        return "F";
    }

    // --- FULL GETTER AND SETTER (BẮT BUỘC PHẢI CÓ) ---
    public int getStudentScoreId() {
        return studentScoreId;
    }

    public void setStudentScoreId(int studentScoreId) {
        this.studentScoreId = studentScoreId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public double getScore1() {
        return score1;
    }

    public void setScore1(double score1) {
        this.score1 = score1;
    }

    public double getScore2() {
        return score2;
    }

    public void setScore2(double score2) {
        this.score2 = score2;
    }
}