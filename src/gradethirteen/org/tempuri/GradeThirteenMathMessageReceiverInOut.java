
/**
 * GradeThirteenMathMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 19, 2008 (10:13:39 LKT)
 */
        package gradethirteen.org.tempuri;

        /**
        *  GradeThirteenMathMessageReceiverInOut message receiver
        */

        public class GradeThirteenMathMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        GradeThirteenMathSkeletonInterface skel = (GradeThirteenMathSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJava(op.getName().getLocalPart())) != null)){

        

            if("Addition".equals(methodName)){
                
                gradethirteen.org.tempuri.AdditionResponse additionResponse13 = null;
	                        gradethirteen.org.tempuri.AdditionRequest wrappedParam =
                                                             (gradethirteen.org.tempuri.AdditionRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    gradethirteen.org.tempuri.AdditionRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               additionResponse13 =
                                                   
                                                   
                                                         skel.Addition(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), additionResponse13, false);
                                    } else 

            if("Devision".equals(methodName)){
                
                gradethirteen.org.tempuri.DevisionResponse devisionResponse15 = null;
	                        gradethirteen.org.tempuri.DevisionRequest wrappedParam =
                                                             (gradethirteen.org.tempuri.DevisionRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    gradethirteen.org.tempuri.DevisionRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               devisionResponse15 =
                                                   
                                                   
                                                         skel.Devision(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), devisionResponse15, false);
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(gradethirteen.org.tempuri.AdditionRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(gradethirteen.org.tempuri.AdditionRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(gradethirteen.org.tempuri.AdditionResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(gradethirteen.org.tempuri.AdditionResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(gradethirteen.org.tempuri.DevisionRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(gradethirteen.org.tempuri.DevisionRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(gradethirteen.org.tempuri.DevisionResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(gradethirteen.org.tempuri.DevisionResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, gradethirteen.org.tempuri.AdditionResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(gradethirteen.org.tempuri.AdditionResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private gradethirteen.org.tempuri.AdditionResponse wrapAddition(){
                                gradethirteen.org.tempuri.AdditionResponse wrappedElement = new gradethirteen.org.tempuri.AdditionResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, gradethirteen.org.tempuri.DevisionResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(gradethirteen.org.tempuri.DevisionResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private gradethirteen.org.tempuri.DevisionResponse wrapDevision(){
                                gradethirteen.org.tempuri.DevisionResponse wrappedElement = new gradethirteen.org.tempuri.DevisionResponse();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (gradethirteen.org.tempuri.AdditionRequest.class.equals(type)){
                
                           return gradethirteen.org.tempuri.AdditionRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (gradethirteen.org.tempuri.AdditionResponse.class.equals(type)){
                
                           return gradethirteen.org.tempuri.AdditionResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (gradethirteen.org.tempuri.DevisionRequest.class.equals(type)){
                
                           return gradethirteen.org.tempuri.DevisionRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (gradethirteen.org.tempuri.DevisionResponse.class.equals(type)){
                
                           return gradethirteen.org.tempuri.DevisionResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    