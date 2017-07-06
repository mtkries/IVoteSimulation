package iVoteService;

import java.util.Hashtable;
import java.util.LinkedList;
import question.Question;
import student.Student;

public class IVoteService implements VotingService {
	private Question currentQuestion;
	private LinkedList<Student> students = new LinkedList<Student>(); 

	@Override
	public Question getCurrentQuestion() {
		return currentQuestion;
	}

	public void addStudent(String id){
		students.add(new Student(id));
	}
	
	@Override
	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	@Override
	public String getQuestionText() {
		return currentQuestion.getQuestionText();
	}
	
	public Hashtable<String,Integer> getStatistics(){
		Hashtable<String,Integer> returnVal = new Hashtable<String,Integer>();		
		for(String answer: currentQuestion.getAnswers().keySet()){
			returnVal.put(answer,0);
		}
		
		for(Student s: students){
			if(!s.getAnswer().equals("")){
				returnVal.put(s.getAnswer(), returnVal.get(s.getAnswer())+1);
			}
		}
		return returnVal;
	}

	@Override
	public void addStudent(Student s) {
//		System.out.println(s.getAnswer());
		students.add(s);		
	}
	
	


	

}
