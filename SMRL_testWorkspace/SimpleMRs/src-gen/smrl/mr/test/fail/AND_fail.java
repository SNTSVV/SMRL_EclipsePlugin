package smrl.mr.test.fail;

import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class AND_fail extends MR{
  public boolean mr() {
    ifThenBlock();
    boolean _equals = Operations.Input(1).equals(Operations.Input(2));
    if (_equals) {
      ifThenBlock();
      boolean _equals_1 = Operations.Input(2).equals(Operations.Input(2));
      if (_equals_1) {
        expressionPass(); /* //PROPERTY HOLDS" */
      } else {
        return Boolean.valueOf(false);
      }
    } else {
      return Boolean.valueOf(false);
    }
    return true;
  }
}
