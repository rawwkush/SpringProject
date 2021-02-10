package QuestionAnswer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Exam {

	@Id
	@GeneratedValue
	private int examId;
	@Column(name="student_Id")
    private int stdId;
	@Column(name="course_Name")
    private String cName;
	@Column(name="total_Marks")
    private int tMarks;
	@Column(name="obtain_Mark")
    private Integer obtMarks;
    private String date;
    private String startTime;
    private String endTime;
    private String examTime;
    private String status;

    public Exam() {
    }

    public Exam(int examId, int stdId,String cName, int tMarks, int obtMarks, String date, String startTime, String endTime, String examTime, String status) {
        this.examId = examId;
        this.stdId = stdId;
        this.cName=cName;
        this.tMarks = tMarks;
        this.obtMarks = obtMarks;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.examTime = examTime;
        this.status = status;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public int gettMarks() {
        return tMarks;
    }

    public void settMarks(int tMarks) {
        this.tMarks = tMarks;
    }

    public int getObtMarks() {
        return obtMarks;
    }

    public void setObtMarks(int obtMarks) {
        this.obtMarks = obtMarks;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
