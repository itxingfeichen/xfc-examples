
package com.github.xfc.webservice.service.impl;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 */
@WebServiceClient(name = "IWebServiceImplService", targetNamespace = "http://impl.service.webservice.xfc.github.com/", wsdlLocation = "http://localhost:8888/webservice/test?wsdl")
public class IWebServiceImplService
        extends Service {

    private final static URL IWEBSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException IWEBSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName IWEBSERVICEIMPLSERVICE_QNAME = new QName("http://impl.service.webservice.xfc.github.com/", "IWebServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8888/webservice/test?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        IWEBSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        IWEBSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public IWebServiceImplService() {
        super(__getWsdlLocation(), IWEBSERVICEIMPLSERVICE_QNAME);
    }

    public IWebServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), IWEBSERVICEIMPLSERVICE_QNAME, features);
    }

    public IWebServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, IWEBSERVICEIMPLSERVICE_QNAME);
    }

    public IWebServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, IWEBSERVICEIMPLSERVICE_QNAME, features);
    }

    public IWebServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IWebServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns IWebServiceImpl
     */
    @WebEndpoint(name = "IWebServiceImplPort")
    public IWebServiceImpl getIWebServiceImplPort() {
        return super.getPort(new QName("http://impl.service.webservice.xfc.github.com/", "IWebServiceImplPort"), IWebServiceImpl.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns IWebServiceImpl
     */
    @WebEndpoint(name = "IWebServiceImplPort")
    public IWebServiceImpl getIWebServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.service.webservice.xfc.github.com/", "IWebServiceImplPort"), IWebServiceImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (IWEBSERVICEIMPLSERVICE_EXCEPTION != null) {
            throw IWEBSERVICEIMPLSERVICE_EXCEPTION;
        }
        return IWEBSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
