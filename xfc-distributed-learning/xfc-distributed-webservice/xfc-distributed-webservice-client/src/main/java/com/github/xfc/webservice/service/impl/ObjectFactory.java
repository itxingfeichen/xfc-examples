
package com.github.xfc.webservice.service.impl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.github.xfc.webservice.service.impl package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SayHelloWebService_QNAME = new QName("http://impl.service.webservice.xfc.github.com/", "sayHelloWebService");
    private final static QName _SayHelloWebServiceResponse_QNAME = new QName("http://impl.service.webservice.xfc.github.com/", "sayHelloWebServiceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.github.xfc.webservice.service.impl
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayHelloWebServiceResponse }
     */
    public SayHelloWebServiceResponse createSayHelloWebServiceResponse() {
        return new SayHelloWebServiceResponse();
    }

    /**
     * Create an instance of {@link SayHelloWebService }
     */
    public SayHelloWebService createSayHelloWebService() {
        return new SayHelloWebService();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloWebService }{@code >}}
     */
    @XmlElementDecl(namespace = "http://impl.service.webservice.xfc.github.com/", name = "sayHelloWebService")
    public JAXBElement<SayHelloWebService> createSayHelloWebService(SayHelloWebService value) {
        return new JAXBElement<SayHelloWebService>(_SayHelloWebService_QNAME, SayHelloWebService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloWebServiceResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://impl.service.webservice.xfc.github.com/", name = "sayHelloWebServiceResponse")
    public JAXBElement<SayHelloWebServiceResponse> createSayHelloWebServiceResponse(SayHelloWebServiceResponse value) {
        return new JAXBElement<SayHelloWebServiceResponse>(_SayHelloWebServiceResponse_QNAME, SayHelloWebServiceResponse.class, null, value);
    }

}
