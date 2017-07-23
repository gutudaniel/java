package com.danielg.test;
import java.util.concurrent.BlockingQueue;
public class Customer implements Runnable{
private int customerID; //customer ID used to identify it
private boolean notCut=true; //is the customer served, initially set to true
private int wait_time = 0; //used to increment the time a customer is willing to wait
private Thread c;
private BlockingQueue<Customer> queue; //blocking queue

public Customer(int i, BlockingQueue<Customer> bg) {
    customerID = i;
    queue = bg; 
  }

public void run() { 
      try {
    	  while (!queue.offer(this)){
    		  wait_time++;
    		  Thread.sleep(1000);
    		  if (wait_time == 1 ) //waiting for two rounds then leaving
    		  { c.interrupt();}
    	  	}
    	  	System.out.println("Customer " + this.customerID + " just sat down.");
      }	  
      catch (InterruptedException e)
      {
    	  System.out.println("Customer " + this.customerID + " just left"); //adding customer in the queue failed
      }
}
public void start () //start thread method, name of thread is customerID
{
   System.out.println("Customer " +  customerID + " just got in" );
   if (c == null)
   {c = new Thread (this, Integer.toString(customerID));
      c.start ();}
}

public void set_haircut (boolean b) //access to notCut variable 
{notCut = b;}

public int get_customer_ID ()
{return customerID; }//access to customer ID
}
