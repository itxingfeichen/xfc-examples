
package com.github.xfc.webservice.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 */
@WebService(name = "IWebServiceImpl", targetNamespace = "http://impl.service.webservice.xfc.github.com/")
@XmlSeeAlso({
        ObjectFactory.class
})
public interface IWebServiceImpl {


    /**
     * @param arg0
     * @return returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHelloWebService", targetNamespace = "http://impl.service.webservice.xfc.github.com/", className = "com.github.xfc.webservice.service.impl.SayHelloWebService")
    @ResponseWrapper(localName = "sayHelloWebServiceResponse", targetNamespace = "http://impl.service.webservice.xfc.github.com/", className = "com.github.xfc.webservice.service.impl.SayHelloWebServiceResponse")
    @Action(input = "http://impl.service.webservice.xfc.github.com/IWebServiceImpl/sayHelloWebServiceRequest", output = "http://impl.service.webservice.xfc.github.com/IWebServiceImpl/sayHelloWebServiceResponse")
    public String sayHelloWebService(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0);

}
