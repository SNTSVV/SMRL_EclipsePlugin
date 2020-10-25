package lu.svv.mr.test.fail;

import lu.svv.mr.language.Operations;

import lu.svv.mr.language.MR;

@SuppressWarnings("all")
public class TRUE_fail extends MR{
  public boolean mr() {
    boolean _equals = Operations.Input(1).equals(Operations.Input(2));
    if (_equals) {
      /* "//PROPERTY a HOLDS" */
    } else {
      return Boolean.valueOf(false);
    }
    return true;
  }
}
