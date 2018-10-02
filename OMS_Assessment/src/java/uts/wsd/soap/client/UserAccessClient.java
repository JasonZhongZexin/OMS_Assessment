/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.soap.client;

/**
 *
 * @author zhongzexin
 */
public class UserAccessClient {
    public static void main (String[] args) throws Exception_Exception{
        UserApp locater = new UserApp();
        UserAccessSOAP userSOAP = locater.getUserAccessSOAPPort();
//        String email ="hashbrown@gmail.com";
//        String password ="tomato";
//        User user = userSOAP.loginUser(email,password);
//        if(user!=null){
//            System.out.println(user.getAddress());
//        }
    }
    
}
