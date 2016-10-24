
/**
 * GradeThreeMathSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 19, 2008 (10:13:39 LKT)
 */
    package gradethree.org.tempuri;
    /**
     *  GradeThreeMathSkeleton java skeleton for the axisService
     */
    public class GradeThreeMathSkeleton implements GradeThreeMathSkeletonInterface{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param additionRequest0
         */
        
                 public gradethree.org.tempuri.AdditionResponse Addition
                  (
                  gradethree.org.tempuri.AdditionRequest additionRequest0
                  )
            {
                	 AdditionResponse additionResponse = new AdditionResponse();
                     
                     int operand1 = additionRequest0.getOperand1();
                     int operand2 = additionRequest0.getOperand2();
                     
                     additionResponse.setResult(operand1+operand2);
                     additionResponse.setRemarks("This is enough for Grade Three Addition!");
                     
                     return additionResponse;
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param devisionRequest2
         */
        
                 public gradethree.org.tempuri.DevisionResponse Devision
                  (
                  gradethree.org.tempuri.DevisionRequest devisionRequest2
                  )
            {
                	 DevisionResponse devisionResponse = new DevisionResponse();
                	 
                	 int operand1 = devisionRequest2.getOperand1();
                	 int operand2 = devisionRequest2.getOperand2();
                	 
                	 devisionResponse.setResult(operand1/operand2);
                	 devisionResponse.setRemarks("This is enough for Grade Three Devisio!");
                	 
                	 return devisionResponse;
        }
     
    }
    