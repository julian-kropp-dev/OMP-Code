package Uebungsaufgaben.Uebung05.A2.Bill;

import java.util.LinkedList;
import java.util.List;

public final class Bill {
    private LinkedList<BillItem> items = new LinkedList();

    public LinkedList<BillItem> getItems() {
        return items;
    }

    public void setItems(LinkedList<BillItem> items) {
        this.items = items;
    }

    public double getTotalPrice() {

    }

    public String toString() {
        double total = 0;
        for (BillItem item : items) {
            System.out.println(item.getName() + " kostet " + item.getPrice() + " €");
            total += item.getPrice();
        }
        return "Zusammen macht das: " + total;

    }

    private class BillItem {
        public double getPrice() {

        }

        public String toString() {

        }
    }
}
