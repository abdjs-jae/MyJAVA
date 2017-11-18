package myjava.semantics.representations;

import myjava.ITextWriter;
import myjava.semantics.representations.MyJAVAValue.PrimitiveType;
import myjava.semantics.utils.RecognizedKeywords;
import myjava.semantics.utils.StringHelper;

public class MyJAVAArray implements ITextWriter {

    private MyJAVAValue[] myJAVAValueArray;
    private PrimitiveType arrayPrimitiveType;
    private String arrayIdentifier;
    private boolean finalFlag = false;

    public MyJAVAArray(PrimitiveType primitiveType, String identifier) {
        this.arrayPrimitiveType = primitiveType;
        this.arrayIdentifier = identifier;
    }

    public void setPrimitiveType(PrimitiveType primitiveType) {
        this.arrayPrimitiveType = primitiveType;
    }

    public PrimitiveType getPrimitiveType() {
        return this.arrayPrimitiveType;
    }

    public void markFinal() {
        this.finalFlag = true;
    }

    public boolean isFinal() {
        return this.finalFlag;
    }

    public void initializeSize(int size) {
        this.myJAVAValueArray = new MyJAVAValue[size];
        txtWriter.writeMessage(StringHelper.formatDebug("MyJAVAArray: "
                + "MyJAVA array initialized to size " + this.myJAVAValueArray.length));
    }

    public int getSize() {
        return this.myJAVAValueArray.length;
    }

    public void updateValueAt(MyJAVAValue mobiValue, int index) {
        if(index >= this.myJAVAValueArray.length) {
            txtWriter.writeMessage(StringHelper.formatError(
                    "MyJAVAArray: Out of bounds exception for array " + this.arrayIdentifier + " Index: " + index));
            return;
        }
        this.myJAVAValueArray[index] = mobiValue;
    }

    public MyJAVAValue getValueAt(int index) {
        if(index >= this.myJAVAValueArray.length) {
            txtWriter.writeMessage(StringHelper.formatError(
                    "MyJAVAArray: Out of bounds exception for array " + this.arrayIdentifier + " Index: " + index));
            return this.myJAVAValueArray[this.myJAVAValueArray.length - 1];
        }
        return this.myJAVAValueArray[index];
    }

    /*
     * Utility function that returns an arary of specified primitive type.
     */
    public static MyJAVAArray createArray(String primitiveTypeString, String arrayIdentifier) {
        //identify primitive type and return new MyJAVA array
        return new MyJAVAArray(RecognizedKeywords.setPrimitiveType(primitiveTypeString), arrayIdentifier);
    }
}
