import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class FirstCharacter {

    private HashMap<Character,Integer> map = new HashMap<>();
    private Queue<Character> queue = new LinkedList<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
            while (!queue.isEmpty() && map.get(queue.peek())>1){
                queue.poll();
            }
        }else {
            map.put(ch,1);
            queue.add(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char first = queue.isEmpty() ? '#':queue.peek();
        return first;
    }
}
