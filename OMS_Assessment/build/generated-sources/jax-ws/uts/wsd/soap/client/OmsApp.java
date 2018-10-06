
package uts.wsd.soap.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "omsApp", targetNamespace = "http://soap.wsd.uts/", wsdlLocation = "http://localhost:8080/OMS_Assessment/omsApp?wsdl")
public class OmsApp
    extends Service
{

    private final static URL OMSAPP_WSDL_LOCATION;
    private final static WebServiceException OMSAPP_EXCEPTION;
    private final static QName OMSAPP_QNAME = new QName("http://soap.wsd.uts/", "omsApp");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/OMS_Assessment/omsApp?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        OMSAPP_WSDL_LOCATION = url;
        OMSAPP_EXCEPTION = e;
    }

    public OmsApp() {
        super(__getWsdlLocation(), OMSAPP_QNAME);
    }

    public OmsApp(WebServiceFeature... features) {
        super(__getWsdlLocation(), OMSAPP_QNAME, features);
    }

    public OmsApp(URL wsdlLocation) {
        super(wsdlLocation, OMSAPP_QNAME);
    }

    public OmsApp(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, OMSAPP_QNAME, features);
    }

    public OmsApp(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public OmsApp(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns OMSSOAP
     */
    @WebEndpoint(name = "OMSSOAPPort")
    public OMSSOAP getOMSSOAPPort() {
        return super.getPort(new QName("http://soap.wsd.uts/", "OMSSOAPPort"), OMSSOAP.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OMSSOAP
     */
    @WebEndpoint(name = "OMSSOAPPort")
    public OMSSOAP getOMSSOAPPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soap.wsd.uts/", "OMSSOAPPort"), OMSSOAP.class, features);
    }

    private static URL __getWsdlLocation() {
        if (OMSAPP_EXCEPTION!= null) {
            throw OMSAPP_EXCEPTION;
        }
        return OMSAPP_WSDL_LOCATION;
    }

}
