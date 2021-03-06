
package uts.wsd.soap.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the uts.wsd.soap.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CancelAccount_QNAME = new QName("http://soap.wsd.uts/", "CancelAccount");
    private final static QName _CancelAccountResponse_QNAME = new QName("http://soap.wsd.uts/", "CancelAccountResponse");
    private final static QName _CancelOrder_QNAME = new QName("http://soap.wsd.uts/", "CancelOrder");
    private final static QName _CancelOrderResponse_QNAME = new QName("http://soap.wsd.uts/", "CancelOrderResponse");
    private final static QName _Exception_QNAME = new QName("http://soap.wsd.uts/", "Exception");
    private final static QName _FetchHistory_QNAME = new QName("http://soap.wsd.uts/", "fetchHistory");
    private final static QName _FetchHistoryByEmail_QNAME = new QName("http://soap.wsd.uts/", "fetchHistoryByEmail");
    private final static QName _FetchHistoryByEmailResponse_QNAME = new QName("http://soap.wsd.uts/", "fetchHistoryByEmailResponse");
    private final static QName _FetchHistoryByOrderID_QNAME = new QName("http://soap.wsd.uts/", "fetchHistoryByOrderID");
    private final static QName _FetchHistoryByOrderIDResponse_QNAME = new QName("http://soap.wsd.uts/", "fetchHistoryByOrderIDResponse");
    private final static QName _FetchHistoryByStatus_QNAME = new QName("http://soap.wsd.uts/", "fetchHistoryByStatus");
    private final static QName _FetchHistoryByStatusResponse_QNAME = new QName("http://soap.wsd.uts/", "fetchHistoryByStatusResponse");
    private final static QName _FetchHistoryByTitle_QNAME = new QName("http://soap.wsd.uts/", "fetchHistoryByTitle");
    private final static QName _FetchHistoryByTitleResponse_QNAME = new QName("http://soap.wsd.uts/", "fetchHistoryByTitleResponse");
    private final static QName _FetchHistoryResponse_QNAME = new QName("http://soap.wsd.uts/", "fetchHistoryResponse");
    private final static QName _FindMovieByTitle_QNAME = new QName("http://soap.wsd.uts/", "findMovieByTitle");
    private final static QName _FindMovieByTitleResponse_QNAME = new QName("http://soap.wsd.uts/", "findMovieByTitleResponse");
    private final static QName _Login_QNAME = new QName("http://soap.wsd.uts/", "login");
    private final static QName _LoginResponse_QNAME = new QName("http://soap.wsd.uts/", "loginResponse");
    private final static QName _Logout_QNAME = new QName("http://soap.wsd.uts/", "logout");
    private final static QName _LogoutResponse_QNAME = new QName("http://soap.wsd.uts/", "logoutResponse");
    private final static QName _Movie_QNAME = new QName("http://soap.wsd.uts/", "movie");
    private final static QName _Order_QNAME = new QName("http://soap.wsd.uts/", "order");
    private final static QName _OrderItem_QNAME = new QName("http://soap.wsd.uts/", "orderItem");
    private final static QName _PlaceOrder_QNAME = new QName("http://soap.wsd.uts/", "placeOrder");
    private final static QName _PlaceOrderResponse_QNAME = new QName("http://soap.wsd.uts/", "placeOrderResponse");
    private final static QName _UpdateCopies_QNAME = new QName("http://soap.wsd.uts/", "updateCopies");
    private final static QName _UpdateCopiesResponse_QNAME = new QName("http://soap.wsd.uts/", "updateCopiesResponse");
    private final static QName _User_QNAME = new QName("http://soap.wsd.uts/", "user");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: uts.wsd.soap.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CancelAccount }
     * 
     */
    public CancelAccount createCancelAccount() {
        return new CancelAccount();
    }

    /**
     * Create an instance of {@link CancelAccountResponse }
     * 
     */
    public CancelAccountResponse createCancelAccountResponse() {
        return new CancelAccountResponse();
    }

    /**
     * Create an instance of {@link CancelOrder }
     * 
     */
    public CancelOrder createCancelOrder() {
        return new CancelOrder();
    }

    /**
     * Create an instance of {@link CancelOrderResponse }
     * 
     */
    public CancelOrderResponse createCancelOrderResponse() {
        return new CancelOrderResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link FetchHistory }
     * 
     */
    public FetchHistory createFetchHistory() {
        return new FetchHistory();
    }

    /**
     * Create an instance of {@link FetchHistoryByEmail }
     * 
     */
    public FetchHistoryByEmail createFetchHistoryByEmail() {
        return new FetchHistoryByEmail();
    }

    /**
     * Create an instance of {@link FetchHistoryByEmailResponse }
     * 
     */
    public FetchHistoryByEmailResponse createFetchHistoryByEmailResponse() {
        return new FetchHistoryByEmailResponse();
    }

    /**
     * Create an instance of {@link FetchHistoryByOrderID }
     * 
     */
    public FetchHistoryByOrderID createFetchHistoryByOrderID() {
        return new FetchHistoryByOrderID();
    }

    /**
     * Create an instance of {@link FetchHistoryByOrderIDResponse }
     * 
     */
    public FetchHistoryByOrderIDResponse createFetchHistoryByOrderIDResponse() {
        return new FetchHistoryByOrderIDResponse();
    }

    /**
     * Create an instance of {@link FetchHistoryByStatus }
     * 
     */
    public FetchHistoryByStatus createFetchHistoryByStatus() {
        return new FetchHistoryByStatus();
    }

    /**
     * Create an instance of {@link FetchHistoryByStatusResponse }
     * 
     */
    public FetchHistoryByStatusResponse createFetchHistoryByStatusResponse() {
        return new FetchHistoryByStatusResponse();
    }

    /**
     * Create an instance of {@link FetchHistoryByTitle }
     * 
     */
    public FetchHistoryByTitle createFetchHistoryByTitle() {
        return new FetchHistoryByTitle();
    }

    /**
     * Create an instance of {@link FetchHistoryByTitleResponse }
     * 
     */
    public FetchHistoryByTitleResponse createFetchHistoryByTitleResponse() {
        return new FetchHistoryByTitleResponse();
    }

    /**
     * Create an instance of {@link FetchHistoryResponse }
     * 
     */
    public FetchHistoryResponse createFetchHistoryResponse() {
        return new FetchHistoryResponse();
    }

    /**
     * Create an instance of {@link FindMovieByTitle }
     * 
     */
    public FindMovieByTitle createFindMovieByTitle() {
        return new FindMovieByTitle();
    }

    /**
     * Create an instance of {@link FindMovieByTitleResponse }
     * 
     */
    public FindMovieByTitleResponse createFindMovieByTitleResponse() {
        return new FindMovieByTitleResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link Logout }
     * 
     */
    public Logout createLogout() {
        return new Logout();
    }

    /**
     * Create an instance of {@link LogoutResponse }
     * 
     */
    public LogoutResponse createLogoutResponse() {
        return new LogoutResponse();
    }

    /**
     * Create an instance of {@link Movie }
     * 
     */
    public Movie createMovie() {
        return new Movie();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link PlaceOrder }
     * 
     */
    public PlaceOrder createPlaceOrder() {
        return new PlaceOrder();
    }

    /**
     * Create an instance of {@link PlaceOrderResponse }
     * 
     */
    public PlaceOrderResponse createPlaceOrderResponse() {
        return new PlaceOrderResponse();
    }

    /**
     * Create an instance of {@link UpdateCopies }
     * 
     */
    public UpdateCopies createUpdateCopies() {
        return new UpdateCopies();
    }

    /**
     * Create an instance of {@link UpdateCopiesResponse }
     * 
     */
    public UpdateCopiesResponse createUpdateCopiesResponse() {
        return new UpdateCopiesResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "CancelAccount")
    public JAXBElement<CancelAccount> createCancelAccount(CancelAccount value) {
        return new JAXBElement<CancelAccount>(_CancelAccount_QNAME, CancelAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "CancelAccountResponse")
    public JAXBElement<CancelAccountResponse> createCancelAccountResponse(CancelAccountResponse value) {
        return new JAXBElement<CancelAccountResponse>(_CancelAccountResponse_QNAME, CancelAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "CancelOrder")
    public JAXBElement<CancelOrder> createCancelOrder(CancelOrder value) {
        return new JAXBElement<CancelOrder>(_CancelOrder_QNAME, CancelOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "CancelOrderResponse")
    public JAXBElement<CancelOrderResponse> createCancelOrderResponse(CancelOrderResponse value) {
        return new JAXBElement<CancelOrderResponse>(_CancelOrderResponse_QNAME, CancelOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchHistory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "fetchHistory")
    public JAXBElement<FetchHistory> createFetchHistory(FetchHistory value) {
        return new JAXBElement<FetchHistory>(_FetchHistory_QNAME, FetchHistory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchHistoryByEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "fetchHistoryByEmail")
    public JAXBElement<FetchHistoryByEmail> createFetchHistoryByEmail(FetchHistoryByEmail value) {
        return new JAXBElement<FetchHistoryByEmail>(_FetchHistoryByEmail_QNAME, FetchHistoryByEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchHistoryByEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "fetchHistoryByEmailResponse")
    public JAXBElement<FetchHistoryByEmailResponse> createFetchHistoryByEmailResponse(FetchHistoryByEmailResponse value) {
        return new JAXBElement<FetchHistoryByEmailResponse>(_FetchHistoryByEmailResponse_QNAME, FetchHistoryByEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchHistoryByOrderID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "fetchHistoryByOrderID")
    public JAXBElement<FetchHistoryByOrderID> createFetchHistoryByOrderID(FetchHistoryByOrderID value) {
        return new JAXBElement<FetchHistoryByOrderID>(_FetchHistoryByOrderID_QNAME, FetchHistoryByOrderID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchHistoryByOrderIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "fetchHistoryByOrderIDResponse")
    public JAXBElement<FetchHistoryByOrderIDResponse> createFetchHistoryByOrderIDResponse(FetchHistoryByOrderIDResponse value) {
        return new JAXBElement<FetchHistoryByOrderIDResponse>(_FetchHistoryByOrderIDResponse_QNAME, FetchHistoryByOrderIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchHistoryByStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "fetchHistoryByStatus")
    public JAXBElement<FetchHistoryByStatus> createFetchHistoryByStatus(FetchHistoryByStatus value) {
        return new JAXBElement<FetchHistoryByStatus>(_FetchHistoryByStatus_QNAME, FetchHistoryByStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchHistoryByStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "fetchHistoryByStatusResponse")
    public JAXBElement<FetchHistoryByStatusResponse> createFetchHistoryByStatusResponse(FetchHistoryByStatusResponse value) {
        return new JAXBElement<FetchHistoryByStatusResponse>(_FetchHistoryByStatusResponse_QNAME, FetchHistoryByStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchHistoryByTitle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "fetchHistoryByTitle")
    public JAXBElement<FetchHistoryByTitle> createFetchHistoryByTitle(FetchHistoryByTitle value) {
        return new JAXBElement<FetchHistoryByTitle>(_FetchHistoryByTitle_QNAME, FetchHistoryByTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchHistoryByTitleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "fetchHistoryByTitleResponse")
    public JAXBElement<FetchHistoryByTitleResponse> createFetchHistoryByTitleResponse(FetchHistoryByTitleResponse value) {
        return new JAXBElement<FetchHistoryByTitleResponse>(_FetchHistoryByTitleResponse_QNAME, FetchHistoryByTitleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchHistoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "fetchHistoryResponse")
    public JAXBElement<FetchHistoryResponse> createFetchHistoryResponse(FetchHistoryResponse value) {
        return new JAXBElement<FetchHistoryResponse>(_FetchHistoryResponse_QNAME, FetchHistoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMovieByTitle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "findMovieByTitle")
    public JAXBElement<FindMovieByTitle> createFindMovieByTitle(FindMovieByTitle value) {
        return new JAXBElement<FindMovieByTitle>(_FindMovieByTitle_QNAME, FindMovieByTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMovieByTitleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "findMovieByTitleResponse")
    public JAXBElement<FindMovieByTitleResponse> createFindMovieByTitleResponse(FindMovieByTitleResponse value) {
        return new JAXBElement<FindMovieByTitleResponse>(_FindMovieByTitleResponse_QNAME, FindMovieByTitleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "logout")
    public JAXBElement<Logout> createLogout(Logout value) {
        return new JAXBElement<Logout>(_Logout_QNAME, Logout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "logoutResponse")
    public JAXBElement<LogoutResponse> createLogoutResponse(LogoutResponse value) {
        return new JAXBElement<LogoutResponse>(_LogoutResponse_QNAME, LogoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Movie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "movie")
    public JAXBElement<Movie> createMovie(Movie value) {
        return new JAXBElement<Movie>(_Movie_QNAME, Movie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Order }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "order")
    public JAXBElement<Order> createOrder(Order value) {
        return new JAXBElement<Order>(_Order_QNAME, Order.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Item }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "orderItem")
    public JAXBElement<Item> createOrderItem(Item value) {
        return new JAXBElement<Item>(_OrderItem_QNAME, Item.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "placeOrder")
    public JAXBElement<PlaceOrder> createPlaceOrder(PlaceOrder value) {
        return new JAXBElement<PlaceOrder>(_PlaceOrder_QNAME, PlaceOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "placeOrderResponse")
    public JAXBElement<PlaceOrderResponse> createPlaceOrderResponse(PlaceOrderResponse value) {
        return new JAXBElement<PlaceOrderResponse>(_PlaceOrderResponse_QNAME, PlaceOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCopies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "updateCopies")
    public JAXBElement<UpdateCopies> createUpdateCopies(UpdateCopies value) {
        return new JAXBElement<UpdateCopies>(_UpdateCopies_QNAME, UpdateCopies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCopiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "updateCopiesResponse")
    public JAXBElement<UpdateCopiesResponse> createUpdateCopiesResponse(UpdateCopiesResponse value) {
        return new JAXBElement<UpdateCopiesResponse>(_UpdateCopiesResponse_QNAME, UpdateCopiesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "user")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

}
