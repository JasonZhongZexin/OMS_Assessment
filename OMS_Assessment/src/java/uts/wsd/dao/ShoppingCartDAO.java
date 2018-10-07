/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.dao;

import uts.wsd.Item;

/**
 *
 * @author User
 */
public interface ShoppingCartDAO {
    public void addShoppingCart(Item item);
    public boolean isContainsItem(Item item);
    public void clearShoppingCart();
    public void removeItem(String title);
}
