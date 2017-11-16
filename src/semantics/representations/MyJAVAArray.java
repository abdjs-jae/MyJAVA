package semantics.representations;

import semantics.representations.MyJAVAValue.PrimitiveType;
import semantics.utils.RecognizedKeywords;

public class MyJAVAArray {

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
        System.out.println("MyJAVAArray: " + "MyJAVA array initialized to size " + this.myJAVAValueArray.length);
    }

    public int getSize() {
        return this.myJAVAValueArray.length;
    }

    public void updateValueAt(MyJAVAValue mobiValue, int index) {
        if(index >= this.myJAVAValueArray.length) {
            System.err.println("MyJAVAArray: Access out of bounds for array " + this.arrayIdentifier);
            return;
        }
        this.myJAVAValueArray[index] = mobiValue;
    }

    public MyJAVAValue getValueAt(int index) {
        if(index >= this.myJAVAValueArray.length) {
            System.err.println("MyJAVAArray: Access out of bounds for array " + this.arrayIdentifier);
            return this.myJAVAValueArray[this.myJAVAValueArray.length - 1];
        }
        else {
            return this.myJAVAValueArray[index];
        }
    }

    /*
     * Utility function that returns an arary of specified primitive type.
     */
    public static MyJAVAArray createArray(String primitiveTypeString, String arrayIdentifier) {
        //identify primitive type
        PrimitiveType primitiveType = RecognizedKeywords.setPrimitiveType(primitiveTypeString);

        // return new MyJAVA array
        return new MyJAVAArray(primitiveType, arrayIdentifier);
    }
}
