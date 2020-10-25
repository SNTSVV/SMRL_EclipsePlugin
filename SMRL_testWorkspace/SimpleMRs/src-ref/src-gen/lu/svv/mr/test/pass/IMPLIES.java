package lu.svv.mr.test.pass;

import lu.svv.mr.language.Operations;

import lu.svv.mr.language.MR;

@SuppressWarnings("all")
public class IMPLIES extends MR{
  public boolean mr() {
    boolean _equal = Operations.equal(Operations.Input(1), Operations.Input(1));
    if (_equal) {
      boolean _equal_1 = Operations.equal(Operations.Input(2), Operations.Input(2));
      if (_equal_1) {
        /* "//PROPERTY HOLDS" */
      } else {
        return Boolean.valueOf(false);
      }
    }
    return true;
  }
}
