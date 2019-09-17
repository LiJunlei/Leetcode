package StackQueue;

import java.util.Stack;

public class ImplQueueWithStacks {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    /** Initialize your data structure here. */
    public ImplQueueWithStacks() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!input.isEmpty()){
            output.push(input.pop());
        }
        input.push(x);
        while(!output.isEmpty()){
            input.push(output.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return input.pop();
    }

    /** Get the front element. */
    public int peek() {
        return input.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */