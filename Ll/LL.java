import java.util.LinkedList;

public class LL {
    private Node head;
    private Node tail;
    private int size;
    public LL() {
        this.size = 0;
    }
    private class Node {
        private int value;
        private Node next;
        
        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    public void insertFirst(int val){
        Node node=new Node(val);
        node.next=head;
        head=node;
        if (tail==null) {
            tail=head;
        }
        size+=1;
    }
    public void display(){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.println("END");
    }
    public void insertLast(int val){
        if (tail==null) {
            insertFirst(val);
            return;
        }
        Node node=new Node(val);
        tail.next=node;
        tail=node;
        
        size+=1;
    }
    public void insert(int val,int index){
        if(index==0){
            insertFirst(val);
            return;
        }
        if (index==size) {
            insertLast(val);
            return;
        }
        Node temp=head;
        for (int i = 1; i < index; i++) {
            temp=temp.next;
        }
        Node node=new Node(val,temp.next);
        temp.next=node;
        size++;
    }
    public Node get(int index){
        Node node=head;
        for (int i = 0; i < index; i++) {
            node=node.next;
        }
        return node;
    }
    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
//insert using recursion 
    public void insertRec(int val, int index){
        head=insertRec(val, index, head);
    }
    private Node insertRec (int val,int index,Node node){
        if (index==0) {
            Node temp=new Node(val,node);
            size++;
            return temp;
        }
        node.next=insertRec(val, index, node.next);
        return node;
    }

    public int deleteFirst(){
        int val=head.value;
        head=head.next;
        if (head==null) {
            tail=null;
        }
        size--;
        return val;
    }
    public int deleteLast(){
        if (size<=1) {
            return deleteFirst();
        }
        Node secondLast=get(size-2);
        int val=tail.value;
        tail=secondLast;
        tail.next=null;
        size--;
        return val;
    }
    public int delete(int index){
        if (index==0) {
            return deleteFirst();
        }
        if (index==size-1) {
            return deleteLast();
        }        
        Node prevNode=get(index-1);
        int val=prevNode.next.value;
        prevNode.next=prevNode.next.next;
        return val;
    }
//questions

    public void duplicatesRemove(){
        Node node =head;
        while(node.next!=null){
            if ( node.value==node.next.value) {
                node.next=node.next.next;
                size--;
            }else{
                node=node.next;
            }
        }
        tail=node;
        tail.next=null;
    }
    //merge
    public static LL merge (LL first, LL second){
        Node f= first.head; 
        Node s=second.head;
        LL ans =new LL();
        while (f!=null && s!=null) {
            if (f.value<s.value) {
                ans.insertLast(f.value);
                f=f.next;
            }else{
                ans.insertLast(s.value);
                s=s.next;
            }
        }while (f!=null) {
            ans.insertLast(f.value);
            f=f.next;
        }
        while (s!=null) {
            ans.insertLast(s.value);
            s=s.next;
        }
        return ans;
    }
    //has cycyle
    public boolean hasCycle(Node head) {
        Node f=head;
        Node s=head;
        while(f!=null && f.next!=null){
            f=f.next.next;
            s=s.next;
            if(f==s){
                return true;
            }
        }
        return false;
    }
   
   
//bubble sort
public void bubbleSort(){
     bubbleSort(size-1,0);
}  
private void bubbleSort(int row, int col) {
    if (row==0) {
        return;
    }
    if (col<row) {
        Node first=get(col);
        Node second=get(col+1);

        if (first.value>second.value) {
            if (first==head) {
                head=second;
                first.next=second.next;
                second.next=first;
            }else if (second==tail) {
                Node prev=get(col-1);
                prev.next=second;
                tail=first;
                first.next=null;
                second.next=tail;
            }else{
                Node prev=get(col-1);
                prev.next=second;
                first.next=second.next;
                second.next=first;
            }
        }
        bubbleSort(row, col+1);
    }else{
        bubbleSort(row-1, 0);
    }
}
    
private void reverse(Node node){
    if (node==tail) {
        head=tail;
        return;
    }
    reverse(node.next);         
    tail.next=node;
    tail=node;
    tail.next=null;
}
//206 Leetcode Reverse Linked List
public Node reverseList(Node head) {
    if(head==null){
        return head;
    }
    Node prev = null;
    Node present = head;
    Node next = present.next;

    while (present != null) {
        present.next=prev;
        prev=present;
        present=next;
        if (next!=null) {
            next=next.next;
        }
    }
    return prev;
}
private void reverse(){
    if (size<2) {
        return; 
    }
    Node prev =null;
    Node present=head;
    Node next=present.next;

    while (present!=null) {
        present.next =prev;
        prev=present;
        present=next;
        if (next!=null) {
            next=next.next;
        }
    }
    head=prev;
}

// reverse list 2 leetcode 92!!!!important 
public Node reverseBetween(Node head, int left, int right) {
       if (left==right) {
        return head;
       } 
       Node current=head;
       Node prev=null;

       for (int i = 0; current!=null && i < left-1; i++) {
            prev=current;
            current=current.next;
       }
       
        Node last=prev;
        Node newEnd=current;

        //reverse between left and right 
        Node next=current.next;
        for (int i = 0; current!=null && i < right-left+1; i++) {
                current.next=prev;
                prev=current;
                current=next;
                if (next!=null) {
                    next=next.next;
                }
        }
        if (last!=null) {
            last.next=prev;
        }else{
            head=prev;
        }
        newEnd.next=current;
        return head;
}
//25 reverse node in k group 

public Node reverseKGroup(Node head,int k){
    if (k<=1 || head==null) {
        return head;
    }
    Node current=head;
    Node prev=null;

    while (true) {
        Node last=prev;
        Node newEnd=current;
    
        //reverse between left and right 
        Node next=current.next;
        for (int i = 0; current!=null && i<k; i++) {
            current.next=prev;
            prev=current;
            current=next;
            if (next!=null) {
                next=next.next;
            }
        }
        if (last!=null) {
            last.next=prev;
        }else{
            head=prev;
        }
        newEnd.next=current;

        if (current==null) {
            break;
        }
        prev=newEnd;
    }
    return head;

}


//get middle
Node getMid(Node head) {
    Node s=head;
    Node f=head;

        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;

        }
        return s;
}
//palindrome linkedlist or not

public boolean isPalindrome(Node head) {
    Node mid=getMid(head);
    Node headSecond=reverseList(mid);
    Node rereverseHead=headSecond;
    while (head!=null && headSecond!=null) {
        if (head.value!=headSecond.value) {
            break;
        }
        head=head.next;
        headSecond=headSecond.next;
    }
    reverseList(rereverseHead);
    if (head==null || headSecond==null) {
        return true;
    }
    return false;
}

//reordered Lidt 143
public void reorderList(Node head) {
    if (head==null && head.next==null) {
        return;
    }
    Node mid=getMid(head);
    Node hs=reverseList(mid);
    Node hf=head;

    //rearrange

    while (hf!=null && hs!=null) {
        Node temp=hf.next;
        hf.next=hs;
        hf=temp;

        temp=hs.next;
        hs.next=hf;
        hs=temp;
    }
    //next of tail to null

    if (hf!=null) {
        hf.next=null;
    }
}










public static void main(String[] args) {
        LL f = new LL();
        LL s = new LL();

        f.insertLast(1);
        f.insertLast(3);
        f.insertLast(5);

        s.insertLast(1);
        s.insertLast(2);
        s.insertLast(3);
        s.insertLast(5);
     

        LL ans = LL.merge(f, s);
        ans.display();
        LL list = new LL();
        // Test duplicatesRemove method
        list.insertLast(35);
        list.insertLast(40);
        list.insertLast(40);
        list.insertLast(50);
        list.display(); // Output: 20->25->35->40->35->40->40->50->END
        list.duplicatesRemove();
        list.display(); // Output: 20->25->35->40->50->END

        // Test merge method
        LL first = new LL();
        first.insertLast(1);
        first.insertLast(3);
        first.insertLast(5);

        LL second = new LL();
        second.insertLast(2);
        second.insertLast(3);
        second.insertLast(5);
        second.insertLast(9);
        second.insertLast(14);

        LL merged = LL.merge(first, second);
        merged.display(); // Output: 1->2->3->3->5->5->9->14->END

        // Test hasCycle method
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        // Creating a cycle
        list.tail.next = list.head.next;
        System.out.println("Does the list have a cycle? " + list.hasCycle(list.head)); // Output: true

        // Test bubbleSort method
        LL unsortedList = new LL();
        unsortedList.insertLast(5);
        unsortedList.insertLast(3);
        unsortedList.insertLast(8);
        unsortedList.insertLast(1);
        unsortedList.insertLast(2);
        unsortedList.display(); // Output: 5->3->8->1->2->END
        unsortedList.bubbleSort();
        unsortedList.display(); // Output: 1->2->3->5->8->END

        // Test reverseList method
        LL listToReverse = new LL();
        listToReverse.insertLast(1);
        listToReverse.insertLast(2);
        listToReverse.insertLast(3);
        listToReverse.display(); // Output: 1->2->3->END
        listToReverse.head = listToReverse.reverseList(listToReverse.head);
        listToReverse.display(); // Output: 3->2->1->END

        // Test reverseBetween method
        LL listToReverseBetween = new LL();
        listToReverseBetween.insertLast(1);
        listToReverseBetween.insertLast(2);
        listToReverseBetween.insertLast(3);
        listToReverseBetween.insertLast(4);
        listToReverseBetween.insertLast(5);
        listToReverseBetween.display(); // Output: 1->2->3->4->5->END
        listToReverseBetween.head = listToReverseBetween.reverseBetween(listToReverseBetween.head, 2, 4);
        listToReverseBetween.display(); // Output: 1->4->3->2->5->END

        // Test isPalindrome method
        LL palindromeList = new LL();
        palindromeList.insertLast(1);
        palindromeList.insertLast(2);
        palindromeList.insertLast(3);
        palindromeList.insertLast(2);
        palindromeList.insertLast(1);
        System.out.println("Is the list a palindrome? " + palindromeList.isPalindrome(palindromeList.head)); // Output: true

    }
}
