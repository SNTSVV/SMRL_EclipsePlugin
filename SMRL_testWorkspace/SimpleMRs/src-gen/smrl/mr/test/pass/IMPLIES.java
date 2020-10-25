package smrl.mr.test.pass;

import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class IMPLIES extends MR{
  public boolean mr() {
    ifThenBlock();
    boolean _equal = Operations.equal(Operations.Input(1), Operations.Input(1));
    if (_equal) {
      ifThenBlock();
      boolean _equal_1 = Operations.equal(Operations.Input(2), Operations.Input(2));
      if (_equal_1) {
        expressionPass(); /* //PROPERTY HOLDS" */
      } else {
        return Boolean.valueOf(false);
      }
    } else {
      expressionPass(); /* //PROPERTY HOLDS" */
    }
    return true;
  }
}
