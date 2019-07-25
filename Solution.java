//https://leetcode.com/problems/merge-k-sorted-lists/
/**
 * It's a very slow algorithm
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int minIndex = searchSmallestHeadNode(lists);
        
        if (minIndex == -1)
            return null;
        
        ListNode head = lists[minIndex];
        ListNode tail = head;
        disconnectHead(lists, minIndex);
        
        minIndex = searchSmallestHeadNode(lists);
        
        while(minIndex != -1)
        {
            tail.next = lists[minIndex];
            tail = tail.next;
            
            disconnectHead(lists, minIndex);
            
            minIndex = searchSmallestHeadNode(lists);
        }
        
        return head;
    }
    
    private void disconnectHead(ListNode[] lists, int targetIndex)
    {
        if (lists[targetIndex].next != null)
            lists[targetIndex] = lists[targetIndex].next;
        else
            lists[targetIndex] = null;
    }
    
    private int searchSmallestHeadNode(ListNode[] lists)
    {
        int min = 0;
        int minIndex = -1;
        int i = 0;
        for(; i < lists.length; i++)
        {
            if (lists[i] != null)
            {
                min = lists[i].val;
                minIndex = i;
                break;
            }
        }
        
        for(; i < lists.length; i++)
        {
            if (lists[i] != null && lists[i].val < min)
            {
                min = lists[i].val;
                minIndex = i;
            }
        }
        
        return minIndex;
    }
}
