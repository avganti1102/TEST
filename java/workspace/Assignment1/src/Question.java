import java.time.LocalDate;
public class Question {
	int ID;
	String content;
	categoryQuestion category;
	typeQuestion type;
	Account creator;
	LocalDate createDate;
	Exam[] exams;
}
