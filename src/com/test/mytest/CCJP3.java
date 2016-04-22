package com.test.mytest;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class CCJP3 {

	public static void main(String[] args) {
		/*List<Object> test=new ArrayList<Object>();
		test.add(new A());
		//List<Object> test1=new ArrayList<Integer>();
*/	
		//System.out.println(Math.sqrt(4D));
		//RuntimeException re=null;
		/*int a=1;
		int b=3;
		if(a==b){
			System.out.println("a and b are not same");
		}*/
	/*	TestThreed t=new TestThreed();
		t.run();*/
		double d=-100.675;
		System.out.println(Math.ceil(d));
		}

}
class TestThreed implements Runnable {
	public void run() {
		System.out.println("start");
	}
}