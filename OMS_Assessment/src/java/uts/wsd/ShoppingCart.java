/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;

import java.io.Serializable;
import java.util.ArrayList;
import uts.wsd.dao.ShoppingCartDAO;

/**
 *
 * @author zhongzexin
 */
public class ShoppingCart implements Serializable,ShoppingCartDAO {

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

    @Override
    public void addShoppingCart(Item item) {
        shoppingCart.add(item);
    }
    
    @Override
    public boolean isContainsItem(Item item) {

        for (Item items : shoppingCart) {
            if (items.getMovieTitle().equals(item.getMovieTitle())) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void clearShoppingCart(){
        shoppingCart.clear();
    }
    
    @Override
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
