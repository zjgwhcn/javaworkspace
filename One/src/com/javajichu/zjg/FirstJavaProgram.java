package com.javajichu.zjg;  //第一步
import java.io.*;           //第二步
public class FirstJavaProgram {//第三步
	//数据部分，第四步
	private String name;
	private int age;
	
	/*法部分，第五步
	一种特殊方法---构造方法/函数*/
	public FirstJavaProgram(String aName,int aAge){
		name=aName;
		age=aAge;
	}
	
	//数据读取方法
	public String getName(){
		return name;
	}
	
	public void setName(String aName){
		name=aName;
	}
	
	//运行入口方法
	public static void main(String[] args){
		//创建对象，第六步
		FirstJavaProgram fjp=new FirstJavaProgram("张军",25);
		System.out.println("Name is"+fjp.getName());
	}
}
