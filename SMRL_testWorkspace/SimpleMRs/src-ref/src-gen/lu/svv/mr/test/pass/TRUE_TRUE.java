package lu.svv.mr.test.pass;

import lu.svv.mr.language.Operations;

import lu.svv.mr.language.MR;

@SuppressWarnings("all")
public class TRUE_TRUE extends MR{
  public boolean mr() {
    boolean _TRUE = Operations.TRUE(
      Operations.equal(Operations.Input(1), Operations.Input(2)));
    if (_TRUE) {
      /* "//PROPERTY a HOLDS" */
    } else {
      return Boolean.valueOf(false);
    }
    return true;
  }
}
