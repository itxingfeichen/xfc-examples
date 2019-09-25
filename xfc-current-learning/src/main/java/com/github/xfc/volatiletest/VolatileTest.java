package com.github.xfc.volatiletest;
 
public class VolatileTest {
	
//	boolean stop = false;
	volatile boolean stop = false;

	public static void main(String[] args) throws Exception{
		VolatileTest v = new VolatileTest();
		Thread ta = new Thread(()->v.execute());
		ta.start();
		Thread.sleep(2000);
		Thread tb = new Thread(()->v.shutdown());
		tb.start();
	}
	
	public void execute(){
		while(!stop){
			String a = "a";
//			System.out.print("");
		}
	}
	public void shutdown(){
		System.out.println("do stop");
		stop = true;
	}
	
	
 
}

