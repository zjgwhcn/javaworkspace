package com.javajichu.zjg;  //��һ��
import java.io.*;           //�ڶ���
public class FirstJavaProgram {//������
	//���ݲ��֣����Ĳ�
	private String name;
	private int age;
	
	/*�����֣����岽
	һ�����ⷽ��---���췽��/����*/
	public FirstJavaProgram(String aName,int aAge){
		name=aName;
		age=aAge;
	}
	
	//���ݶ�ȡ����
	public String getName(){
		return name;
	}
	
	public void setName(String aName){
		name=aName;
	}
	
	//������ڷ���
	public static void main(String[] args){
		//�������󣬵�����
		FirstJavaProgram fjp=new FirstJavaProgram("�ž�",25);
		System.out.println("Name is"+fjp.getName());
	}
}
