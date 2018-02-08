package com.datastructure.stack;

import java.util.Stack;

public class MinStack extends Stack<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Stack<Integer> min = new Stack<>();
	
	int getMin()
    {
        int x = min.peek();
        return x;
    }
	
	void push(int x)
	{
	    if(isEmpty() == true)
	    {
	        super.push(x);
	        min.push(x);
	    }
	    else
	    {
	        super.push(x);
	        int y = min.peek();
	     
	        /* push only when the incoming element of main stack is smaller 
	        than or equal to top of auxiliary stack */
	        if( x <= y )
	            min.push(x);
	    }
	}
	     
	/* SpecialStack's member method to remove an element from it. This method
	removes top element from min stack also. */
	public Integer pop()
	{
	    int x = super.pop();
	    int y = min.pop();
	     
	    /* Push the popped element y back only if it is not equal to x */
	    if ( y != x )
	        min.push(y);
	    return x;
	}

}
