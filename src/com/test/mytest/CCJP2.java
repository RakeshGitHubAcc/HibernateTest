package com.test.mytest;

import java.util.ArrayList;
import java.util.NavigableSet;
import java.util.TreeSet;
class A{}
class B extends A{}
class C extends B{}
public class CCJP2 /*extends A*/{
/*	String title;
	int value;
	public CCJP2(){
	title+="world";	
	}
	public CCJP2(int value){
		this.value=value;
		title="Hello";
	}*/
	public static void main(String args[]) {
		/*
		 * 2>Short shortobj=200;
		System.out.println(""+shortobj);
		if(shortobj<20){	
		}
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<10;i++){
		list.add(i);	
		}
		System.out.println(list);*/
		/*
		 * NavigableSet<Integer> ins=new TreeSet<Integer>();
		ins.add(2);
		ins.add(5);
		ins.add(9);
		System.out.println(""+ins.headSet(5));
		System.out.println(""+ins.pollLast());
		System.out.println(""+ins.lower(8));
		System.out.println(""+ins.tailSet(3));*/
		
	/*	Object[] o={"hi",28,true};
		for(int i=0;i<o.length;i++){
			System.out.println(o);
		}*/
	/*	System.out.println(new TestA(){
			public String toString(){
				return "test";
			}
		});*/
		/*String sampleString=" aaccbccba ";
		int x=2;
		sampleString=sampleString.trim();
		if(sampleString.length()<10){
			x=sampleString.indexOf('a',2);
		}
		System.out.println("x="+x);*/
		/*byte num1=6;
		num1+=8;
		System.out.println(num1);
		num1=(byte)(num1+7);
		System.out.println();*/
	/*	byte x=25;
		int y=x-5;
		System.out.println(x+y);*/
		/*A obj=new B();
		System.out.println(obj instanceof B);
		System.out.println(obj instanceof CCJP2);
		System.out.println(obj instanceof C);*/
		/*String str=null;
		if(str.equals(null)){
			System.out.println("null");
		}else if(str.length()==0){
		System.out.println("zero");	
		}else{
			System.out.println("some");
		}*/
		/*System.out.println(false^true);
		System.out.println(!false);*/
		/*String[] strNew=new String[10];*/
		/*Object[] o={"welcome",14,false};
		for(int i=0;i<o.length;i++){
			System.out.println(o);
		}*/
		/*CCJP2 c=new CCJP2(5);
		System.out.println(c.title);*/
		/*char a=true;
		char b=null;
		char c='\n';
		char d='Hell';*/
		/*String strOne="Hello";
		String strTwo=new String("Hello");
		if(strOne.equals(strTwo)){
			System.out.println("welocme");
		}*/
	}
	//public enum Animals{Cat,Dog,Rabbit,Lion;private Animals(){}}
}
interface TestA{
	String toString();
}
