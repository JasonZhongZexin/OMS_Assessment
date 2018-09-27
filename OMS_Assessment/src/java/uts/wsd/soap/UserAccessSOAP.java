/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.soap;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author zhongzexin
 */
@WebService(serviceName = "userApp")
public class UserAccessSOAP {
    @WebMethod
    private UsersApplication getUserApplication() throws Exception {
        application = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
        synchronized (application) {
            UsersApplication userApp = (UsersApplication) application.getAttribute("userApp");
            if (userApp == null) {
                userApp = new UsersApplication();
                userApp.setFilePath(application.getRealPath("WEB-INF/users.xml"));
                application.setAttribute("userApp", userApp);
            }
            return userApp;
        }
    }
    
    @WebMethod
    public User loginUser(String email, String password) throws Exception{
        return getUserApplication().loginUser(email, password);
    }
    
    @WebMethod
    public String logoutUser() throws Exception{
        User user = getUserApplication().logoutUser();
        return "User has logged out";
    }
}
