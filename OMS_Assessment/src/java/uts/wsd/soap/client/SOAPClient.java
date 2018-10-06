/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.soap.client;

import java.util.ArrayList;

/**
 *
 * @author zhongzexin
 */
public class SOAPClient {

    static OmsApp locator = new OmsApp();
    static OMSSOAP omsSOAP = locator.getOMSSOAPPort();

    public static void main(String[] arg) throws Exception_Exception {
//        String email = "js123@gmail.com";
//        String password = "smith987";
//        User user = omsSOAP.login(email, password);
//        if (user != null) {
//            System.out.println(user.getFullName());
//        }
        menu();
    }

    public static void menu() throws Exception_Exception {
        printHelp();
        char choice;
        while ((choice = readChoice()) != 'X') {
            switch (choice) {
                case '1':
                    login();
                    break;
                case '2':
                    logout();
                    break;
                case '3':
                    getHistory();
                    break;
                case '4':
                    getOrderByID();
                    break;
                case '5':
                    getHistorybyEmail();
                    break;
                case '6':
                    getHistorybyTitle();
                    break;
                case '7':
                    getHistorybyStatus();
                    break;
                default:
                    invalidInput();
                    break;
            }
        }
    }

    private static void printHelp() {
        System.out.println("Welcome to OMS! Please make a selection from the menu:");
        System.out.println("1.Login");
        System.out.println("2.Logout");
        System.out.println("3.Get history");
        System.out.println("4.Search order by order ID");
        System.out.println("5.Search order by email");
        System.out.println("6.Search order by movie title");
        System.out.println("7.Search order by order status");
        System.out.println("X.Exit the system.");
    }

    private static void logout() throws Exception_Exception {
        System.out.println(omsSOAP.logout());
        printHelp();
    }

    private static void login() throws Exception_Exception {
        String email = readEmail();
        String password = readPassword();
        User user = omsSOAP.login(email, password);
        if (user != null) {
            System.out.println("Welcome, " + user.getFullName() + "! You have successfully logged in.");
            printHelp();
        } else {
            System.out.println("User not found.");
            printHelp();
        }
    }

    public static void getHistory() throws Exception_Exception {
        System.out.println("Order History:");
        for (int i = 0; i < omsSOAP.fetchHistory().size(); i++) {
            System.out.println("Order " + omsSOAP.fetchHistory().get(i).getID());
            System.out.println("customer email: " + omsSOAP.fetchHistory().get(i).getEmail());
            System.out.println("customer name: " + omsSOAP.fetchHistory().get(i).getFullName());
            System.out.println("payment method:" + omsSOAP.fetchHistory().get(i).getPaymentMethod());
            System.out.print("sale total: AU$" + omsSOAP.fetchHistory().get(i).getSaleTotal() + "   ");
            System.out.println("order status: " + omsSOAP.fetchHistory().get(i).getSaleTotal());
            ArrayList<Item> items = (ArrayList<Item>) omsSOAP.fetchHistory().get(i).getOrderItem();
            items.forEach((item) -> {
                System.out.println(item.getMovieTitle() + " " + item.getMovieGenre() + " " + item.getReleaseDate() + " " + item.getCopiesPurchased() + " " + item.getMoviePrice());
            });
            System.out.println("");
        }
        printHelp();
    }

    public static void getHistorybyEmail() throws Exception_Exception {
        String email = readEmail();
        if (omsSOAP.fetchHistoryByEmail(email).size() < 1) {
            System.out.println(email + " do not have any order.");
        } else {
            System.out.println(email + " has the following order:");
            for (int i = 0; i < omsSOAP.fetchHistoryByEmail(email).size(); i++) {
                System.out.println("Order " + omsSOAP.fetchHistoryByEmail(email).get(i).getID());
                System.out.println("customer email: " + omsSOAP.fetchHistoryByEmail(email).get(i).getEmail());
                System.out.println("customer name: " + omsSOAP.fetchHistoryByEmail(email).get(i).getFullName());
                System.out.println("payment method:" + omsSOAP.fetchHistoryByEmail(email).get(i).getPaymentMethod());
                System.out.print("sale total: AU$" + omsSOAP.fetchHistoryByEmail(email).get(i).getSaleTotal() + "   ");
                System.out.println("order status: " + omsSOAP.fetchHistoryByEmail(email).get(i).getSaleTotal());
                ArrayList<Item> items = (ArrayList<Item>) omsSOAP.fetchHistoryByEmail(email).get(i).getOrderItem();
                items.forEach((item) -> {
                    System.out.println(item.getMovieTitle() + " " + item.getMovieGenre() + " " + item.getReleaseDate() + " " + item.getCopiesPurchased() + " " + item.getMoviePrice());
                });
                System.out.println("");
            }
        }
        printHelp();
    }

    public static void getHistorybyStatus() throws Exception_Exception {
        String status = readOrderStatus();
        if (omsSOAP.fetchHistoryByStatus(status).size() < 1) {
            System.out.println("Cannot find any " + status + " order.");
        } else {
            System.out.println("Find following " + status + " order:");
            for (int i = 0; i < omsSOAP.fetchHistoryByStatus(status).size(); i++) {
                System.out.println("Order " + omsSOAP.fetchHistoryByStatus(status).get(i).getID());
                System.out.println("customer email: " + omsSOAP.fetchHistoryByStatus(status).get(i).getEmail());
                System.out.println("customer name: " + omsSOAP.fetchHistoryByStatus(status).get(i).getFullName());
                System.out.println("payment method:" + omsSOAP.fetchHistoryByStatus(status).get(i).getPaymentMethod());
                System.out.print("sale total: AU$" + omsSOAP.fetchHistoryByStatus(status).get(i).getSaleTotal() + "   ");
                System.out.println("order status: " + omsSOAP.fetchHistoryByStatus(status).get(i).getSaleTotal());
                ArrayList<Item> items = (ArrayList<Item>) omsSOAP.fetchHistoryByStatus(status).get(i).getOrderItem();
                items.forEach((item) -> {
                    System.out.println(item.getMovieTitle() + " " + item.getMovieGenre() + " " + item.getReleaseDate() + " " + item.getCopiesPurchased() + " " + item.getMoviePrice());
                });
                System.out.println("");
            }
        }
        printHelp();
    }

    public static void getHistorybyTitle() throws Exception_Exception {
        String title = readMovieTitle();
        if (omsSOAP.fetchHistoryByTitle(title).size() < 1) {
            System.out.println(title + " do not have any order.");
        } else {
            System.out.println(title + " has the following order:");
            for (int i = 0; i < omsSOAP.fetchHistoryByTitle(title).size(); i++) {
                System.out.println("Order " + omsSOAP.fetchHistoryByTitle(title).get(i).getID());
                System.out.println("customer email: " + omsSOAP.fetchHistoryByTitle(title).get(i).getEmail());
                System.out.println("customer name: " + omsSOAP.fetchHistoryByTitle(title).get(i).getFullName());
                System.out.println("payment method:" + omsSOAP.fetchHistoryByTitle(title).get(i).getPaymentMethod());
                System.out.print("sale total: AU$" + omsSOAP.fetchHistoryByTitle(title).get(i).getSaleTotal() + "   ");
                System.out.println("order status: " + omsSOAP.fetchHistoryByTitle(title).get(i).getSaleTotal());
                ArrayList<Item> items = (ArrayList<Item>) omsSOAP.fetchHistoryByTitle(title).get(i).getOrderItem();
                items.forEach((item) -> {
                    System.out.println(item.getMovieTitle() + " " + item.getMovieGenre() + " " + item.getReleaseDate() + " " + item.getCopiesPurchased() + " " + item.getMoviePrice());
                });
                System.out.println("");
            }
        }
        printHelp();
    }

    private static void getOrderByID() throws Exception_Exception {
        String ID = readOrderID();
        Order order = omsSOAP.fetchHistoryByOrderID(ID);
        if (order.getEmail() != null) {
            System.out.println("Order " + order.getID());
            System.out.println("customer email: " + order.getEmail());
            System.out.println("customer name: " + order.getFullName());
            System.out.println("payment method:" + order.getPaymentMethod());
            System.out.print("sale total: AU$" + order.getSaleTotal() + "   ");
            System.out.println("order status: " + order.getSaleTotal());
            ArrayList<Item> items = (ArrayList<Item>) order.getOrderItem();
            items.forEach((item) -> {
                System.out.println(item.getMovieTitle() + " " + item.getMovieGenre() + " " + item.getReleaseDate() + " " + item.getCopiesPurchased() + " " + item.getMoviePrice());
            });
            System.out.println("");
        } else {
            System.out.println("Order " + ID + " not found");
        }
        printHelp();
    }

    private static void invalidInput() {
        System.out.println("Please enter a number between 1 and 7 or press X to exit.");
    }

    private static char readChoice() {
        System.out.print("Enter a choice: ");
        return In.nextChar();
    }

    private static String readEmail() {
        System.out.print("Enter an email: ");
        return In.nextLine();
    }

    private static String readPassword() {
        System.out.print("Enter a password: ");
        return In.nextLine();
    }

    private static String readOrderID() {
        System.out.print("Enter a 3 digital Order ID: ");
        return In.nextLine();
    }

    private static String readMovieTitle() {
        System.out.print("Enter a movie title: ");
        return In.nextLine();
    }

    private static String readOrderStatus() {
        System.out.print("Enter an order status: ");
        return In.nextLine();
    }
}
