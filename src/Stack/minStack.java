package Stack;

import java.util.Stack;

/**
 * Iterator a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 Example:
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.

 */
public class minStack {

    Stack<Integer> nstack;
    Stack<Integer> mstack;

    public minStack() {
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
