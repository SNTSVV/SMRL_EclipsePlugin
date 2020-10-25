package lu.svv.mr.owasp;

import lu.svv.mr.language.Operations;

import lu.svv.mr.language.MR;

@SuppressWarnings("all")
public class M_A_003 extends MR{
  public boolean mr() {
    for (int i = 0; (i < 10); i++) {
      boolean _equal = Operations.equal(Operations.Input(2), Operations.changeCredentials(Operations.Input(1), Operations.User()));
      if (_equal) {
        boolean _different = Operations.different(Operations.Output(Operations.Input(1)), Operations.Output(Operations.Input(2)));
        if (_different) {
          /* "//PROPERTY HOLDS" */
        } else {
          return Boolean.valueOf(false);
        }
      }
    }
    return true;
  }
}
