/* Structure of a linked list node
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    public Node insertInMiddle(Node head, int x) {
        // code here
        int count=0;
        Node newNode = new Node(x);
        Node ptr= head;
        if(head==null)return newNode;
        while(ptr!=null){
            ptr=ptr.next;
            count++;
        }
        
        Node slow= head;
        Node fast=head;
        Node prev= null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast= fast.next.next;
        }
            
            if(count % 2 == 1){
            newNode.next=slow.next;
            slow.next=newNode;
            }
            else{
                prev.next=newNode;
                newNode.next=slow;
            }


        return head;
    }
}