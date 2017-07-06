package student;

public class Student implements Person{

	private String id;
	private String answer;
	
	public Student(String id){
		this.id = id;
		this.answer = "";
	}
	
	public String getAnswer(){
		return this.answer;
	}
	public void setAnswer(String answer){
		this.answer = answer;
	}
	
	@Override
	public String getID() {
		return id;
	}
	public void setID(String id){
		this.id = id;
	}
	

	
}
