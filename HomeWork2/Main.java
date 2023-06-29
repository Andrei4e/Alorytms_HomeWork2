package HomeWork2;

public class Main{

    static Node head;
    static Node tail;
    
    public void addNode(int value){
        Node node = new Node(value);

        if (head == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prevous = tail;
            tail = node;
        }

    }

    public Node find(int value){
        Node currentNode = head;
        while (currentNode !=null){
            if (currentNode.value == value)
                return currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }

    public void revert(){
        Node currentNode = head;

        while (currentNode != null) {
            Node next = currentNode.next;
            Node prevous = currentNode.prevous;
            currentNode.next = prevous;
            currentNode.prevous = next;

            if (prevous == null)
                tail = currentNode;
            
            if (next == null)
                head = currentNode;

            currentNode = next;
        }
    }

    public void printNode(){
        Node current = head;
        while (current != null){
            System.out.print(current.value);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        var list = new Main();
        list.addNode(5);
        list.addNode(3);
        list.addNode(8);
        list.addNode(1);
        list.addNode(9);
        list.addNode(4);
        list.addNode(2);
        list.addNode(7);        
        System.out.println("Исходный список:");
        list.printNode();
        list.revert();
        System.out.println("Развернутый список:");
        list.printNode();
    }
}