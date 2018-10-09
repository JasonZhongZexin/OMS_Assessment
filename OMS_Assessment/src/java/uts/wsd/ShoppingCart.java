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
 * @author Zexin Zhong
 */
public class ShoppingCart implements Serializable {

    private ArrayList<Item> shoppingCart;

    public ShoppingCart() {
        this.shoppingCart = new ArrayList<Item>();
    }

    /**
     * This is the setter of the shoppingCart field.
     * @param shoppingCart 
     */
    public void setShoppingCart(ArrayList<Item> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * This is the getter of the shoppingCart field.
     * @return shoppingCart 
     */
    public ArrayList<Item> getShoppingCart() {
        return shoppingCart;
    }

    /**
     * This method will add an item to the shoppingCart list.
     * @param item 
     */
    public void addShoppingCart(Item item) {
        shoppingCart.add(item);
    }
    
    /**
     * This method will check if the shoppingCart list contains the specified item.
     * if any match item, return true else return false.
     * @param item
     * @return 
     */
    public boolean isContainsItem(Item item) {

        for (Item items : shoppingCart) {
            if (items.getMovieTitle().equals(item.getMovieTitle())) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * This method will remove all items that store in shoppingCart list
     */
    public void clearShoppingCart(){
        shoppingCart.clear();
    }
    
    /**
     * This method will return the specified item that match the given title from the
     * shoppingCart item list.
     * @param title 
     */
    public void removeItem(String title){
        int pos = -1;
        for(int i=0;i<shoppingCart.size();i++){
            if(shoppingCart.get(i).getMovieTitle().equals(title))
                pos = i;
        }
        if(pos!=-1){
            shoppingCart.remove(pos);
        }
    }
}
