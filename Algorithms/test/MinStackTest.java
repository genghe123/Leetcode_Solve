import org.junit.Assert;
import org.junit.Test;

public class MinStackTest {

    MinStack minStack = new MinStack();

    @Test
    public void Test1() {
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        Assert.assertEquals(0, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(0, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(1, minStack.getMin());
    }

    @Test
    public void Test2() {
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assert.assertEquals(-3, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(0, minStack.top());
        Assert.assertEquals(-2, minStack.getMin());
    }

}