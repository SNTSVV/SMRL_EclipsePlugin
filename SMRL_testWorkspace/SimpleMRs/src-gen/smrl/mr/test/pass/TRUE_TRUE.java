package smrl.mr.test.pass;

import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class TRUE_TRUE extends MR{
  public boolean mr() {
    ifThenBlock();
    boolean _TRUE = Operations.TRUE(
      Operations.equal(Operations.Input(1), Operations.Input(2)));
    if (_TRUE) {
      expressionPass(); /* //PROPERTY a HOLDS" */
    } else {
      return Boolean.valueOf(false);
    }
    return true;
  }
}
