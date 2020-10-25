package smrl.mr.test.pass;

import java.util.List;
import smrl.mr.language.Action;
import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class ResetWithinLoop_MultipleInputs_TRUE_pass extends MR{
  public boolean mr() {
    List<Action> _actions = Operations.Input(1).actions();
    for (final Action a : _actions) {
      {
        {
          ifThenBlock();
          boolean _EQUAL = Operations.EQUAL(Operations.Input(3), Operations.Input(1));
          if (_EQUAL) {
            expressionPass(); /* //PROPERTY a HOLDS" */
          } else {
            return Boolean.valueOf(false);
          }
        }
        {
          ifThenBlock();
          boolean _EQUAL = Operations.EQUAL(Operations.Input(4), Operations.Input(2));
          if (_EQUAL) {
            expressionPass(); /* //PROPERTY a HOLDS" */
          } else {
            return Boolean.valueOf(false);
          }
        }
        {
          ifThenBlock();
          boolean _EQUAL = Operations.EQUAL(Operations.Input(2), Operations.Input(1));
          if (_EQUAL) {
            return Boolean.valueOf(false);
          } else {
            expressionPass(); /* //PROPERTY HOLDS" */
          }
        }
        {
          ifThenBlock();
          boolean _EQUAL = Operations.EQUAL(Operations.Input(3), Operations.Input(4));
          if (_EQUAL) {
            return Boolean.valueOf(false);
          } else {
            expressionPass(); /* //PROPERTY HOLDS" */
          }
        }
        System.out.println("DONE");
      }
    }
    return true;
  }
}
