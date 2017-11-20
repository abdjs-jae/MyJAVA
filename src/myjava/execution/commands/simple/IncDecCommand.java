package myjava.execution.commands.simple;

import myjava.execution.commands.ICommand;
import myjava.generatedexp.JavaLexer;
import myjava.generatedexp.JavaParser.ExpressionContext;
import myjava.semantics.mapping.IValueMapper;
import myjava.semantics.mapping.IdentifierMapper;
import myjava.semantics.representations.MyJAVAValue;

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

	@Override
	public void execute() {
		// String identifier = this.exprCtx.primary().Identifier().getText();
		// MyJAVAValue myJAVAValue = MyJAVAValueSearcher.searchMyJAVAValue(identifier);
		
		IValueMapper leftHandMapper = new IdentifierMapper(
				exprCtx.getText());
		leftHandMapper.analyze(exprCtx);

		MyJAVAValue myJAVAValue = leftHandMapper.getMyJAVAValue();
		
		performOperation(myJAVAValue);
	}
	
	/*
	 * Attempts to perform an increment/decrement operation
	 */
	private void performOperation(MyJAVAValue myJAVAValue) {
		switch (myJAVAValue.getPrimitiveType()) {
			case INT: {
				int value = Integer.valueOf(myJAVAValue.getValue().toString());

				if (this.tokenSign == JavaLexer.INC) {
					value++;
					myJAVAValue.setValue(String.valueOf(value));
				} else if (this.tokenSign == JavaLexer.DEC) {
					value--;
					myJAVAValue.setValue(String.valueOf(value));
				}
				break;
			}
			case LONG: {
				long value = Long.valueOf(myJAVAValue.getValue().toString());

				if (this.tokenSign == JavaLexer.INC) {
					value++;
					myJAVAValue.setValue(String.valueOf(value));
				} else if (this.tokenSign == JavaLexer.DEC) {
					value--;
					myJAVAValue.setValue(String.valueOf(value));
				}
				break;
			}
			case BYTE: {
				byte value = Byte.valueOf(myJAVAValue.getValue().toString());

				if (this.tokenSign == JavaLexer.INC) {
					value++;
					myJAVAValue.setValue(String.valueOf(value));
				} else if (this.tokenSign == JavaLexer.DEC) {
					value--;
					myJAVAValue.setValue(String.valueOf(value));
				}
				break;
			}
			case SHORT: {
				short value = Short.valueOf(myJAVAValue.getValue().toString());

				if (this.tokenSign == JavaLexer.INC) {
					value++;
					myJAVAValue.setValue(String.valueOf(value));
				} else if (this.tokenSign == JavaLexer.DEC) {
					value--;
					myJAVAValue.setValue(String.valueOf(value));
				}
				break;
			}
			case FLOAT: {
				float value = Float.valueOf(myJAVAValue.getValue().toString());

				if (this.tokenSign == JavaLexer.INC) {
					value++;
					myJAVAValue.setValue(String.valueOf(value));
				} else if (this.tokenSign == JavaLexer.DEC) {
					value--;
					myJAVAValue.setValue(String.valueOf(value));
				}
				break;
			}
			case DOUBLE: {
				double value = Double.valueOf(myJAVAValue.getValue().toString());

				if (this.tokenSign == JavaLexer.INC) {
					value++;
					myJAVAValue.setValue(String.valueOf(value));
				} else if (this.tokenSign == JavaLexer.DEC) {
					value--;
					myJAVAValue.setValue(String.valueOf(value));
				}
				break;
			}
		}
	}

}
