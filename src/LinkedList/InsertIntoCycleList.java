package LinkedList;

/**
 * 第二个是给出一个已经排序的循环链表，往里面插入一个节点。
 * http://www.geeksforgeeks.org/sorted-insert-for-circular-linked-list/
 * 实际的题有一点不一样的是它每次给你的HEAD不一定是链表最小那个。
 *
 * 题目定义了一个CNode，其实跟ListNode一样，有val，有指针，list首尾相连而已，list里的node升序排列，题目也不难，不过有两点注意一下：
 * 一个是给你的CNode start不一定是最小值的CNode，所以要先找到最小的点；
 * 二是可能有duplicate节点
 *
 */
public class InsertIntoCycleList {

    public class CNode{
        public int value;
        public CNode next;

        public CNode(int val){
            this.value = val;
        }
    }

    public CNode insert(CNode head, int target) {
        CNode newNode = new CNode(target);

        //没有点
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        //只有一个点
        if (head.next == head) {
            head.next = newNode;
            newNode.next = head;
            return newNode;
        }

        CNode prev = head;
        CNode current = head.next;

        while (current != head) {

            //找到了正确位置
            if (target >= prev.value && target <= current.value) {
                break;
            }

            //大于环中最大,小于最小
            if (prev.value > current.value && (target > prev.value || target < current.value)) {
                break;
            }
            prev = current;
            current = current.next;
        }

        //或者回到原点,插在head前
        prev.next = newNode;
        newNode.next = current;
        return newNode;
    }
}
