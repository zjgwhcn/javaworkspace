package com.javajichu.zjg; 

import java.util.Stack;

public class MyStack1 
{

	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public MyStack1()
	{
	this.stackData=new Stack<Integer>();
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
		throw new RuntimeException("Your stack is empty.");	
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
	public static void main(Integer[] args){
		//创建对象，第六步
		MyStack1 ff=new MyStack1();
		System.out.println("pop is"+ff.pop());
	}
}

