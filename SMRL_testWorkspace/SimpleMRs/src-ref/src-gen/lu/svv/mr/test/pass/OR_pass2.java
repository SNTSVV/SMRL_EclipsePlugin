package lu.svv.mr.test.pass;

import lu.svv.mr.language.Operations;

import lu.svv.mr.language.MR;

@SuppressWarnings("all")
public class OR_pass2 extends MR{
  public boolean mr() {
    boolean _equals = Operations.Input(1).equals(Operations.Input(2));
    if (_equals) {
      /* "//PROPERTY a HOLDS" */
    } else {
      boolean _equals_1 = Operations.Input(1).equals(Operations.Input(1));
      if (_equals_1) {
        /* "//PROPERTY b HOLDS" */
      } else {
        return Boolean.valueOf(false);
      }
    }
    return true;
  }
}
