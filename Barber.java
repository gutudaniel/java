package com.danielg.test;
import java.util.concurrent.BlockingQueue;
public class Barber implements Runnable {
	private BlockingQueue <Customer> queue; 
	private Thread b;
	private Customer c; //current customer
	public Barber(BlockingQueue<Customer> bq) 
	{this.queue = bq;}
public void run() 
	{
	while (true) 
		{
	      try {
	      Thread.sleep(1000);
	      c = queue.take();
	      this.cutHair();} 
	      catch ( InterruptedException e) 
	      {System.out.println("Barber could not retreive the customer in line");}
	     }
	}
		/* this method will simulate cutting hair */
public void start()
{
	if (b == null)
    {
       b = new Thread (this);
       b.start ();
    }
}
	   
public void cutHair(){
	try {
		
		System.out.println("Barber taking customer " + c.get_customer_ID());
	    Thread.sleep(3000);
	    c.set_haircut(false);
	    System.out.println("Customer " + c.get_customer_ID() + " just got his hair cut");
	    } catch ( InterruptedException e){ 
	    	System.out.println("Barber could not cut hair");
	    }
	}
}
