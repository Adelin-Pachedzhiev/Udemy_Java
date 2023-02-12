public class MyLinkedList implements NodeList {
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem item) {
        ListItem currentItem = getRoot();
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if(currentItem.previous() == null && comparison > 0){
                item.setNext(currentItem);
                currentItem.setPrevious(item);
                this.root = item;
                return true;
            }
            if (currentItem.next() == null && comparison != 0) {
                item.setPrevious(currentItem);
                item.setNext(null);
                currentItem.setNext(item);
                return true;
            }
            if (comparison < 0 && currentItem.next().compareTo(item) > 0) {
                item.setPrevious(currentItem);
                item.setNext(currentItem.next());
                currentItem.next().setPrevious(item);
                currentItem.setNext(item);
                return true;
            } else if (comparison == 0) {
                return false;
            }
            currentItem = currentItem.next();
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        ListItem currentItem = getRoot();
        while (currentItem != null) {
            if (currentItem.compareTo(item) == 0) {
                break;
            }
            currentItem = currentItem.next();
        }
        if (currentItem == null) {
            return false;
        }
        if (currentItem.previous() == null) {
            currentItem.next().setPrevious(null);
            this.root = currentItem.next();
        } else if (currentItem.next() == null) {
            currentItem.previous().setNext(currentItem.next());
        } else {

            currentItem.previous().setNext(currentItem.next());
            currentItem.next().setPrevious(currentItem.previous());
        }

        return true;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
            return;
        }
        ListItem li = root;
        while(li!= null){
            System.out.println(li.value);
            li = li.next();
        }


    }
}
