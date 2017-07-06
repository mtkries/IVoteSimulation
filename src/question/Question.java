package question;

import java.util.Hashtable;

public interface Question {
	
	public void setQuestionText(String text);
	public String getQuestionText();
	public Hashtable<String,String> getAnswers();
	public void setAnswers(Hashtable<String,String> answers);
	public boolean containsAnswer(String s);
	
	
	
}
