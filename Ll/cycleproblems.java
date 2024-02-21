public class cycleproblems {
    //leetcode 141
    //two pointer method 
    //amazon and microsoft
   class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
    }
   public boolean hasCycle(ListNode head) {
        ListNode first=head;
        ListNode second=head;
        while(first!=null && first.next!=null){
            first=first.next.next;
            second=second.next;
            if(first==second){
                return true;
            }
        }
        return false;
    } 
    //find length of cycle 
    public int lengthCycle(ListNode head) {
        ListNode first=head;
        ListNode second=head;
        while(first!=null && first.next!=null){
            first=first.next.next;
            second=second.next;
            if(first==second){
                //calculate length 
                ListNode temp=second;
                int length=0;
                do{
                    temp=temp.next;
                    length++;
                }while(temp!=second);
                    return length;

            }
        }
        return 0;
    } 

    //find from where the cycle is starting 
    //leetcode 142

    public ListNode detectCycle(ListNode head){
        int length =0;

        ListNode first=head;
        ListNode second=head;
        while(first!=null && first.next!=null){
            first=first.next.next;
            second=second.next;;
            if(first==second){
                length=lengthCycle(second);
                break;
            }
        }
        if (length==0) {
            return null;
        }
        // find the start node
        ListNode f=head;
        ListNode s=head;

        while (length>0) {
            s=s.next;
            length--;
        
        }

        while (f!=s) {
            f=f.next;
            s=s.next;
        }
        return s;
    }

    //happy number 
    //202
    public boolean isHappy(int n) {
        int slow=n;
        int fast =n;
        do{
            slow=findSquare(slow);
            fast=findSquare(findSquare(fast));
        }while(slow!=fast);

        if (slow==1) {
            return true;
        }
        return false;

    }
    private int findSquare(int number){
        int ans=0;
        while (number>0) {
            int rem=number%10;
            ans+=rem*rem;
            number/=10;
            
        }
        return ans;
    }

    //876 find the middle  
    public ListNode middleNode(ListNode head) {
        ListNode s=head;
        ListNode f=head;
        while (f!=null && f.next!=null) {
            s=s.next;
            f=f.next.next;
        }
        return s;
    }


}
