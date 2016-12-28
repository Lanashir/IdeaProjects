package omentrylibrary.com.om;

import javax.xml.ws.Endpoint;

/**
 * Created by agosipov on 19.12.2016.
 */
public class Publisher {
    public static void main(String... args) {
        Endpoint ep = Endpoint.create(new CheckApplicantForComplianceOMReqAV1Impl());
        //List<Handler> handlerChain = ep.getBinding().getHandlerChain();
        //handlerChain.add(new SOAPLoggingHandler());
        //ep.getBinding().setHandlerChain(handlerChain);

        ep.publish("http://localhost:1986/services/BCS");
        /*List<Handler> handlerChainbcs = bcs.getBinding().getHandlerChain();
        handlerChainbcs.add(new SOAPLoggingHandler());
        bcs.getBinding().setHandlerChain(handlerChain);*/
        /*try {
            JAXBContext jaxbContext = JAXBContext.newInstance(InvokeRequestParameters.class);
            System.out.println("jaxbContext is=" + jaxbContext.toString());
        }catch(JAXBException e){
            e.printStackTrace();
        }*/
    }
}
