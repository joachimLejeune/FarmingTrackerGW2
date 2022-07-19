package Model;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory(){
        this.items = new ArrayList<>();
    }
    public void AddItem(Item item){
        this.items.add(item);
    }
    public Item GetItem(Integer pos){
        return items.get(pos);
    }
    public boolean IsEmpty(){
        return items.isEmpty();
    }
}
