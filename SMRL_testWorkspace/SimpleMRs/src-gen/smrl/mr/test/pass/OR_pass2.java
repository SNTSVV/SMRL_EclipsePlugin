package smrl.mr.test.pass;

import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class OR_pass2 extends MR{
  public boolean mr() {
    ifThenBlock();
    boolean _equals = Operations.Input(1).equals(Operations.Input(2));
    if (_equals) {
      expressionPass(); /* //PROPERTY a HOLDS" */
    } else {
      ifThenBlock();
      boolean _equals_1 = Operations.Input(1).equals(Operations.Input(1));
      if (_equals_1) {
        expressionPass(); /* //PROPERTY b HOLDS" */
      } else {
        return Boolean.valueOf(false);
      }
    }
    return true;
  }
}
