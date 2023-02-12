import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by dev on 17/02/2016.
 */
public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new HashMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            if (item.reserve(quantity)) {
                list.put(item, inBasket + quantity);
                inBasket += quantity;
            }
            return inBasket;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            if (inBasket > 0 && item.unreserve(quantity)) {
                if(inBasket == quantity){
                    list.remove(item);
                    return 0;
                }
                list.put(item, inBasket - quantity);
                inBasket -= quantity;

            }
            return inBasket;
        }
        return 0;
    }

    public void checkout() {
        System.out.println("Checkout:");
        int total = 0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            item.getKey().checkoutItem(item.getValue());
            System.out.println("item " + item.getKey() + ". quantity: " + item.getValue() + " purchased");
            total += item.getValue();
        }
        System.out.println("Total value: " + total);
        list.clear();
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() + ((list.size() == 1) ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}
