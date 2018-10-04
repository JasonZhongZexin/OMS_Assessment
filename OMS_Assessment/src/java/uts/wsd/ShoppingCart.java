/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author zhongzexin
 */
public class ShoppingCart implements Serializable {

    private ArrayList<Item> shoppingCart;

    public ShoppingCart() {
        this.shoppingCart = new ArrayList<Item>();
    }

    public void setShoppingCart(ArrayList<Item> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ArrayList<Item> getShoppingCart() {
        return shoppingCart;
    }

    public void addShoppingCart(Item item) {
        shoppingCart.add(item);
    }
    
    public boolean isContainsItem(Item item) {

        for (Item items : shoppingCart) {
            if (items.getMovieTitle().equals(item.getMovieTitle())) {
                return true;
            }
        }
        return false;
    }
    
    public void clearShoppingCart(){
        shoppingCart.clear();
    }
}
