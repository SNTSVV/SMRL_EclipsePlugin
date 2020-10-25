package smrl.mr.test.pass;

import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class NOT extends MR{
  public boolean mr() {
    ifThenBlock();
    boolean _equals = Operations.Input(1).equals(Operations.Input(2));
    if (_equals) {
      return Boolean.valueOf(false);
    } else {
      expressionPass(); /* //PROPERTY HOLDS" */
    }
    return true;
  }
}
