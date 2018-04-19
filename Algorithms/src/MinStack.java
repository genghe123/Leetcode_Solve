// https://leetcode.com/problems/min-stack/description/

import java.util.Stack;

public class MinStack {

    /*
    // https://leetcode.com/problems/min-stack/discuss/49014/Java-accepted-solution-using-one-stack

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    public void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if (stack.pop() == min) min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
     */

    /*
    // https://leetcode.com/problems/min-stack/discuss/49031/Share-my-Java-solution-with-ONLY-ONE-stack
    // The idea is to store the gap between the min value and the current value;
    // The problem for my solution is the cast. I have no idea to avoid the cast.
    // Since the possible gap between the current value and the min value could be
    // Integer.MAX_VALUE-Integer.MIN_VALUE;

    private long min;
    private Stack<Long> stack = new Stack<Long>();

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min);
            if (x < min) min = x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        long pop = stack.pop();
        if (pop < 0) min = min - pop; // If negative increase the min value
    }

    public int top() {
        long top = stack.peek();
        if (top > 0)
            return (int) (min + top);
        else
            return (int) min;
    }

    public int getMin() {
        return (int) min;
    }
     */

    // https://leetcode.com/problems/min-stack/discuss/49181/Java-solution-(accepted)

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (min.empty() || x <= min.peek())
            stack.push(x);
    }

    public void pop() {
        if (stack.pop().equals(min.peek()))
            min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
