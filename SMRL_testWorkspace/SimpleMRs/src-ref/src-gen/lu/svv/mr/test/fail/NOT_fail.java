package lu.svv.mr.test.fail;

import lu.svv.mr.language.Operations;

import lu.svv.mr.language.MR;

@SuppressWarnings("all")
public class NOT_fail extends MR{
  public boolean mr() {
    boolean _equals = Operations.Input(1).equals(Operations.Input(1));
    if (_equals) {
      return Boolean.valueOf(false);
    }
    return true;
  }
}
