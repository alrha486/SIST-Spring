package com.example.test;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.dao.StudentDao;
import com.example.vo.Student;

public class MainClass {
	private Scanner scan;
	
	public MainClass() {
		this.scan = new Scanner(System.in);
	}
	
	void insert(StudentDao studentDao) {
		System.out.print("학번 : ");     String hakbun = scan.next();
		System.out.print("이름 : ");     String name = scan.next();
		System.out.print("국어 : ");     int kor = scan.nextInt();
		System.out.print("영어 : ");     int eng = scan.nextInt();     
		System.out.print("수학 : ");     int mat = scan.nextInt();
		System.out.print("전산 : ");     int edp = scan.nextInt();
		Student s = new Student();    s.setHakbun(hakbun);  s.setName(name);
		s.setKor(kor);    s.setEng(eng);    s.setMat(mat);    s.setEdp(edp);
		calc(s);
		int row = studentDao.create(s);
		System.out.println(row == 1 ? "Insert Success" : "Insert Failure");
	}
	void update(StudentDao studentDao){
		System.out.print("수정할 학생의 학번 : ");
		String hakbun = scan.next();
		System.out.print("수정할 국어 : ");     int kor = scan.nextInt();
		System.out.print("수정할 영어 : ");     int eng = scan.nextInt();     
		System.out.print("수정할 수학 : ");     int mat = scan.nextInt();
		System.out.print("수정할 전산 : ");     int edp = scan.nextInt();
		Student s = new Student();
		s.setHakbun(hakbun);     s.setKor(kor);   s.setEng(eng);
		s.setMat(mat);    s.setEdp(edp);     
		this.calc(s);
		int row = studentDao.update(s);
		System.out.println(row == 1 ? "Update Success" : "Update Failure");
	}
	void delete(StudentDao studentDao){
		System.out.print("삭제할 학생의 학번 : ");   String hakbun = this.scan.next();
		int row = studentDao.delete(hakbun);
		System.out.println(row == 1 ? "Delete Success" : "Delete Failure");
	}
	
	void selectAll(StudentDao studentDao) {
		for(Student student : studentDao.readAll()) {
			System.out.println(student);
		}
	}
	
	void select(StudentDao studentDao) {
		System.out.print("검색할 학생의 학번 : ");
		String hakbun = this.scan.next();
		Student student = studentDao.read(hakbun);
		System.out.println(student);
	}
	
	public static void main(String[] args) {
		MainClass main = new MainClass();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:beans.xml");
		ctx.refresh();
		
		StudentDao studentDao = ctx.getBean("studentDao", StudentDao.class);
		//main.insert(studentDao);
		//main.update(studentDao);
		//main.delete(studentDao);
		//main.selectAll(studentDao);
		main.select(studentDao);
		ctx.close();
	}
	private void calc(Student s) {
		int sum = s.getKor() + s.getEng() + s.getMat() + s.getEdp();
		double avg = sum / 4.;
		char grade = (avg <= 100 && avg >= 90) ? 'A' :
									(avg < 90 && avg >= 80) ? 'B' :
										(avg < 80 && avg >= 70) ? 'C' :
											(avg < 70 && avg >= 60) ? 'D' : 'F';
		s.setSum(sum);   s.setAvg(avg);   s.setGrade(grade);
	}
}
