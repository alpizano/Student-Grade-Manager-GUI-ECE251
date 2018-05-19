import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;

/**
 * <h1>Course Section</h1>
 * The program represents a course section. 
 * 
 * @authors Javier Campos & Alberto Pizano
 * @version 1.0
 * @since 2018-04-18
 */

	// need implements Iterable for iterator
public class CourseSection implements Iterable<Student> {
	private static String assignsLabel;
	private static String highestMarks;
	private ArrayList<Student> students;

   /**
   * Initializes the ArrayList<Student>.
   */ 
	
	public CourseSection()
	  {
		assignsLabel = "ID       A1          A2      A3      A4      Midterm  Final";
		highestMarks = "                   35      35      35      30       30     100";
	    students = new ArrayList<Student>();
	  }
	  
  public CourseSection(String n)
  {
	//header1 = n;
    students = new ArrayList<Student>();
  }
  
  public static String getassignsLabel() {
	  return assignsLabel;
  }
  
  public static String gethighestMarks() {
	  return highestMarks;
  }
  
  // method needed for Implements iterable
  public Iterator<Student> iterator() {
      return this.students.iterator();
  } 
 
  
  // for iterating thru students, to be used with for(Student s : course.getStudents())
  public ArrayList<Student> getStudents() {
	    return this.students;
	}
  
  /**
   * Will add a new student to the ArrayList.
   * @param s A Student object.
   */
  public void addStudent(Student s){
    students.add(s);
  }
  

  public void removeStudent(Student s){ 
    Iterator studentIterator = students.iterator();
    
    while(studentIterator.hasNext()){
      if(studentIterator.next() == s)
        studentIterator.remove();
    }
  }
  
 
  public void listStudents(){
    
    for(Student s: students){
      System.out.println(s.getID());  
    	
    }  
  }
  
  public String pullA1(int index){
	  
	  int i;
	  String a1 = "";  
	  Student s = new Student();
	  
	    for(i=0; i<students.size(); i++){
	    	if(index == i)
	    	{
	    		s = students.get(i);
	     a1 =  s.geta1();
	    	}
	    }  
	    return a1;
	  }
  
  public String pullA2(int index){
	  
	  int i;
	  String a2 = "";  
	  Student s = new Student();
	  
	    for(i=0; i<students.size(); i++){
	    	if(index == i)
	    	{
	    		s = students.get(i);
	     a2 =  String.valueOf(s.getA2());
	    	}
	    }  
	    return a2;
	  }
  public String pullA3(int index){
	  
	  int i;
	  String a3 = "";  
	  Student s = new Student();
	  
	    for(i=0; i<students.size(); i++){
	    	if(index == i)
	    	{
	    		s = students.get(i);
	     a3 =  String.valueOf(s.getA3());
	    	}
	    }  
	    return a3;
	  }
  public String pullA4(int index){
	  
	  int i;
	  String a4 = "";  
	  Student s = new Student();
	  
	    for(i=0; i<students.size(); i++){
	    	if(index == i)
	    	{
	    		s = students.get(i);
	     a4 =  String.valueOf(s.getA4());
	    	}
	    }  
	    return a4;
	  }

 public String pullMidterm(int index){
	  
	  int i;
	  String midterm = "";  
	  Student s = new Student();
	  
	    for(i=0; i<students.size(); i++){
	    	if(index == i)
	    	{
	    		s = students.get(i);
	     midterm =  String.valueOf(s.getMidterm());
	    	}
	    }  
	    return midterm;
	  }
 public String pullFinalExam(int index){
	  
	  int i;
	  String finalExam = "";  
	  Student s = new Student();
	  
	    for(i=0; i<students.size(); i++){
	    	if(index == i)
	    	{
	    		s = students.get(i);
	     finalExam =  String.valueOf(s.getFinalExam());
	    	}
	    }  
	    return finalExam;
	  }
 public String pullFinalGrade(int index){
	  
	  int i;
	  String finalGrade = "";  
	  Student s = new Student();
	  
	    for(i=0; i<students.size(); i++){
	    	if(index == i)
	    	{
	    		s = students.get(i);
	     finalGrade =  String.valueOf(s.getFinalGrade());
	    	}
	    }  
	    return finalGrade;
	  }
 // to copy the original array list and just take the int ID value and place it inside an Integer array
public Integer[] idList(ArrayList<Student> students) {
	Integer[] ids = new Integer[students.size()];
	
	 for(int i=0; i<students.size(); i++) {
	    	Student s = students.get(i);
			ids[i] = s.getID();
	    }	  
	  return ids;
}
  
  
  public int getSize() {
	  int size = 0 ;
	  int i;
	  
	  for(i = 0; i <students.size(); i++) {
		  size++;
	  }
	  
	  return size;
  }
  
  
  public void saveTo(PrintWriter aFile) {
	    aFile.println(assignsLabel);
	    aFile.println(highestMarks);
	    for (Student s:  students) {
	        s.saveTo(aFile);
	    }
	}
  
  /**
   * Reads aFile except for the header and continuously creates new student objects 
   * for a new CourseSection.
   * @param aFile File to read from.
   * @return CourseSection New CourseSection read from aFile
   */
  public static CourseSection loadFrom(BufferedReader aFile) throws IOException{
	  //String line = aFile.readLine();
    CourseSection course = new CourseSection(aFile.readLine()); 
    aFile.readLine(); // skips line
    while (aFile.ready()) //read until no more available (i.e., not ready)
    { 
    	
    	course.addStudent(Student.loadFromST(aFile)); //read & add the student
    	}
    
    return course;
  }
  
  public static CourseSection loadFromOnlyID(BufferedReader aFile) throws IOException{
	  //String line = aFile.readLine();
    CourseSection course = new CourseSection(aFile.readLine()); 
    aFile.readLine(); // skips line
    while (aFile.ready()) //read until no more available (i.e., not ready)
    { 
    	
    	course.addStudent(Student.loadFromSTOnlyID(aFile)); //read & add the student
    	}
    
    return course;
  }
}

