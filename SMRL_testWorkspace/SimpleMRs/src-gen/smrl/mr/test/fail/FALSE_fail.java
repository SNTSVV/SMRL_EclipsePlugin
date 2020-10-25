package smrl.mr.test.fail;

import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class FALSE_fail extends MR{
  public boolean mr() {
    ifThenBlock();
    boolean _equals = Operations.Input(1).equals(Operations.Input(1));
    if (_equals) {
      return Boolean.valueOf(false);
    } else {
      expressionPass(); /* //PROPERTY HOLDS" */
    }
    return true;
  }
}
