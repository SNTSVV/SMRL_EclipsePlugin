package lu.svv.mr.test.pass;

import lu.svv.mr.language.Operations;

import lu.svv.mr.language.MR;

@SuppressWarnings("all")
public class IMPLIES_pass2 extends MR{
  public boolean mr() {
    boolean _equals = Operations.Input(1).equals(Operations.Input(2));
    if (_equals) {
      boolean _equals_1 = Operations.Input(2).equals(Operations.Input(3));
      if (_equals_1) {
        /* "//PROPERTY HOLDS" */
      } else {
        return Boolean.valueOf(false);
      }
    }
    return true;
  }
}
