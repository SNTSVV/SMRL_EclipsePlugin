package smrl.mr.test.pass;

import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class RandomString extends MR{
  public boolean mr() {
    Object x = Operations.RandomValue("");
    System.out.println(x);
    {
      ifThenBlock();
      boolean _NULL = Operations.NULL(x);
      if (_NULL) {
        return Boolean.valueOf(false);
      } else {
        expressionPass(); /* //PROPERTY HOLDS" */
      }
    }
    return true;
  }
}
