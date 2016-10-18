package VFacebookTemp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Christina on 2/29/16.
 */
public class CopyListwithRandomPointer {

    /**
     *
     A linked list is given such that each node contains an additional random pointer
     which could point to any node in the list or null.
     Return a deep copy of the list.
     */

    static class RandomListNode {
        int label;
            RandomListNode next, random;
            RandomListNode(int x) { this.label = x; }
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
            return null;
        }

        Map<Integer,RandomListNode> map = new HashMap<Integer,RandomListNode>();
        RandomListNode newhead = new RandomListNode(0);
        RandomListNode index = newhead;

        while(head!=null){
            RandomListNode temp;
            if(map.containsKey(head.label)==false){
                temp =  new RandomListNode(head.label);
                map.put(head.label,temp);
            }else{
                temp = map.get(head.label);
            }

            index.next = temp;

            if(head.random!=null ){
                if(map.containsKey(head.random.label)==false){
                    //q.add(temp.random);
                    RandomListNode newran = new RandomListNode(head.random.label);
                    temp.random = newran;
                    map.put(head.random.label,newran);
                }
                else{
                    temp.random = map.get(head.random.label);
                }
            }

            head = head.next;
            index = temp;

        }
        return newhead.next;
    }
}
