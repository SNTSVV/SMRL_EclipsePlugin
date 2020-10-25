package smrl.mr.test.fail;

import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class TRUE_fail extends MR{
  public boolean mr() {
    ifThenBlock();
    boolean _equals = Operations.Input(1).equals(Operations.Input(2));
    if (_equals) {
      expressionPass(); /* //PROPERTY a HOLDS" */
    } else {
      return Boolean.valueOf(false);
    }
    return true;
  }
}
