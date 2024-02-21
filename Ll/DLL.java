public class DLL {
    Node head;
    public void insertFirst(int val){
        Node node=new Node(val);
        node.next=head;
        node.prev=null;
        if (head!=null) {
            head.prev=node;
        }
        head=node;
    }
    public void display(){
        Node node=head;
        while (node!=null) {
            System.out.print(node.val+"<->");
            node=node.next;
        }
        System.out.println();
    }
    public void displayReverse(){
        Node currNode=head;
        if (currNode==null) {
            return;
        }
        while (currNode.next!=null) {
            currNode=currNode.next;
        }
        while (currNode!=null) {
            System.out.print(currNode.val+"<->");
            currNode=currNode.prev;
        }
        System.out.println();

    }
    public void insertLast(int val){

        Node node=new Node(val);
        Node currNode=head;
        node.next=null;
        if (head==null) {
            node.prev=null;
            head=node;
            return;
        }
        while (currNode.next!=null) {
            currNode=currNode.next;
        }
        currNode.next=node;
        node.prev=currNode;
    }
    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public void insert(int after,int val){
        Node p=find(after);
        if (p==null) {
            System.out.println("does not exist");
            return;
        }
        Node node=new Node(val);
        node.next=p.next;
        p.next=node;
        node.prev=p;
        if (node.next!=null) {
            node.next.prev=node;
        }
    }

    private class Node {
        int val;
        Node next;
        Node prev;
        public Node(int val, DLL.Node next, DLL.Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
        public Node(int val) {
            this.val = val;
        }
        
    }
}
