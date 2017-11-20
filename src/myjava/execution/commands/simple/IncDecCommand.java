/**
 * 
 */
package myjava.execution.commands.simple;

import myjava.execution.commands.ICommand;
import myjava.generatedexp.JavaLexer;
import myjava.generatedexp.JavaParser.ExpressionContext;
import myjava.semantics.mapping.IValueMapper;
import myjava.semantics.mapping.IdentifierMapper;
import myjava.semantics.representations.MobiValue;
import myjava.semantics.representations.MobiValue.PrimitiveType;

/**
 * An increment or decrement command
 *
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
		//MobiValue mobiValue = MobiValueSearcher.searchMobiValue(identifier);
		
		IValueMapper leftHandMapper = new IdentifierMapper(
				this.exprCtx.getText());
		leftHandMapper.analyze(this.exprCtx);

		MobiValue mobiValue = leftHandMapper.getMobiValue();
		
		this.performOperation(mobiValue);
	}
	
	/*
	 * Attempts to perform an increment/decrement operation
	 */
	private void performOperation(MobiValue mobiValue) {
		if(mobiValue.getPrimitiveType() == PrimitiveType.INT) {
			int value = Integer.valueOf(mobiValue.getValue().toString());
			
			if(this.tokenSign == JavaLexer.INC) {
				value++;
				mobiValue.setValue(String.valueOf(value));
			}
			else if(this.tokenSign == JavaLexer.DEC) {
				value--;
				mobiValue.setValue(String.valueOf(value));
			}
		}
		else if(mobiValue.getPrimitiveType() == PrimitiveType.LONG) {
			long value = Long.valueOf(mobiValue.getValue().toString());
			
			if(this.tokenSign == JavaLexer.INC) {
				value++;
				mobiValue.setValue(String.valueOf(value));
			}
			else if(this.tokenSign == JavaLexer.DEC) {
				value--;
				mobiValue.setValue(String.valueOf(value));
			}
		}
		else if(mobiValue.getPrimitiveType() == PrimitiveType.BYTE) {
			byte value = Byte.valueOf(mobiValue.getValue().toString());
			
			if(this.tokenSign == JavaLexer.INC) {
				value++;
				mobiValue.setValue(String.valueOf(value));
			}
			else if(this.tokenSign == JavaLexer.DEC) {
				value--;
				mobiValue.setValue(String.valueOf(value));
			}
		}
		else if(mobiValue.getPrimitiveType() == PrimitiveType.SHORT) {
			short value = Short.valueOf(mobiValue.getValue().toString());
			
			if(this.tokenSign == JavaLexer.INC) {
				value++;
				mobiValue.setValue(String.valueOf(value));
			}
			else if(this.tokenSign == JavaLexer.DEC) {
				value--;
				mobiValue.setValue(String.valueOf(value));
			}
		}
		else if(mobiValue.getPrimitiveType() == PrimitiveType.FLOAT) {
			float value = Float.valueOf(mobiValue.getValue().toString());
			
			if(this.tokenSign == JavaLexer.INC) {
				value++;
				mobiValue.setValue(String.valueOf(value));
			}
			else if(this.tokenSign == JavaLexer.DEC) {
				value--;
				mobiValue.setValue(String.valueOf(value));
			}
		}
		else if(mobiValue.getPrimitiveType() == PrimitiveType.DOUBLE) {
			double value = Double.valueOf(mobiValue.getValue().toString());
			
			if(this.tokenSign == JavaLexer.INC) {
				value++;
				mobiValue.setValue(String.valueOf(value));
			}
			else if(this.tokenSign == JavaLexer.DEC) {
				value--;
				mobiValue.setValue(String.valueOf(value));
			}
		}
	}

}
