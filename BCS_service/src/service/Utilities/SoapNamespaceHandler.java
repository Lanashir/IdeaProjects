package service.Utilities;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by agosipov on 09.12.2016.
 */
public class SoapNamespaceHandler implements SOAPHandler<SOAPMessageContext> {
    private final static String SOAP_PREFIX = "soapenv";
    private final static String HEAD_PREFIX = "wsa";
    private final static String HEAD_NS = "http://www.w3.org/2005/08/addressing";

    @Override
    public boolean handleMessage(final SOAPMessageContext context){
//only update the namespace prefix for outbound messages (requests)
        final Boolean isSoapRequest = (Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (isSoapRequest){
            try{
                SOAPMessage soapMsg = context.getMessage();
                SOAPEnvelope env = soapMsg.getSOAPPart().getEnvelope();
                SOAPBody body = env.getBody();
                SOAPHeader header =soapMsg.getSOAPHeader();
                if (header == null) {
                    header = env.addHeader();
                }
                env.setPrefix(SOAP_PREFIX);
                env.removeNamespaceDeclaration("S");
                env.addNamespaceDeclaration("om", "http://omentrylibrary/com/om");

                body.setPrefix(SOAP_PREFIX);

                header.addNamespaceDeclaration(HEAD_PREFIX, HEAD_NS);
                header.setPrefix(SOAP_PREFIX);

                SOAPFactory sf = SOAPFactory.newInstance();
                SOAPElement To = sf.createElement("To", HEAD_PREFIX, HEAD_NS);
                To.addTextNode("http://k10-fico-wps.vtb24.ru:9082/ru.neoflex.vtb24.proxyserviceWeb/sca/CheckApplicantForComplianceOMReqACSResponseExport");
                header.addChildElement(To);

                SOAPElement Action = sf.createElement("Action", HEAD_PREFIX, HEAD_NS);
                Action.addTextNode("CheckApplicantForCompliance");
                header.addChildElement(Action);

                SOAPElement MessageID = sf.createElement("MessageID", HEAD_PREFIX, HEAD_NS);
                MessageID.addTextNode("urn:60DE09F0516111E5BFA0C9AD703317D1");
                header.addChildElement(MessageID);

                SOAPElement RelatesTo = sf.createElement("RelatesTo", HEAD_PREFIX, HEAD_NS);
                RelatesTo.addTextNode("uuid:f0967154-ef34-4451-80fd-8d950da31d88");
                header.addChildElement(RelatesTo);

                SOAPElement ReplyTo = sf.createElement("ReplyTo", HEAD_PREFIX, HEAD_NS);
                SOAPElement Address = sf.createElement("Address", HEAD_PREFIX, HEAD_NS);
                Address.addTextNode("http://www.w3.org/2005/08/addressing/anonymous");
                ReplyTo.addChildElement(Address);
                header.addChildElement(ReplyTo);

                SOAPElement FaultTo = sf.createElement("FaultTo", HEAD_PREFIX, HEAD_NS);
                FaultTo.addChildElement(Address);
                header.addChildElement(FaultTo);

                soapMsg.saveChanges();
                System.out.println("asd");
                Iterator it = body.getParentElement().getParentElement().getAllAttributes();
                System.out.println(it.toString());
                while (it.hasNext()) {
                    Object o = it.next();
                    System.out.println("name = " + ((SOAPElement) o).getElementName().getLocalName());
                    if (o instanceof SOAPElement) {
                        System.out.println("name = " + ((SOAPElement) o).getElementName().getLocalName());
                        if(((SOAPElement) o).getElementName().getQualifiedName() == "creditApplicationXml" || ((SOAPElement) o).getElementName().getQualifiedName() == "userContextXml"){
                            Node ccdata = (Node) soapMsg.getSOAPPart().createCDATASection(((SOAPElement) o).getTextContent());
                            body.appendChild(ccdata);
                            body.removeChild(((SOAPElement) o).getFirstChild());
                            break;
                        }
                    }
                }

            }
            catch (SOAPException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {

    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }
}
