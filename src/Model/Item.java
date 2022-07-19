package Model;

public class Item {
    private Integer idItem;
    private Integer countItem;

    public Item(Integer idItem, Integer countItem){
        this.idItem = idItem;
        this.countItem = countItem;
    }
    public String ToString(){
        return "id" + idItem + " : " + countItem;
    }
}
