
package uts.wsd.soap.client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UserAccessSOAP", targetNamespace = "http://soap.wsd.uts/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserAccessSOAP {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns uts.wsd.soap.client.User
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loginUser", targetNamespace = "http://soap.wsd.uts/", className = "uts.wsd.soap.client.LoginUser")
    @ResponseWrapper(localName = "loginUserResponse", targetNamespace = "http://soap.wsd.uts/", className = "uts.wsd.soap.client.LoginUserResponse")
    @Action(input = "http://soap.wsd.uts/UserAccessSOAP/loginUserRequest", output = "http://soap.wsd.uts/UserAccessSOAP/loginUserResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://soap.wsd.uts/UserAccessSOAP/loginUser/Fault/Exception")
    })
    public User loginUser(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws Exception_Exception
    ;

    /**
     * 
     * @return
     *     returns java.lang.String
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "logoutUser", targetNamespace = "http://soap.wsd.uts/", className = "uts.wsd.soap.client.LogoutUser")
    @ResponseWrapper(localName = "logoutUserResponse", targetNamespace = "http://soap.wsd.uts/", className = "uts.wsd.soap.client.LogoutUserResponse")
    @Action(input = "http://soap.wsd.uts/UserAccessSOAP/logoutUserRequest", output = "http://soap.wsd.uts/UserAccessSOAP/logoutUserResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://soap.wsd.uts/UserAccessSOAP/logoutUser/Fault/Exception")
    })
    public String logoutUser()
        throws Exception_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<uts.wsd.soap.client.Order>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHistory", targetNamespace = "http://soap.wsd.uts/", className = "uts.wsd.soap.client.GetHistory")
    @ResponseWrapper(localName = "getHistoryResponse", targetNamespace = "http://soap.wsd.uts/", className = "uts.wsd.soap.client.GetHistoryResponse")
    @Action(input = "http://soap.wsd.uts/UserAccessSOAP/getHistoryRequest", output = "http://soap.wsd.uts/UserAccessSOAP/getHistoryResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://soap.wsd.uts/UserAccessSOAP/getHistory/Fault/Exception")
    })
    public List<Order> getHistory()
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<uts.wsd.soap.client.Order>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHistoryByStatus", targetNamespace = "http://soap.wsd.uts/", className = "uts.wsd.soap.client.GetHistoryByStatus")
    @ResponseWrapper(localName = "getHistoryByStatusResponse", targetNamespace = "http://soap.wsd.uts/", className = "uts.wsd.soap.client.GetHistoryByStatusResponse")
    @Action(input = "http://soap.wsd.uts/UserAccessSOAP/getHistoryByStatusRequest", output = "http://soap.wsd.uts/UserAccessSOAP/getHistoryByStatusResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://soap.wsd.uts/UserAccessSOAP/getHistoryByStatus/Fault/Exception")
    })
    public List<Order> getHistoryByStatus(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns uts.wsd.soap.client.Order
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHistoryByOrderID", targetNamespace = "http://soap.wsd.uts/", className = "uts.wsd.soap.client.GetHistoryByOrderID")
    @ResponseWrapper(localName = "getHistoryByOrderIDResponse", targetNamespace = "http://soap.wsd.uts/", className = "uts.wsd.soap.client.GetHistoryByOrderIDResponse")
    @Action(input = "http://soap.wsd.uts/UserAccessSOAP/getHistoryByOrderIDRequest", output = "http://soap.wsd.uts/UserAccessSOAP/getHistoryByOrderIDResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://soap.wsd.uts/UserAccessSOAP/getHistoryByOrderID/Fault/Exception")
    })
    public Order getHistoryByOrderID(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<uts.wsd.soap.client.Order>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHistoryByEmail", targetNamespace = "http://soap.wsd.uts/", className = "uts.wsd.soap.client.GetHistoryByEmail")
    @ResponseWrapper(localName = "getHistoryByEmailResponse", targetNamespace = "http://soap.wsd.uts/", className = "uts.wsd.soap.client.GetHistoryByEmailResponse")
    @Action(input = "http://soap.wsd.uts/UserAccessSOAP/getHistoryByEmailRequest", output = "http://soap.wsd.uts/UserAccessSOAP/getHistoryByEmailResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://soap.wsd.uts/UserAccessSOAP/getHistoryByEmail/Fault/Exception")
    })
    public List<Order> getHistoryByEmail(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<uts.wsd.soap.client.Order>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHistoryByTitle", targetNamespace = "http://soap.wsd.uts/", className = "uts.wsd.soap.client.GetHistoryByTitle")
    @ResponseWrapper(localName = "getHistoryByTitleResponse", targetNamespace = "http://soap.wsd.uts/", className = "uts.wsd.soap.client.GetHistoryByTitleResponse")
    @Action(input = "http://soap.wsd.uts/UserAccessSOAP/getHistoryByTitleRequest", output = "http://soap.wsd.uts/UserAccessSOAP/getHistoryByTitleResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://soap.wsd.uts/UserAccessSOAP/getHistoryByTitle/Fault/Exception")
    })
    public List<Order> getHistoryByTitle(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws Exception_Exception
    ;

}
