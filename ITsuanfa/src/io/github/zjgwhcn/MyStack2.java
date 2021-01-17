package io.github.zjgwhcn;

import java.util.Stack;

public class MyStack2 {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public MyStack2(){
		this.stackData=new Stack<Integer>();
		this.stackMin=new  Stack<Integer>();
	}
	public void push(int newNum){
		if(this.stackMin.isEmpty()){
			this.stackMin.push(newNum);
			
		}else if (newNum<this.getmin()){
			this.stackMin.push(newNum);
			
		}else{
			int newMin=this.stackMin.peek();
			this.stackMin.push(newNum);
		}
		this.stackData.push(newNum);
		
	}
	public int pop(){
		if(this.stackData.isEmpty()){
			throw new RuntimeException("Your stack is empty.");
			
		}
		this.stackMin.pop();
		return this.stackMin.pop();
	}
	
	public int getmin(){
		if(this.stackData.isEmpty()){
			throw new RuntimeException("Your stack is empty.");

		}
		return this.stackMin.peek();
	}
}
