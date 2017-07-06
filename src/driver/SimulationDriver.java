package driver;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Random;
import java.util.Set;

import iVoteService.IVoteService;
import iVoteService.VotingService;
import question.MultipleChoiceQuestion;
import question.Question;
import student.Student;

public class SimulationDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VotingService vs = new IVoteService();
		
		//Question text
		String qt = "What is 9+10?";
		Hashtable<String,String> answerTable = new Hashtable<String,String>();
		answerTable.put("A","21");
		answerTable.put("B","19");
		answerTable.put("C","7");
		answerTable.put("D","12");
		answerTable.put("E","25");
		
		Question q = new MultipleChoiceQuestion(qt,answerTable);
		
		displayQuestion(q);
		
		vs.setCurrentQuestion(q);
		
		Student s1 = new Student(randString());
		Student s2 = new Student(randString());
		Student s3 = new Student(randString());
		Student s4 = new Student(randString());
		Student s5 = new Student(randString());
		Student s6 = new Student(randString());
		Student s7 = new Student(randString());
		Student s8 = new Student(randString());
		

		//Set random answers for students
		s1.setAnswer(generateRandom(q));
		s2.setAnswer(generateRandom(q));
		s3.setAnswer(generateRandom(q));
		s4.setAnswer(generateRandom(q));
		s5.setAnswer(generateRandom(q));
		s6.setAnswer(generateRandom(q));
		s7.setAnswer(generateRandom(q));
		s8.setAnswer(generateRandom(q));
		
		//Add students with random IDs
		vs.addStudent(s1);
		vs.addStudent(s2);
		vs.addStudent(s3);
		vs.addStudent(s4);
		vs.addStudent(s5);
		vs.addStudent(s6);
		vs.addStudent(s7);
		vs.addStudent(s8);
		
		s8.setAnswer("A");
		
		displayStatistics(vs);
		
	}
	public static Student studentGenerator(Question q){
		System.out.println(generateRandom(q));
		Student s =new Student(generateRandom(q));
		return s;
	}
	
	public static String generateRandom(Question q){
		Hashtable<String,String> ht = q.getAnswers();
		Set<String> s = ht.keySet();
		int rand =randInt(0,s.size()-1);
		return (String) s.toArray()[rand];
	}
	public static void displayStatistics(VotingService vs){
		System.out.println("\nPrinting Statistics:");
		Hashtable<String,Integer> ht = vs.getStatistics();
		Set<String> mySet = ht.keySet();
		for(String s : mySet){
			System.out.println(s +" -> " +ht.get(s));
		}
		
	}
	
	public static void displayQuestion(Question q){
		System.out.println(q.getQuestionText());
		Hashtable<String,String> ht = q.getAnswers();
		Set<String> mySet = ht.keySet();
		for(String s : mySet){
			System.out.println(s +". " +ht.get(s));
		}
	}
	public static String randString(){
		SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
	}
	public static int randInt(int min, int max) {

	    Random rand = new Random();

	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

}
