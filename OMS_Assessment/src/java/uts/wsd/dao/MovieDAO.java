package uts.wsd.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public interface MovieDAO {
     public void updateCopies(int sellCopies);
    public boolean matchTitle(String movie_title);
    public void addCopies(int copies);
     public void minusCopies(int copies);
     public boolean checkAvailable();
}
