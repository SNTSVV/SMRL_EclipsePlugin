package smrl.mr.owasp;

import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class M_A_003 extends MR{
  public boolean mr() {
    for (int i = 0; (i < 10); i++) {
      {
        ifThenBlock();
        boolean _equal = Operations.equal(Operations.Input(2), Operations.changeCredentials(Operations.Input(1), Operations.User()));
        if (_equal) {
          ifThenBlock();
          boolean _different = Operations.different(Operations.Output(Operations.Input(1)), Operations.Output(Operations.Input(2)));
          if (_different) {
            expressionPass(); /* //PROPERTY HOLDS" */
          } else {
            return Boolean.valueOf(false);
          }
        } else {
          expressionPass(); /* //PROPERTY HOLDS" */
        }
      }
    }
    return true;
  }
}
