package question;

import java.util.Hashtable;
import java.util.Set;

public class MultipleChoiceQuestion implements Question {
	private String questionText;
	private Hashtable<String,String> answers;
	
	
	public MultipleChoiceQuestion(String questionText, Hashtable<String,String> answers){
		this.questionText = questionText;
		this.answers = answers;
	}
	@Override
	public String getQuestionText() {
		return this.questionText;
	}

	public void setAnswers(Hashtable<String,String> h){
		this.answers = h;
	}
	
	@Override
	public void setQuestionText(String text) {
		this.questionText = text;
	}

	@Override
	public Hashtable<String, String> getAnswers() {
		return answers;
	}
	public boolean containsAnswer(String answer){
		boolean returnVal= false;
		Set<String> keys = answers.keySet();
		for(String key: keys){
			if(answers.get(key).equals(answer)){
				returnVal=true;
			}
			
		}
		
		return returnVal;
	}

	
	
}
