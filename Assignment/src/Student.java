import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Student {
	
	private String name;
	private String surname;
	private String id;
	private double course1;
	private double course2;
	private double course3;
	private double course4;
	private double course5;
	
	public Student(){
		
	}
	
	public void setName(String name) {
		this.name=name;	
	}
	
	public String getName() {
		return name;
	}
	
	public void setSurname(String surname) {
		this.surname=surname;
	}
	public String getSurname() {
		return surname;	
	}
	public void setID(String id) {
		this.id=id;
	}
	public String getID() {
		return id;
	}
	public void setCourse1(double course1) {
		this.course1=course1;
	}
	
	public double getCourse1() {
		return course1;
	}

	public double getCourse2() {
		return course2;
	}

	public void setCourse2(double course2) {
		this.course2 = course2;
	}

	public double getCourse3() {
		return course3;
	}

	public void setCourse3(double course3) {
		this.course3 = course3;
	}

	public double getCourse4() {
		return course4;
	}

	public void setCourse4(double course4) {
		this.course4 = course4;
	}

	public double getCourse5() {
		return course5;
	}

	public void setCourse5(double course5) {
		this.course5 = course5;
	}
	
	
	// Show student information when user enter the ID
	public void showStudentInformation(File file , Scanner keyboard) throws FileNotFoundException {
		Scanner read=new Scanner(file);
		System.out.println("Enter Student ID Which You Want To Find ? ");
		String findID=keyboard.next();
		while(read.hasNext()) {
			
			if(findID.equals(read.nextLine())){
				System.out.println(findID);
				for(int i=0;i<7;i++) {
				String str=read.nextLine();
				System.out.println(str);
				}
				
			}
			
		}
		read.close();
		
	}
	// Shows all the information
	public void writeConsole(File file) throws FileNotFoundException {
		
		Scanner read=new Scanner(file);
	
		while(read.hasNext()) {
			String str=read.nextLine();
			System.out.println(str);
			
		}
		read.close();
		
	}
	
	// Updating student
	public void UpdateInfo(File file,ArrayList studentInfo,Scanner s,ArrayList StudentGpa,ArrayList StudentID) throws IOException {
		Scanner read=new Scanner(file);
		String str;
		while(read.hasNext()) {
			str=read.next();
			studentInfo.add(str);
		}
		System.out.println("Enter Student ID Which You Want To Update ?");
		String id=s.next();
		for(int i=0;i<studentInfo.size();i++) {
			
			if(id.equals(studentInfo.get(i))) {
				System.out.println("Enter Student Name  ");
				String newName=s.next();
				System.out.println("Enter Student Surname  ");
				String newSurname=s.next();
				System.out.println("Enter Student ID  ");
				String newId=s.next();
				System.out.println("Enter Course 1 Grade ");
				double newCourse1=s.nextDouble();
				System.out.println("Enter Course 2 Grade ");
				double newCourse2=s.nextDouble();
				System.out.println("Enter Course 3 Grade ");
				double newCourse3=s.nextDouble();
				System.out.println("Enter Course 4 Grade ");
				double newCourse4=s.nextDouble();
				System.out.println("Enter Course 5 Grade ");
				double newCourse5=s.nextDouble();
				System.out.println("Are You Sure ? ( y/n )");
				
				String YesNo=s.next();
				
				if(YesNo.equals("y")) {
			
				studentInfo.set(i,newId);
				studentInfo.set(i+1, newName);
				studentInfo.set(i+2, newSurname);
				
				
			 	studentInfo.set(i+3, newCourse1);
				studentInfo.set(i+4, newCourse2);
				studentInfo.set(i+5, newCourse3);
				studentInfo.set(i+6, newCourse4);
				studentInfo.set(i+7, newCourse5);
				
				
				FileWriter writer=new FileWriter(file);
				for(int j=0;j<studentInfo.size();j++) {
					writer.write(studentInfo.get(j)+"\n");
					
					
				}
				writer.close();
				}
				
				else if(YesNo.equals("n")) {
					break;
			}
			}
		    }
		
		read.close();
			
		}
		
	
	public void DeleteInfo() {
	// it does not work
		
	    }
	
	// Shows Student GPA when user enters ID
	public void getGPA(Scanner keyboard,ArrayList StudentGpa,ArrayList StudentID) throws FileNotFoundException {
		
		System.out.println("Enter Student ID Which You Want To Find ? ");
		String findID=keyboard.next();
		for(int i=0;i<StudentID.size();i++) {
			if(findID.equals(StudentID.get(i))) {
				
				System.out.println(StudentGpa.get(i));		
	    }	
		}	
		}
		
	// Shows average GPA of all students 
	public void averageGPA(ArrayList StudentGpa) {
		double average=0;
		for(int i=0;i<StudentGpa.size();i++) {
			
			
			average=average+(double)StudentGpa.get(i);
				
		}
		System.out.println(average/StudentGpa.size());
		
		
	    }	
	
	public void SelectionSort(ArrayList<Double> StudentGpa) {

        timer.start();
        double temp;
        for (int i = 0; i < StudentGpa.size(); i++){
          for(int j = i + 1; j < StudentGpa.size(); j++){
            if (StudentGpa.get(i) > StudentGpa.get(j)){
             temp =  StudentGpa.get(i);
             StudentGpa.set(i,StudentGpa.get(j));
             StudentGpa.set(j, temp);
            }
          }


        System.out.println("\nSorted List:");
        for(double p: StudentGpa) {
            System.out.print(p + " ");
            System.out.println();

        }
    }
        timer.stop();
        System.out.println("Selection sort = " +timer.getElapsedMilliseconds()+"ms");
}
	
	public void InsertionSort(ArrayList<Double>StudentGpa) {
        timer.start();
        double totalPass = StudentGpa.size();
        double listLength = totalPass;

        for(int i = 0; i <= totalPass - 1; i++) {
            int pointerSmallPosition=i;
            for (int j = i; j < listLength-1; j++) {

                if (StudentGpa.get(pointerSmallPosition) > StudentGpa.get(j + 1)) {
                    pointerSmallPosition=j + 1;
                }
            }

            double temp1= StudentGpa.get(i);
            double temp2= StudentGpa.get(pointerSmallPosition);
            StudentGpa.set(i,temp2);
            StudentGpa.set(pointerSmallPosition,temp1); 
        }
        timer.stop();
        System.out.println("Insertion Sort = "+timer.getElapsedMilliseconds()+"ms");

    }
	public void binarySearch(ArrayList<String>StudentID,Scanner s) {
		timer.start();

        System.out.println("Binary Search");

        Collections.sort(StudentID);
        System.out.println("Enter ID");
        String Id=s.next();
        int index = Collections.binarySearch(StudentID,Id);

        System.out.println("Element found at : " + index);

        timer.stop();
        System.out.println("Binary Search Time = "+timer.getElapsedMilliseconds()+"ms");
        }
	public void LinearSearch(File file,ArrayList<String>StudentID,Scanner s) throws FileNotFoundException {
        timer.start();
        Scanner read=new Scanner(file);

        System.out.println("Enter Student ID Which You Want To Find ? ");
        String findID=s.next();
        if(StudentID.contains(findID)) {


            System.out.println(StudentID.indexOf(findID));

        }

        read.close();
        timer.stop();
        System.out.println("Linear Search = "+timer.getElapsedMilliseconds()+"ms");
    }
}