package com.javajichu.zjg; 

import java.util.Stack;

public class MyStack1 
{

	private Stack<Integer> stackData;  //定义一个堆stackData
	private Stack<Integer> stackMin;   //定义一个堆stackMin
		
	public MyStack1()
	{
	this.stackData=new Stack<Integer>();  //堆实例
	this.stackMin=new Stack<Integer>();
	}
	
	public void push(int newNum)
	{
		if (this.stackMin.isEmpty())
		{
			this.stackMin.push(newNum);
			
		} else if (newNum <= this.getmin())
			{
			this.stackMin.push(newNum);					
			}
			this.stackData.push(newNum);				
	}
	
	public int pop()
	{
	if (this.stackData.isEmpty())
	{
		throw new RuntimeException("Your stack is empty.");//异常显示内容
	}
	int value = this.stackData.pop();
	if (value == this.getmin())
	{
		this.stackMin.pop();
	}
	return value;
	}

	public int getmin()
	{
		if (this.stackMin.isEmpty())
		{
			throw new RuntimeException("Your stack is empty.");	
		}
		return this.stackMin.peek();
	}
	
	public static void main(String[] args){
		//创建对象，第六步
		MyStack1 s=new MyStack1();
		//s.newNum = 5;
		//System.out.println("pop is"+s.pop());
		s.push(3);
        s.push(4);
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(1);
        s.push(4);
        s.push(5);
        s.push(1);
        s.push(2);
        System.out.println(s.getmin());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
	}
}

