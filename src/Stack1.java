import java.util.*;
public class Stack1{
	
//	Implement Queue class, given Stack class implementation.
	// push(), pop(), peek(), isEmpty()
	 
//	Analysis:
//	For this method, I also use two stack. The time complexity for push() is O(1), for pop() is O(1) if stack_2 is not empty and is O(n) if stack_2 is empty(). The time complexity for pop() is depended on the opration pattern.
//	For peek(), the time complexity is O(1) if stack_2 is not empty and is O(n) if stack_2 is empty. The time complexity for peek() is also depended on the opration pattern. For isEmpty(), the time complexity is O(1).
//	The time complexity for both pop() and peek() is better than my previous method.
//	 
	public class MyQueue {
	    private Stack<Integer> stack1;
	    private Stack<Integer> stack2;
	    
	    public MyQueue() {
	       stack1 = new Stack<Integer>();
	       stack2 = new Stack<Integer>();
	    }
	    
	    private void stack2ToStack1() {
			while (! stack2.empty()) {
				stack1.push(stack2.peek());
				stack2.pop();
			}
		}
		
	    public void push(int number) {
	        stack2.push(number);
	    }

	    public int pop() {
	        if (stack1.empty() == true) {
				this.stack2ToStack1();
			}
	        return stack1.pop();
	    }

	    public int top() {
	        if (stack1.empty() == true) {
				this.stack2ToStack1();
			}
	        return stack1.peek();
	    }
	    
	    
	    
//	    Min Stack


		public class MinStack {
		    
		    Stack<Integer> nstack;
		    Stack<Integer> mstack;
		    
		    public MinStack() {
		        nstack = new Stack<Integer>();
		        mstack = new Stack<Integer>();
		    }
		
		    public void push(int number) {
		        if(nstack.isEmpty()==true){
		            mstack.push(number);   
		        }else{
		            if(number<=mstack.peek()){
		                mstack.push(number);
		            }
		        }
		        nstack.push(number);
		    }
		
		    public int pop() {
		        // write your code here
		        if(nstack.isEmpty()==true){
		            return -1;
		        }
		        int ret = nstack.pop();
		        if(ret<=mstack.peek()){
		            mstack.pop();
		        }
		        return ret;
		        
		    }
		    public int top(){
		        return nstack.peek(); 
		    }
		    
		    public int getMin() {
		        if(mstack.isEmpty()==false){
		            return mstack.peek();
		        }else{
		            return -1;
		        }
		    }
		}

	}

	
	
}