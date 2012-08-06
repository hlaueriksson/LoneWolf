package com.hoffenkloffen.lonewolf.core.items;

public class GoldCrowns extends Item {

    private int quantity;

    public GoldCrowns(int quantity) {
        super("");

        setQuantity(quantity);
    }

    public GoldCrowns(String name, String description) {
        super(name, description);
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + quantity;
    }
}
