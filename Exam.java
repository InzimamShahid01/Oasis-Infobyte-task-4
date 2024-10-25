package online_Examination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Exam {
	
	String uname;
	String pass;
	boolean isLoggedIn;
	String quesTxt;
	List<String> options;
	ArrayList<Exam> ques;
	int ans;
	int score=0;
	String rightAns="";
	
	public Exam() {
		
	}
	
	public Exam(String ques,List<String> opt,int ans) {
		quesTxt = ques;
		options = opt;
		this.ans = ans;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Exam ex = new Exam();
		
		while(true) {
			System.out.println("1.Register");
			System.out.println("Press any key to exit");
			int ch = sc.nextInt();
			
			switch(ch) {
			
			case 1: ex.Register(sc);
			break;
			
			default:
				System.exit(0);
				break;
			}
			
			while(true) {
				System.out.println("1.Login");
				System.out.println("Press any key to exit");
				int choice = sc.nextInt();
				
				switch(choice) {
				case 1: ex.login(sc);
				break;
				
				default:
					System.exit(0);
					break;
				}
				
				if(ex.isLoggedIn) {
					while(true) {
					System.out.println("1.Update Profile");
					System.out.println("2.Start Exam");
					System.out.println("3.Exit");
					int x = sc.nextInt();
					
					switch(x) {
					case 1: ex.updateProfile(sc);
					break;
					case 2 : ex.startExam(sc);
					break;
					
					case 3:
						System.exit(0);
						break;
					}
				}
					
				}
				else {
					System.out.println("Invalid login info!!");
				}
				
				
			}
			
		}	
	}
	
	private void startExam(Scanner sc) {
		
		generateQuestions();
		
	
		for(int i = 0 ; i < ques.size();i++) {
			Exam q = ques.get(i);
			
			System.out.println("Question ("+ (i+1) + ") " + q.quesTxt);
			for(int j = 0 ; j < q.options.size();j++) {
				System.out.println(q.options.get(j));
			}
			System.out.print("\nSelect Your Answer From Option  1-4: ");
			 int ch = sc.nextInt();
			 
			 if(ch == q.ans) {
				 score = score + 10;
			 }
			 rightAns += i+1 +". " + q.ans+"\n";
		}
			System.out.println("Correct Options\n"+rightAns);
			System.out.println("Total Marks Obtained: "+ score + " out of 50");
		
		System.out.print("Exam Completed!");
		isLoggedIn = false;
		
		System.exit(0);
		
	}
	
	private void generateQuestions() {
		
		List<String> opt1 = new ArrayList<>();
		opt1.add("1.interface");
		opt1.add("2.string");
		opt1.add("3.unsigned");
		opt1.add("4.boolean");
		
		List<String> opt2 = new ArrayList<>();
		opt2.add("1.length()");
		opt2.add("2.size()");
		opt2.add("3.getLength()");
		opt2.add("4.count()");
		
		List<String> opt3 = new ArrayList<>();
		opt3.add("1.private");
		opt3.add("2.protected");
		opt3.add("3.public");
		opt3.add("4.internal");
		
		
		List<String> opt4 = new ArrayList<>();
		opt4.add("1.Main");
		opt4.add("2.Object");
		opt4.add("3.System");
		opt4.add("4. Exception");
		
		List<String> opt5 = new ArrayList<>();
		opt5.add("1.6");
		opt5.add("2.7");
		opt5.add("3.8");
		opt5.add("4.9");
		
		Exam q1 = new Exam("Which of these is a valid keyword in Java?",opt1,1);
		Exam q2 = new Exam("Which method is used to find the length of a string in Java?",opt2,1);
		Exam q3 = new Exam("Which of the following is not a Java access modifier?",opt3,4);
		Exam q4 = new Exam("Which class is the superclass of all classes in Java?",opt4,2);
		Exam q5 = new Exam("How many primitive data types are there in Java?",opt5,3);
		
		ques = new ArrayList<>();
		ques.add(q1);
		ques.add(q2);
		ques.add(q3);
		ques.add(q4);
		ques.add(q5);
		
	}
	
	
	
	
	
	
	private void showProfile(String name,String password) {
		System.out.println("\n************************");
		System.out.println("Name: " + name);
		System.out.println("ID: " + password);
		System.out.println("************************");
		
	}
	
	
	
	
	private void updateProfile(Scanner sc) {
		System.out.println("Enter Your New Username");
		String newName = sc.next();
		
		System.out.println("Enter Your New 4 digit ID");
		String newPass = sc.next();
		
		uname = newName;
		pass = newPass;
		
		showProfile(uname,pass);
	}
	
	
	
	
	private void login(Scanner sc) {
		
		
		System.out.println("Enter Your Username");
		String name = sc.next();
		
		System.out.println("Enter Your 4 digit ID");
		String upass = sc.next();
		
		if(name.equals(uname) && upass.equals(pass)) {
			isLoggedIn = true;
			System.out.println("\n     Login Successfull!     \n");
			showProfile(uname,pass);
		}
		else {
			isLoggedIn = false;
		}
		
		
		
	}
	
	

	private void Register(Scanner sc) {
		
		System.out.println("Enter Your Username");
		uname = sc.next();
		
		if(!uname.matches("^[a-zA-Z]*$")) {
			System.out.println("\nUsername must contain only alphabets");
			System.out.println("\nRegistration failed!");
			System.exit(0);
		}
		
		
		System.out.println("Enter Your 4 digit ID");
		pass = sc.next();
		
		if(pass.length()!= 4 ) {
			System.out.println("\nID must be of 4 digit");
			System.out.println("\nRegistration failed!");
			System.exit(0);
		}
		
		System.out.println("\n     Registered Successfull!     \n");
	}	
}
