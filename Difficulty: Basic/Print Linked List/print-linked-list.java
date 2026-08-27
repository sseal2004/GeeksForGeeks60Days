/*
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
}*/

class Solution {
    public ArrayList<Integer> printList(Node head) {
        ArrayList<Integer>list = new ArrayList<>();
        // code here
        Node ptr=head;
        while(ptr!=null){
            list.add(ptr.data);
            ptr=ptr.next;
        }
        return list;
    }
}