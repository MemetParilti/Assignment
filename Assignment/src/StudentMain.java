import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) throws IOException {
		Student student=new Student();
		File file=new File("students.txt");
		FileWriter write=new FileWriter(file);
		// User Input
		Scanner s=new Scanner(System.in);
		// Array List of GPA
		ArrayList<Double>StudentGpa=new ArrayList<>();
		// ArrayList of Student Info
		ArrayList<String>studentInfo=new ArrayList<>();
		// Arraylist of Student ID
		ArrayList<String>StudentID=new ArrayList<>();
		System.out.println("How many students do you want to add ? ");
		int student_Numbers=s.nextInt();
		
		for(int i=0;i<student_Numbers;i++) {
			
			System.out.println("Enter Student Name ");
			student.setName(s.next());
			System.out.println("Enter Student Surname ");
			student.setSurname(s.next());
			System.out.println("Enter Student ID ");
			student.setID(s.next());
			System.out.println("Enter Student First Course Grade ");
			student.setCourse1(s.nextDouble());
			System.out.println("Enter Student Second Course Grade ");
			student.setCourse2(s.nextDouble());
			System.out.println("Enter Student Third Course Grade ");
			student.setCourse3(s.nextDouble());
			System.out.println("Enter Student Fourth Course Grade ");
			student.setCourse4(s.nextDouble());
			System.out.println("Enter Student Fifth Course Grade ");
			student.setCourse5(s.nextDouble());
			// Adding idStu ArrayList
			StudentID.add(i,(student.getID()));
			// Adding gpa ArrayList
			StudentGpa.add(i,(student.getCourse1()+student.getCourse2()+student.getCourse3()+student.getCourse4()+student.getCourse5())/5);
			write.write(student.getID()+"\n"+student.getName()+"\n"+student.getSurname()+"\n"+student.getCourse1()+"\n"+student.getCourse2()+"\n"+student.getCourse3()+"\n"+student.getCourse4()+"\n"+student.getCourse5()+"\n");
			
		    }
		write.close();
		
		boolean b=true;
		int choose;
		while(b)
		    {
			// User Interface
			System.out.println("Please Choose One of Them ");
			System.out.println("1 - Show student information ");
			System.out.println("2 - Show All student informations ");
			System.out.println("3 - Update student information ");
			System.out.println("4 - Delete student information ");
			System.out.println("5 - Show GPA");
			System.out.println("6 - Show the Average GPA ");
			System.out.println("7 - Exit");
			System.out.println("8 - Sort");
			System.out.println("9 - Search");
			choose=s.nextInt();
				
		switch(choose) {
		
			case 1: 
				
				student.showStudentInformation(file, s);
				break;
			
			case 2: 
				
				student.writeConsole(file);
				break;
			
			case 3: 
				
				student.UpdateInfo(file,studentInfo,s,StudentGpa,StudentID);
				break;
			
			case 4: 
				
				student.DeleteInfo();
				break;
			
			case 5 : 
			
				student.getGPA(s,StudentGpa,StudentID);
				break;
			
			case 6 : 
			
				student.averageGPA(StudentGpa);
				break;
			
			case 7 :  
				
				System.out.println("Finish");
				b=false;
				break;
			case 8 :
				student.SelectionSort(StudentGpa);
				
			    student.InsertionSort(StudentGpa);
			    
			    break;
			case 9 :
				student.binarySearch(StudentID, s);
				
				student.LinearSearch(file, StudentID, s);
				
				break;
			}				
			}	
			}
			}