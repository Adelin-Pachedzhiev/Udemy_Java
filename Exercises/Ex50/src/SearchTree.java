
public class SearchTree implements NodeList {
    private ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem item) {
        ListItem currItem = getRoot();
        ListItem prevItem = currItem;
        while (currItem != null) {
            prevItem = currItem;
            if (currItem.compareTo(item) > 0) {
                currItem = currItem.previous();
            } else if (currItem.compareTo(item) < 0) {
                currItem = currItem.next();
            } else {
                return false;
            }
        }
        if (prevItem.compareTo(item) > 0){
            prevItem.setPrevious(item);
        } else {
            prevItem.setNext(item);
        }
        return true;
    }

    @Override
    public boolean removeItem(ListItem item) {
        ListItem currItem = getRoot();
        ListItem parent = currItem;
        while(currItem != null){

            if (currItem.compareTo(item) > 0) {
                parent = currItem;
                currItem = currItem.previous();
            } else if(currItem.compareTo(item) < 0){
                parent = currItem;
                currItem = currItem.next();
            } else{
                performRemoval(currItem, parent);
                return true;
            }
        }
        return false;
    }

    private void performRemoval(ListItem item, ListItem parent){
        if(parent.next() != null && parent.next().compareTo(item) == 0){
            if(item.next() == null){
                parent.setNext(item.previous());
                return;
            } else if(item.previous() == null){
                parent.setNext(item.next());
                return;
            }
        } else {
            if(item.next() == null){
                parent.setPrevious(item.previous());
                return;
            } else if(item.previous() == null){
                parent.setPrevious(item.next());
                return;
            }
        }
        ListItem currItem = item.next();
        ListItem prevItem = item;
        while(currItem != null && currItem.previous() != null){
            prevItem = currItem;
            currItem = currItem.previous();
        }
        item.setValue(currItem.getValue());

        if(prevItem == item){
            item.setNext(currItem.next());
        } else{
            prevItem.setPrevious(currItem.next());
        }
    }

    @Override
    public void traverse(ListItem root) {

        if(root== null){
            return;
        }
        traverse(root.previous());
        System.out.println(root.value);
        traverse(root.next());
    }
}
