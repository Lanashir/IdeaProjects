
package service.fico;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CheckApplicantForComplianceOMReqACSResponse", targetNamespace = "http://omentrylibrary/com/om")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CheckApplicantForComplianceOMReqACSResponse {


    /**
     * 
     * @param invokePH3ResponseParameters
     */
    @WebMethod(operationName = "CheckApplicantForCompliance")
    @Oneway
    public void checkApplicantForCompliance(
        @WebParam(name = "invokePH3Response", targetNamespace = "http://omentrylibrary/com/om", partName = "invokePH3ResponseParameters")
        InvokePH3Response invokePH3ResponseParameters);

}
