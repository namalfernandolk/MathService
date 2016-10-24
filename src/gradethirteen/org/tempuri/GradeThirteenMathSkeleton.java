
/**
 * GradeThirteenMathSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 19, 2008 (10:13:39 LKT)
 */
package gradethirteen.org.tempuri;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 *  GradeThirteenMathSkeleton java skeleton for the axisService
 */
public class GradeThirteenMathSkeleton implements GradeThirteenMathSkeletonInterface{


	/**
	 * Auto generated method signature
	 * 
	 * @param additionRequest0
	 */

	public gradethirteen.org.tempuri.AdditionResponse Addition
	(
			gradethirteen.org.tempuri.AdditionRequest additionRequest0
			)
	{

		AdditionResponse additionResponse = new AdditionResponse();

		double operand1 		= additionRequest0.getOperand1();
		double operand2 		= additionRequest0.getOperand2();
		int decimalPlaces 	= additionRequest0.getDecimalPlaces();

		BigDecimal scaled 	= new BigDecimal(operand1+operand2).setScale(decimalPlaces, RoundingMode.HALF_UP);

		additionResponse.setResult(scaled.doubleValue());
		additionResponse.setRemarks("Addition Half-UP Rounded to "+decimalPlaces+" Decimal Places. Not bad for rade Thirteen!");

		return additionResponse;
	}


	/**
	 * Auto generated method signature
	 * 
	 * @param devisionRequest2
	 */

	public gradethirteen.org.tempuri.DevisionResponse Devision
	(
			gradethirteen.org.tempuri.DevisionRequest devisionRequest2
			)
	{
		DevisionResponse devisionResponse = new DevisionResponse();

		double operand1 		= devisionRequest2.getOperand1();
		double operand2 		= devisionRequest2.getOperand2();
		int decimalPlaces 	= devisionRequest2.getDecimalPlaces();

		BigDecimal scaled = new BigDecimal((double)operand1/(double)operand2).setScale(decimalPlaces, RoundingMode.HALF_UP);

		devisionResponse.setResult(scaled.doubleValue());
		devisionResponse.setRemarks("Devision Half-UP Rounded to "+decimalPlaces+" Decimal Places. Not bad for rade Thirteen!");

		return devisionResponse;
	}

}
