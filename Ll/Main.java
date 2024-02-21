public class Main {
    public static void main(String[] args) {
        LL list=new LL();
        list.insertFirst(5);
        list.insertFirst(10);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(2);
        // list.insertFirst(11);
        // list.insertLast(2222);
        list.display();
        list.insertRec(88,2);
        list.display();
    }
}
