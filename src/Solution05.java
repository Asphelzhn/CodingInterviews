/*题目描述
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
*
*
思路：
栈1用来push，将元素加入队列。
栈2用来pop，为了维持队列顺序，当栈2为空时，栈1全部元素出栈到栈2，然后栈2再出栈。
栈2不空时直接出栈即可
* */
import java.util.Stack;

public class Solution05 {


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty() && stack1.isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        int num = stack2.pop();
        return num;
    }

}
