package com.lanashir.entity;

/**
 * Created by agosipov on 13.10.2016.
 */
public class Good {
    private int Id;
    private double Price;
    private int Disc;
    private int Count;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getDisc() {
        return Disc;
    }

    public void setDisc(int disc) {
        Disc = disc;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

}
