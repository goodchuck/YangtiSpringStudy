package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component
//@Component("console")이름으로 찾을경우 이렇게 사용
public class InlineExamConsole implements ExamConsole {
	@Autowired //이러면 객체없어도 실행가능 //xml의 set역할을 얘가함 Exam을 기준으로 바인드함
	//@Qualifier //constructor 출력
	private Exam exam;
	
	public InlineExamConsole() {
		System.out.println("constructor");
	}

	public InlineExamConsole(Exam exam) {
		System.out.println("overloaded constructor");
		this.exam = exam;
	}
	
/*	@Autowired
	public InlineExamConsole(@Qualifier("exam2") Exam exam) {
		System.out.println("overloaded constructor");
		this.exam = exam;
	}*/

	@Override
	public void print() {
		if(exam == null)
		System.out.printf("total is %d, avg is %f\n", 0, 0.0f);
		else
		System.out.printf("total is %d, avg is %f\n", exam.total(), exam.avg());
	}
	
	//@Autowired(required = false) //xml의 set역할을 얘가함 Exam을 기준으로 바인드함
	//@Qualifier("exam2") //setter 출력
	@Override
	public void setExam(Exam exam) {
		System.out.println("setter");
		this.exam = exam;
	}
}
