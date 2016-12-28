package com.lanashir.entity;

import java.util.List;

/**
 * Created by agosipov on 13.10.2016.
 */
public class Cart {
    private int Id;
    private List<Good> Goods;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    Cart(int Id){
        this.Id = Id;
    }

    public void addGood(Good good){
        Goods.add(good);
    }

    public void removeGood(Good good){
        if(Goods.contains(good)) Goods.remove(good);
    }

    public List<Good> getGoods() {
        return Goods;
    }

    public double checkOut(){
        double Price = 0;
        if(Goods.size()!=0){
            for(Good good: Goods){
                Price += good.getPrice() * ( 1 - good.getDisc() / 100);
            }
        }
        return Price;
    }
}
