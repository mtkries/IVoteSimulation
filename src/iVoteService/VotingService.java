package iVoteService;

import java.util.Hashtable;

import question.Question;
import student.Student;

public interface VotingService {
	public Question getCurrentQuestion();
	public void setCurrentQuestion(Question q);
	public String getQuestionText();
	public void addStudent(String id);
	public void addStudent(Student s);
	public Hashtable<String,Integer> getStatistics();
}
