/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int a){
        data = a;
        next = null;
    }
}
*/
class Solution {
    public int getCount(Node head) {
        // code here
        int count =0;Node ptr=head;
        while(ptr!=null){
            ptr=ptr.next;
            count++;
        }
        return count;
    }
}