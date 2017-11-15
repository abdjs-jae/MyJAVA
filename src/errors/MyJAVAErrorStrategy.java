package errors;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.IntervalSet;

/**
 * Created by jasonsapdos on 15/11/2017.
 */
public class MyJAVAErrorStrategy extends DefaultErrorStrategy {

    @Override
    public void recover(Parser recognizer, RecognitionException e) {

        // Fail-safe method from Del Gallego's MobiProg DefaultErrorRecovery class
        if (lastErrorIndex == recognizer.getInputStream().index() &&
                lastErrorStates != null &&
                lastErrorStates.contains(recognizer.getState())) {
            recognizer.consume();
        }
        lastErrorIndex = recognizer.getInputStream().index();
        if (lastErrorStates == null)
            lastErrorStates = new IntervalSet();
        lastErrorStates.add(recognizer.getState());
        IntervalSet followSet = getErrorRecoverySet(recognizer);
        consumeUntil(recognizer, followSet);
    }
}
