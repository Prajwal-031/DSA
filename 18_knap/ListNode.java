import java.util.Scanner;

class Main {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int numNodes = sc.nextInt();

        ListNode head = null;
        ListNode tail = null;

        for(int i=0;i<numNodes;i++){

            int value = sc.nextInt();
            ListNode newNode = new ListNode(value);

            if(head == null){
                head = newNode;
                tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }
        }

        // print list
        ListNode current = head;
        while(current != null){
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
        
        System.out.println("=== NP Algorithm Demo: 0/1 Knapsack ===");
        
        // Knapsack demo
        Knapsack k = new Knapsack();
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        int knapN = val.length;
        
        int maxValue = k.knapsack(W, wt, val, knapN);
        System.out.println("Maximum knapsack value: " + maxValue);
        System.out.println("Items: weights=[10,20,30], values=[60,100,120], Capacity=50");
        
        sc.close();
    }
}
