package com.hoffenkloffen.lonewolf.models.items;

public class GoldCrowns extends Item {

    private int quantity;

    public GoldCrowns(int quantity) {
        super("");

        setQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        setName(getName(quantity));
    }

    private static String getName(int quantity) {
        return quantity + " Gold Crowns";
    }
}
