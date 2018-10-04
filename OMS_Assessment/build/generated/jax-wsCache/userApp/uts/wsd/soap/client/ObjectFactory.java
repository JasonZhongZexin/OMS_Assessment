
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

    private final static QName _Exception_QNAME = new QName("http://soap.wsd.uts/", "Exception");
    private final static QName _GetHistory_QNAME = new QName("http://soap.wsd.uts/", "getHistory");
    private final static QName _GetHistoryByEmail_QNAME = new QName("http://soap.wsd.uts/", "getHistoryByEmail");
    private final static QName _GetHistoryByEmailResponse_QNAME = new QName("http://soap.wsd.uts/", "getHistoryByEmailResponse");
    private final static QName _GetHistoryByOrderID_QNAME = new QName("http://soap.wsd.uts/", "getHistoryByOrderID");
    private final static QName _GetHistoryByOrderIDResponse_QNAME = new QName("http://soap.wsd.uts/", "getHistoryByOrderIDResponse");
    private final static QName _GetHistoryByStatus_QNAME = new QName("http://soap.wsd.uts/", "getHistoryByStatus");
    private final static QName _GetHistoryByStatusResponse_QNAME = new QName("http://soap.wsd.uts/", "getHistoryByStatusResponse");
    private final static QName _GetHistoryByTitle_QNAME = new QName("http://soap.wsd.uts/", "getHistoryByTitle");
    private final static QName _GetHistoryByTitleResponse_QNAME = new QName("http://soap.wsd.uts/", "getHistoryByTitleResponse");
    private final static QName _GetHistoryResponse_QNAME = new QName("http://soap.wsd.uts/", "getHistoryResponse");
    private final static QName _LoginUser_QNAME = new QName("http://soap.wsd.uts/", "loginUser");
    private final static QName _LoginUserResponse_QNAME = new QName("http://soap.wsd.uts/", "loginUserResponse");
    private final static QName _LogoutUser_QNAME = new QName("http://soap.wsd.uts/", "logoutUser");
    private final static QName _LogoutUserResponse_QNAME = new QName("http://soap.wsd.uts/", "logoutUserResponse");
    private final static QName _Order_QNAME = new QName("http://soap.wsd.uts/", "order");
    private final static QName _OrderItem_QNAME = new QName("http://soap.wsd.uts/", "orderItem");
    private final static QName _User_QNAME = new QName("http://soap.wsd.uts/", "user");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: uts.wsd.soap.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link GetHistory }
     * 
     */
    public GetHistory createGetHistory() {
        return new GetHistory();
    }

    /**
     * Create an instance of {@link GetHistoryByEmail }
     * 
     */
    public GetHistoryByEmail createGetHistoryByEmail() {
        return new GetHistoryByEmail();
    }

    /**
     * Create an instance of {@link GetHistoryByEmailResponse }
     * 
     */
    public GetHistoryByEmailResponse createGetHistoryByEmailResponse() {
        return new GetHistoryByEmailResponse();
    }

    /**
     * Create an instance of {@link GetHistoryByOrderID }
     * 
     */
    public GetHistoryByOrderID createGetHistoryByOrderID() {
        return new GetHistoryByOrderID();
    }

    /**
     * Create an instance of {@link GetHistoryByOrderIDResponse }
     * 
     */
    public GetHistoryByOrderIDResponse createGetHistoryByOrderIDResponse() {
        return new GetHistoryByOrderIDResponse();
    }

    /**
     * Create an instance of {@link GetHistoryByStatus }
     * 
     */
    public GetHistoryByStatus createGetHistoryByStatus() {
        return new GetHistoryByStatus();
    }

    /**
     * Create an instance of {@link GetHistoryByStatusResponse }
     * 
     */
    public GetHistoryByStatusResponse createGetHistoryByStatusResponse() {
        return new GetHistoryByStatusResponse();
    }

    /**
     * Create an instance of {@link GetHistoryByTitle }
     * 
     */
    public GetHistoryByTitle createGetHistoryByTitle() {
        return new GetHistoryByTitle();
    }

    /**
     * Create an instance of {@link GetHistoryByTitleResponse }
     * 
     */
    public GetHistoryByTitleResponse createGetHistoryByTitleResponse() {
        return new GetHistoryByTitleResponse();
    }

    /**
     * Create an instance of {@link GetHistoryResponse }
     * 
     */
    public GetHistoryResponse createGetHistoryResponse() {
        return new GetHistoryResponse();
    }

    /**
     * Create an instance of {@link LoginUser }
     * 
     */
    public LoginUser createLoginUser() {
        return new LoginUser();
    }

    /**
     * Create an instance of {@link LoginUserResponse }
     * 
     */
    public LoginUserResponse createLoginUserResponse() {
        return new LoginUserResponse();
    }

    /**
     * Create an instance of {@link LogoutUser }
     * 
     */
    public LogoutUser createLogoutUser() {
        return new LogoutUser();
    }

    /**
     * Create an instance of {@link LogoutUserResponse }
     * 
     */
    public LogoutUserResponse createLogoutUserResponse() {
        return new LogoutUserResponse();
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
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHistory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "getHistory")
    public JAXBElement<GetHistory> createGetHistory(GetHistory value) {
        return new JAXBElement<GetHistory>(_GetHistory_QNAME, GetHistory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHistoryByEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "getHistoryByEmail")
    public JAXBElement<GetHistoryByEmail> createGetHistoryByEmail(GetHistoryByEmail value) {
        return new JAXBElement<GetHistoryByEmail>(_GetHistoryByEmail_QNAME, GetHistoryByEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHistoryByEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "getHistoryByEmailResponse")
    public JAXBElement<GetHistoryByEmailResponse> createGetHistoryByEmailResponse(GetHistoryByEmailResponse value) {
        return new JAXBElement<GetHistoryByEmailResponse>(_GetHistoryByEmailResponse_QNAME, GetHistoryByEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHistoryByOrderID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "getHistoryByOrderID")
    public JAXBElement<GetHistoryByOrderID> createGetHistoryByOrderID(GetHistoryByOrderID value) {
        return new JAXBElement<GetHistoryByOrderID>(_GetHistoryByOrderID_QNAME, GetHistoryByOrderID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHistoryByOrderIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "getHistoryByOrderIDResponse")
    public JAXBElement<GetHistoryByOrderIDResponse> createGetHistoryByOrderIDResponse(GetHistoryByOrderIDResponse value) {
        return new JAXBElement<GetHistoryByOrderIDResponse>(_GetHistoryByOrderIDResponse_QNAME, GetHistoryByOrderIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHistoryByStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "getHistoryByStatus")
    public JAXBElement<GetHistoryByStatus> createGetHistoryByStatus(GetHistoryByStatus value) {
        return new JAXBElement<GetHistoryByStatus>(_GetHistoryByStatus_QNAME, GetHistoryByStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHistoryByStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "getHistoryByStatusResponse")
    public JAXBElement<GetHistoryByStatusResponse> createGetHistoryByStatusResponse(GetHistoryByStatusResponse value) {
        return new JAXBElement<GetHistoryByStatusResponse>(_GetHistoryByStatusResponse_QNAME, GetHistoryByStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHistoryByTitle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "getHistoryByTitle")
    public JAXBElement<GetHistoryByTitle> createGetHistoryByTitle(GetHistoryByTitle value) {
        return new JAXBElement<GetHistoryByTitle>(_GetHistoryByTitle_QNAME, GetHistoryByTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHistoryByTitleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "getHistoryByTitleResponse")
    public JAXBElement<GetHistoryByTitleResponse> createGetHistoryByTitleResponse(GetHistoryByTitleResponse value) {
        return new JAXBElement<GetHistoryByTitleResponse>(_GetHistoryByTitleResponse_QNAME, GetHistoryByTitleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHistoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "getHistoryResponse")
    public JAXBElement<GetHistoryResponse> createGetHistoryResponse(GetHistoryResponse value) {
        return new JAXBElement<GetHistoryResponse>(_GetHistoryResponse_QNAME, GetHistoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "loginUser")
    public JAXBElement<LoginUser> createLoginUser(LoginUser value) {
        return new JAXBElement<LoginUser>(_LoginUser_QNAME, LoginUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "loginUserResponse")
    public JAXBElement<LoginUserResponse> createLoginUserResponse(LoginUserResponse value) {
        return new JAXBElement<LoginUserResponse>(_LoginUserResponse_QNAME, LoginUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "logoutUser")
    public JAXBElement<LogoutUser> createLogoutUser(LogoutUser value) {
        return new JAXBElement<LogoutUser>(_LogoutUser_QNAME, LogoutUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "logoutUserResponse")
    public JAXBElement<LogoutUserResponse> createLogoutUserResponse(LogoutUserResponse value) {
        return new JAXBElement<LogoutUserResponse>(_LogoutUserResponse_QNAME, LogoutUserResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.wsd.uts/", name = "user")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

}
