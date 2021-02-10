package DatabaseConnection;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import QuestionAnswer.Answer;
import QuestionAnswer.Courses;
import QuestionAnswer.Exam;
import QuestionAnswer.Question;
import Users.Student;
import Users.Teacher;

public class MyDBConnection {

	public void addNewStudent(Student std) {
		addNewStudent(std.getStdName(), std.getEmail(), std.getPassword(), std.getContact(), std.getCity(), std.getAddress());
	}
	
	public void addNewStudent(String stdName, String email, String pass, String contact, String city, String address) {

		Student std = new Student();
		std.setStdName(stdName);
		std.setEmail(email);
		std.setPassword(pass);
		std.setContact(contact);
		std.setCity(city);
		std.setAddress(address);
		// std.setMarks(marks);

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(std);

		tx.commit();
		session.close();
		factory.close();
	}

	public void addNewTeacher(Teacher t) {
		addNewTeacher(t.gettName(), t.getEmail(), t.getPassword(), t.getContact(), t.getCity(), t.getAddress());
	}
	
	public void addNewTeacher(String tName, String email, String pass, String contact, String city, String address) {

		Teacher t = new Teacher();
		t.settName(tName);
		t.setEmail(email);
		t.setPassword(pass);
		t.setContact(contact);
		t.setCity(city);
		t.setAddress(address);

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Teacher.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(t);

		tx.commit();
		session.close();
		factory.close();
	}

	public List<Student> getAllStudent() {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		List<Student> l = session.createQuery("From Student").list();

		tx.commit();
		session.close();
		factory.close();
		return l;
	}

	public Student getStudentById(int id) {
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Student std = (Student)session.get(Student.class, id);

		tx.commit();
		session.close();
		factory.close();
		
		return std;
	}
	
	public void updateStudentByMarks(int id, int marks) {
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Student std = (Student)session.get(Student.class, id);
		
		std.setMarks(marks);
		session.update(std);

		tx.commit();
		session.close();
		factory.close();
	}
	
	public List<Teacher> getAllTeacher() {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Teacher.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		List<Teacher> l = session.createQuery("From Teacher").list();

		tx.commit();
		session.close();
		factory.close();
		return l;
	}

	public void updateStudent(Student std) {
		
		String name=null;
		String  email=null;
		String pass=null;
		String contact=null;
		String city=null;
		String address = null;
		
		if(std.getStdName() != null)
			name = std.getStdName();
		if(std.getEmail() != null)
			email = std.getEmail();
		if(std.getPassword() != null)
			pass = std.getPassword();
		if(std.getContact() != null)
			contact = std.getContact();
		if(std.getCity() != null)
			city = std.getCity();
		if(std.getAddress() != null)
			address=std.getAddress();
			
		updateStudent(std.getStdId(), name, email, pass, contact, city, address);
	}
	
	public void updateStudent(int stdId, String stdName, String email, String pass, String contact, String city,
			String address) {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Student std = (Student) session.get(Student.class, stdId);

		
//		std.setStdId(stdid);
		if(stdName != null)
			std.setStdName(stdName);
		if(email != null)
			std.setEmail(email);
		if(pass != null)
			std.setPassword(pass);
		if(contact != null)
			std.setContact(contact);
		if(city != null)
			std.setCity(city);
		if(address != null)
			std.setAddress(address);

		session.update(std);

		tx.commit();
		session.close();
		factory.close();

	}

	public void updateTeacher(Teacher t) {
		updateTeacher(t.gettId(), t.gettName(), t.getEmail(), t.getPassword(), t.getContact(), t.getCity(), t.getAddress());
	}

	public void updateTeacher(int tid, String tName, String email, String pass, String contact, String city,
			String address) {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Teacher t = (Teacher) session.get(Teacher.class, tid);

		t.settId(tid);
		t.settName(tName);
		t.setEmail(email);
		t.setPassword(pass);
		t.setContact(contact);
		t.setCity(city);
		t.setAddress(address);

		session.update(t);

		tx.commit();
		session.close();
		factory.close();
	}
	
	public void deleteStudent(int stdid) {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Student std = (Student) session.get(Student.class, stdid);

		session.delete(std);

		tx.commit();
		session.close();
		factory.close();
	}

	public void deleteTeacher(int tid) {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Teacher.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Teacher t = (Teacher) session.get(Teacher.class, tid);

		session.delete(t);

		tx.commit();
		session.close();
		factory.close();
	}

	public boolean LoginValidateForStudent(String email, String password) {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		boolean isValid = false;

		String query = "from Student as s where s.email=:x and s.password=:y";
		Query q = session.createQuery(query);
		q.setParameter("x", email);
		q.setParameter("y", password);

		List<Student> l = q.list();

		if (l.size() > 0)
			isValid = true;

		tx.commit();
		session.close();
		factory.close();

		return isValid;
	}

	public boolean LoginValidateForTeacher(String email, String password) {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		boolean isValid = false;

		String query = "from Teacher as s where s.email=:x and s.password=:y";
		Query q = session.createQuery(query);
		q.setParameter("x", email);
		q.setParameter("y", password);

		List<Student> l = q.list();

		if (l.size() > 0)
			isValid = true;

		tx.commit();
		session.close();
		factory.close();

		return isValid;
	}

	public void addNewCourse(Courses c) {
		addNewCourse(c.getcName(), c.gettMarks(), c.getTime());
	}
	
	public void addNewCourse(String courseName, int tMarks, String time) {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Courses.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Courses course = new Courses();
		course.setcName(courseName);
		course.settMarks(tMarks);
		course.setTime(time);
		
		session.save(course);

		tx.commit();
		session.close();
		factory.close();
	}

	public List<Courses> getAllCourses() {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Courses.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		List<Courses> l = session.createQuery("From Courses").list();

		tx.commit();
		session.close();
		factory.close();
		return l;
	}

	public void delCourse(String cName) {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Teacher.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String query = "from Courses where cName=" + cName + "";
		Query q = session.createQuery(query);
		List<Student> list = q.list();

		for (Student s : list) {
			session.delete(s);
		}

		tx.commit();
		session.close();
		factory.close();
	}

	public void addQuestion(Question q) {
		addQuestion(q.getcName(), q.getQuestion(), q.getOpt1(), q.getOpt2(), q.getOpt3(), q.getOpt4(), q.getAnswer());
	}
	public void addQuestion(String cName, String question, String opt1, String opt2, String opt3, String opt4, String answer) {

		Question ques = new Question();
		//ques.setQuestionId(1);
		ques.setcName(cName);
		ques.setQuestion(question);
		ques.setOpt1(opt1);
		ques.setOpt2(opt2);
		ques.setOpt3(opt3);
		ques.setOpt4(opt4);
		//ques.setCorrect(correct);
		ques.setAnswer(answer);

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Question.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(ques);

		tx.commit();
		session.close();
		factory.close();

	}

	public Question getQuestionById(int id) {
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Question.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
	
		Question ques = (Question)session.get(Question.class, id);
		
		tx.commit();
		session.close();
		factory.close();
		
		return ques;
	}
	
	public void delQuestion(int qId) {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Question.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Question ques = (Question) session.get(Question.class, qId);

		session.delete(ques);

		tx.commit();
		session.close();
		factory.close();
	}

	public List<Question> getAllQuestions() {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Question.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		List<Question> list = session.createQuery("from Question").list();

		tx.commit();
		session.close();
		factory.close();
		return list;
	}

	public List<Question> getAllQuestionsByCourse(String courseName) {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Question.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String query = "from Question as q where q.cName=:x";
		Query q = session.createQuery(query);
		q.setParameter("x", courseName);

		List<Question> list = q.list();

		tx.commit();
		session.close();
		factory.close();
		return list;
	}

	// Need to Check
	public List<Question> getQuestions(String courseName, int questions) {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String query = "from Question as q where q.courseName=:x ORDER BY RAND()";
		Query q = session.createQuery(query);
		q.setParameter("x", courseName);
		q.setMaxResults(questions);
		List<Question> list = q.list();

		tx.commit();
		session.close();
		factory.close();
		return list;
	}

	public void startExam(String cName, int sId) {

		Exam xam = new Exam();

		xam.setcName(cName);

		xam.setDate(getFormatedDate(LocalDate.now().toString()));

		xam.setStartTime(LocalTime.now().toString());
		xam.setStdId(sId);

		xam.setExamTime(getCourseTimeByName(cName));
		xam.settMarks(getTotalMarksByCourseName(cName));

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Exam.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(xam);

		tx.commit();
		session.close();
		factory.close();
	}

	public int getTotalMarksByCourseName(String cName) {
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Courses.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		String query = "from Courses as c where c.cName=:x";
		Query q = session.createQuery(query);
		q.setParameter("x", cName);
		List<Courses> l = q.list();
		int total_marks = 0;
		
		for(Courses c : l)
			total_marks = c.gettMarks();
		
		tx.commit();
		session.close();
		factory.close();
		
		return total_marks;
	}
	
	public String getCourseTimeByName(String cName) {
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Courses.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		String query = "from Courses as c where c.cName=:x";
		Query q = session.createQuery(query);
		q.setParameter("x", cName);
		List<Courses> l = q.list();
		
		String time = "";
		
		for(Courses c : l) {
			time = c.getTime();
		}
			
		
		tx.commit();
		session.close();
		factory.close();
		
		return time;
	}
	
	private String getFormatedDate(String date) {

		LocalDate localDate = LocalDate.parse(date);
		return localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}
	
	public String getStartTimeByExamId(int examId) {
		
		Configuration cfg = new Configuration();

		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		String query = "from Exam as e where e.examId=:x";
		Query q = session.createQuery(query);
		q.setParameter("x", examId);
		List<Exam> l = q.list();
		String start_time = "";
		
		for(Exam c : l)
			start_time = c.getStartTime();
		
		tx.commit();
		session.close();
		factory.close();
		
		return start_time;
	}

	public String getCorrectAnswer(int qid) {
		
		Configuration cfg = new Configuration();

		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		String query = "from Question as q where q.questionId=:x";
		Query q = session.createQuery(query);
		q.setParameter("x", qid);
		List<Question> l = q.list();
		
		String corr_ans = "";
		
		for(Question ques : l)
			corr_ans = ques.getAnswer();
		
		tx.commit();
		session.close();
		factory.close();
		
		return corr_ans;
	}
	
	private String getAnswerStatus(String ans, String correct) {
        String resp="";
        if(ans.equals(correct)){
            resp="correct";
        }else{
            resp="incorrect";
        }
        return resp;
    }
	//"select count(answer_id) from answers "
    //+ "where exam_id=? and status='correct'");
	
	
	/*public int getObtainMarks(int qid, String selected_ans, int marks) {
		
		Configuration cfg = new Configuration();

		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		String query = "from Question as q where q.questionId=:x";
		Query q = session.createQuery(query);
		q.setParameter("x", qid);
		List<Question> l = q.list();
		
		for(Question ques : l) {
			if(ques.getAnswer().equals(selected_ans))
				marks += 1;
		}
		
		tx.commit();
		session.close();
		factory.close();
		return marks;
	}*/
	
	public int calculateMarks(Student s, Question q) {
		
		Configuration cfg = new Configuration();

		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		int marks = 0;
		
		Student std = getStudentById(s.getStdId());
		
		Question ques = getQuestionById(q.getQuestionId());
		
		if(ques.getAnswer().equals(q.getAnswer())) {
			marks = 1 + std.getMarks();
		}
		
		tx.commit();
		session.close();
		factory.close();
		
		return marks;
	}

	public void submit(int sid, int eid) {
		
		// 1) Update the status of the Exam to be completed
		// 2) Update the total marks obtained by the student in the given exam
		
		// 1
		updateExamStatusOnSubmission(eid);
		
		// 2
		updateExamByMarksObtainByStudent(sid, eid);
	}
	
	public void updateExamStatusOnSubmission(int eid) {
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Exam.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Exam xam = (Exam) session.get(Exam.class, eid);

		xam.setStatus("completed");

		session.update(xam);

		tx.commit();
		session.close();
		factory.close();
	}
	
	public int updateExamByMarksObtainByStudent(int sid, int eid) {
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Exam.class);
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Student std = (Student) session.get(Student.class, sid);
		int obt_marks = std.getMarks();
		
		Exam xam = (Exam) session.get(Exam.class, eid);
		xam.setObtMarks(obt_marks);
		
		tx.commit();
		session.close();
		factory.close();
		
		return obt_marks;
	}
	
	private String getFormatedTime(String time){
        if(time!=null){
            LocalTime localTime=LocalTime.parse(time);
        return  localTime.format(DateTimeFormatter.ofPattern("hh:mm a"));
        }else{
            
        return  "-";
        }
    }

}
