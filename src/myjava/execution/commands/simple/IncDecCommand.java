/**
 * 
 */
package myjava.execution.commands.simple;

import myjava.execution.commands.ICommand;
import myjava.generatedexp.JavaLexer;
import myjava.generatedexp.JavaParser.ExpressionContext;
import myjava.semantics.mapping.IValueMapper;
import myjava.semantics.mapping.IdentifierMapper;
import myjava.semantics.representations.MyJAVAValue;
import myjava.semantics.representations.MyJAVAValue.PrimitiveType;

/**
 * An increment or decrement command

 *
 */
public class IncDecCommand implements ICommand {

	private ExpressionContext exprCtx;
	private int tokenSign;
	
	public IncDecCommand(ExpressionContext exprCtx, int tokenSign) {
		this.exprCtx = exprCtx;
		this.tokenSign = tokenSign;
	}
	
	/* (non-Javadoc)
	 * @see myjava.execution.commands.ICommand#execute()
	 */
	@Override
	public void execute() {
		//String identifier = this.exprCtx.primary().Identifier().getText();
		//MyJAVAValue myJAVAValue = MyJAVAValueSearcher.searchMyJAVAValue(identifier);
		
		IValueMapper leftHandMapper = new IdentifierMapper(
				this.exprCtx.getText());
		leftHandMapper.analyze(this.exprCtx);

		MyJAVAValue myJAVAValue = leftHandMapper.getMyJAVAValue();
		
		this.performOperation(myJAVAValue);
	}
	
	/*
	 * Attempts to perform an increment/decrement operation
	 */
	private void performOperation(MyJAVAValue myJAVAValue) {
		if(myJAVAValue.getPrimitiveType() == PrimitiveType.INT) {
			int value = Integer.valueOf(myJAVAValue.getValue().toString());
			
			if(this.tokenSign == JavaLexer.INC) {
				value++;
				myJAVAValue.setValue(String.valueOf(value));
			}
			else if(this.tokenSign == JavaLexer.DEC) {
				value--;
				myJAVAValue.setValue(String.valueOf(value));
			}
		}
		else if(myJAVAValue.getPrimitiveType() == PrimitiveType.LONG) {
			long value = Long.valueOf(myJAVAValue.getValue().toString());
			
			if(this.tokenSign == JavaLexer.INC) {
				value++;
				myJAVAValue.setValue(String.valueOf(value));
			}
			else if(this.tokenSign == JavaLexer.DEC) {
				value--;
				myJAVAValue.setValue(String.valueOf(value));
			}
		}
		else if(myJAVAValue.getPrimitiveType() == PrimitiveType.BYTE) {
			byte value = Byte.valueOf(myJAVAValue.getValue().toString());
			
			if(this.tokenSign == JavaLexer.INC) {
				value++;
				myJAVAValue.setValue(String.valueOf(value));
			}
			else if(this.tokenSign == JavaLexer.DEC) {
				value--;
				myJAVAValue.setValue(String.valueOf(value));
			}
		}
		else if(myJAVAValue.getPrimitiveType() == PrimitiveType.SHORT) {
			short value = Short.valueOf(myJAVAValue.getValue().toString());
			
			if(this.tokenSign == JavaLexer.INC) {
				value++;
				myJAVAValue.setValue(String.valueOf(value));
			}
			else if(this.tokenSign == JavaLexer.DEC) {
				value--;
				myJAVAValue.setValue(String.valueOf(value));
			}
		}
		else if(myJAVAValue.getPrimitiveType() == PrimitiveType.FLOAT) {
			float value = Float.valueOf(myJAVAValue.getValue().toString());
			
			if(this.tokenSign == JavaLexer.INC) {
				value++;
				myJAVAValue.setValue(String.valueOf(value));
			}
			else if(this.tokenSign == JavaLexer.DEC) {
				value--;
				myJAVAValue.setValue(String.valueOf(value));
			}
		}
		else if(myJAVAValue.getPrimitiveType() == PrimitiveType.DOUBLE) {
			double value = Double.valueOf(myJAVAValue.getValue().toString());
			
			if(this.tokenSign == JavaLexer.INC) {
				value++;
				myJAVAValue.setValue(String.valueOf(value));
			}
			else if(this.tokenSign == JavaLexer.DEC) {
				value--;
				myJAVAValue.setValue(String.valueOf(value));
			}
		}
	}

}
