package com.example;

public class StudentInfo {
	private Student student;

	public StudentInfo(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}	
	
	public void printInfo(){
		if(this.student != null){
			System.out.println("Name : " + this.student.getName());
			System.out.println("Age : " + this.student.getAge());
			System.out.println("Grade : " + this.student.getGrade());
			System.out.println("Class : " + this.student.getClassNum());
			System.out.println("-------------------------");
		}
	}
}
