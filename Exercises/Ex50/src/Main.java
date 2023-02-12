public class Main {
    public static void main(String[] args) {
        ListItem li = new Node("4");
        NodeList list = new MyLinkedList(li);
        list.addItem(new Node("6"));
        list.addItem(new Node("2"));
        list.addItem(new Node("7"));
        list.addItem(new Node("2"));
        list.addItem(new Node("9"));
        list.addItem(new Node("1"));
        list.traverse(list.getRoot());

        System.out.println();
//        list.removeItem(new Node(7));
        list.traverse(null);


//        NodeList tree = new SearchTree(new Node(7));
//        tree.addItem(new Node(7));
//        tree.addItem(new Node(10));
//        tree.addItem(new Node(9));
//        tree.addItem(new Node(3));
//        tree.addItem(new Node(7));
//        tree.addItem(new Node(4));
//        tree.addItem(new Node(-5));
//        tree.addItem(new Node(16));
//        tree.addItem(new Node(0));
//        tree.addItem(new Node(9));
//        tree.addItem(new Node(1));
//        tree.traverse(tree.getRoot());
//
//        tree.removeItem(new Node(3));
//        System.out.println();
//        tree.traverse(tree.getRoot());

    }
}