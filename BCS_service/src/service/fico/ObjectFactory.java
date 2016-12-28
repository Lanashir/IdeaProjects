
package service.fico;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service.fico package.
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service.fico
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InvokePH3Response }
     * 
     */
    public InvokePH3Response createInvokePH3Response() {
        return new InvokePH3Response();
    }

    /**
     * Create an instance of {@link InvokeRequestParameters }
     * 
     */
    public InvokeRequestParameters createInvokeRequestParameters() {
        return new InvokeRequestParameters();
    }

    /**
     * Create an instance of {@link InvokePH3 }
     * 
     */
    public InvokePH3 createInvokePH3() {
        return new InvokePH3();
    }

    /**
     * Create an instance of {@link AdditionalParameters }
     * 
     */
    public AdditionalParameters createAdditionalParameters() {
        return new AdditionalParameters();
    }

}
