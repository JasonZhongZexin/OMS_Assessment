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

    private static OmsApp locator = new OmsApp();
    private static OMSSOAP omsSOAP = locator.getOMSSOAPPort();
    private static User user;
    private static ArrayList<Item> items = new ArrayList<>();

    public static void main(String[] arg) throws Exception_Exception {
        menu();
    }

    private static void menu() throws Exception_Exception {
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
                case '8':
                    placeOrder();
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
        System.out.println("8.Place Order");
        System.out.println("X.Exit the system.");
    }

    private static void logout() throws Exception_Exception {
        user = omsSOAP.logout();
        if (user == null) {
            System.out.println("User has logged out");
        }
        printHelp();
    }

    private static void login() throws Exception_Exception {
        String email = readEmail();
        String password = readPassword();
        user = omsSOAP.login(email, password);
        if (user != null) {
            System.out.println("Welcome, " + user.getFullName() + "! You have successfully logged in.");
            printHelp();
        } else {
            System.out.println("User not found.");
            printHelp();
        }
    }

    private static void getHistory() throws Exception_Exception {
        System.out.println("Order History:");
        for (int i = 0; i < omsSOAP.fetchHistory().size(); i++) {
            System.out.println("Order " + omsSOAP.fetchHistory().get(i).getID());
            System.out.println("customer email: " + omsSOAP.fetchHistory().get(i).getEmail());
            System.out.println("customer name: " + omsSOAP.fetchHistory().get(i).getFullName());
            System.out.println("payment method:" + omsSOAP.fetchHistory().get(i).getPaymentMethod());
            System.out.print("sale total: AU$" + omsSOAP.fetchHistory().get(i).getSaleTotal() + "   ");
            System.out.println("order status: " + omsSOAP.fetchHistory().get(i).getStatus());
            ArrayList<Item> items = (ArrayList<Item>) omsSOAP.fetchHistory().get(i).getOrderItem();
            items.forEach((item) -> {
                System.out.println(item.getMovieTitle() + " " + item.getMovieGenre() + " " + item.getReleaseDate() + " " + item.getCopiesPurchased() + " " + item.getMoviePrice());
            });
            System.out.println("");
        }
        printHelp();
    }

    private static void getHistorybyEmail() throws Exception_Exception {
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
                System.out.println("order status: " + omsSOAP.fetchHistoryByEmail(email).get(i).getStatus());
                ArrayList<Item> items = (ArrayList<Item>) omsSOAP.fetchHistoryByEmail(email).get(i).getOrderItem();
                items.forEach((item) -> {
                    System.out.println(item.getMovieTitle() + " " + item.getMovieGenre() + " " + item.getReleaseDate() + " " + item.getCopiesPurchased() + " " + item.getMoviePrice());
                });
                System.out.println("");
            }
        }
        printHelp();
    }

    private static void getHistorybyStatus() throws Exception_Exception {
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
                System.out.println("order status: " + omsSOAP.fetchHistoryByStatus(status).get(i).getStatus());
                ArrayList<Item> items = (ArrayList<Item>) omsSOAP.fetchHistoryByStatus(status).get(i).getOrderItem();
                items.forEach((item) -> {
                    System.out.println(item.getMovieTitle() + " " + item.getMovieGenre() + " " + item.getReleaseDate() + " " + item.getCopiesPurchased() + " " + item.getMoviePrice());
                });
                System.out.println("");
            }
        }
        printHelp();
    }

    private static void getHistorybyTitle() throws Exception_Exception {
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
                System.out.println("order status: " + omsSOAP.fetchHistoryByTitle(title).get(i).getStatus());
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
            System.out.println("order status: " + order.getStatus());
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

    private static String readCopies() {
        System.out.print("Enter the copies to purchase: ");
        return In.nextLine();
    }

    private static void placeOrderMenuHelper() {
        System.out.println("1.Add an item");
        System.out.println("2.Place order");
        System.out.println("R.Return to previous menu");
    }

    private static String readPaymentMethod() {
        System.out.print("Enter an payment method(payment method could be only Credit Card or PayPal): ");
        return In.nextLine();
    }

    /**
     * This method ask user to input a movie title. Then search movie by title.
     * if movie are found add to the order items list. Otherwise, print out the
     * error message.
     *
     * @throws Exception_Exception
     */
    private static void AddItem() throws Exception_Exception {
        String title = readMovieTitle();
        Movie movie = omsSOAP.findMovieByTitle(title);
        if (movie == null) {
            System.out.println("Movie " + title + " not found.");
            placeOrderMenuHelper();
        } else {
            int copies = Integer.parseInt(readCopies());
            Item item = new Item();
            item.setCopiesPurchased(copies);
            item.setMovieGenre(movie.getGenre());
            item.setMoviePrice(movie.getPrice());
            item.setMovieTitle(title);
            item.setReleaseDate(movie.getRelaseDate());
            items.add(item);
            System.out.println(title+" has been add successfully.");
            placeOrderMenuHelper();
        }
    }

    /**
     * This method will check if user already add at least item into the order
     * item list and place the order. if user already add at least 1 item, check
     * out the item and place an order. otherwise, print out an error message.
     */
    private static void checkoutOrder() throws Exception_Exception {
        if (items.size() > 0) {
            String paymentMethod = "";
            String input="";
            while(!input.equals("Credit Card")&&!input.equals("PayPal")){
                input = readPaymentMethod();
            }
            paymentMethod = input;
            omsSOAP.updateCopies(items);
            omsSOAP.placeOrder(user, items, paymentMethod);
            items.clear();
            placeOrderMenuHelper();
        } else {
            System.out.println("You have not add any items. Pleas add at least 1 item before placing an order.");
            placeOrderMenuHelper();
        }
    }

    private static void placeOrder() throws Exception_Exception {
        while (user == null) {
            System.out.println("You have to login for placing an order.");
            System.out.println("User not found.");
            String email = readEmail();
            String password = readPassword();
            user = omsSOAP.login(email, password);
        }
        placeOrderMenu();
    }

    private static void placeOrderMenu() throws Exception_Exception {
        placeOrderMenuHelper();
        char choice;
        while ((choice = readChoice()) != 'R') {
            switch (choice) {
                case '1':
                    AddItem();
                    break;
                case '2':
                    checkoutOrder();
                    break;
                case 'R':
                    menu();
                    break;
            }
        }
        if(choice == 'R'){
            printHelp();
        }
    }
}
