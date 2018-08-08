package tools;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3=new ListNode((l1.val+l2.val)%10);
        int temp = (l1.val+l2.val)/10;
        ListNode l32=new ListNode((l1.next.val+l2.next.val+temp)%10);
        temp = (l1.next.val+l2.next.val+temp)/10;
        ListNode l33=new ListNode((l1.next.next.val+l2.next.next.val+temp)%10);
        temp = (l1.next.next.val+l2.next.next.val+temp)/10;
        l3.next=l32;
        l32.next=l33;
        if(temp!=0){
            ListNode l34=new ListNode(temp);
            l33.next=l34;
            l34.next=null;
        }else{
            l33.next=null;
        }
        return l3;
    }
    public static void main(String[] args){
        int[] a = {2,4,8};
        int[] b = {5,6,4};
        ListNode l1 = new ListNode(a[0]);
        ListNode l12 = new ListNode(a[1]);
        ListNode l13 = new ListNode(a[2]);
        l1.next=l12;
        l12.next=l13;
        l13.next=null;
        ListNode l2 = new ListNode(b[0]);
        ListNode l22 = new ListNode(b[1]);
        ListNode l23 = new ListNode(b[2]);
        l2.next=l22;
        l22.next=l23;
        l23.next=null;
        ListNode res = addTwoNumbers(l1,l2);
        System.out.println("["+res.val+","+res.next.val+","+res.next.next.val+res.next.next.next.val+"]");
    }
    
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}