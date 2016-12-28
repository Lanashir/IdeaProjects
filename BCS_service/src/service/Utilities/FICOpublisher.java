package service.Utilities;

import service.fico.CheckApplicantForComplianceOMReqACSResponseImpl;

import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;
import java.util.List;

/**
 * Created by agosipov on 08.12.2016.
 */
public class FICOpublisher {
    public static void main(String... args) {
        Endpoint ep = Endpoint.create(new CheckApplicantForComplianceOMReqACSResponseImpl());
        List<Handler> handlerChain = ep.getBinding().getHandlerChain();
        handlerChain.add(new SOAPLoggingHandler());
        ep.getBinding().setHandlerChain(handlerChain);

        ep.publish("http://localhost:1987/ru.neoflex.vtb24.proxyserviceWeb/sca/CheckApplicantForComplianceOMReqACSResponseExport");
        //Endpoint bcs = Endpoint.create(new CheckApplicantForComplianceOMReqACSImpl());
        //List<Handler> handlerChainbcs = bcs.getBinding().getHandlerChain();
        //handlerChainbcs.add(new SOAPLoggingHandler());
        //bcs.getBinding().setHandlerChain(handlerChain);
        //bcs.publish("http://localhost:1986/services/BCS");
        /*try {
            JAXBContext jaxbContext = JAXBContext.newInstance(InvokeRequestParameters.class);
            System.out.println("jaxbContext is=" + jaxbContext.toString());
        }catch(JAXBException e){
            e.printStackTrace();*/
    }
}
