package com.danielg.test;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestSleepingBarber {	
private static final int CHAIRS = 5;
public static BlockingQueue<Customer> wchairs = new ArrayBlockingQueue(CHAIRS); //initiate the blocking queue for line-up, only 5 chairs

public static void main(String[] args)
		{			
			Barber John = new Barber(wchairs); 
		    John.start(); //Begin the work hours, start barber thread
		    for (int i=1; i<11; i++) {
		        Customer aCustomer = new Customer(i, wchairs);
		        try {
		          aCustomer.start(); //customers start to show up
		          Thread.sleep(1000); //Barber  is taking his time before serving the customers
		        } catch(InterruptedException ex) {};

		    }
		    
		}
}
		
