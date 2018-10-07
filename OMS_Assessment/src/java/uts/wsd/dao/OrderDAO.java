/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.dao;

/**
 *
 * @author User
 */
public interface OrderDAO {
    public boolean matchID(String ID);
    public boolean matchEmail(String email);
    public boolean verifyStatus();
     public boolean isContainsItem(String title);
     public boolean isMatchStatus(String status);
}
