package smrl.mr.owasp;

import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class OTG_SESS_006 extends MR{
  public boolean mr() {
    for (int x = 0; (x < Operations.Input(1).actions().size()); x++) {
      for (int y = 0; (y < x); y++) {
        {
          ifThenBlock();
          if ((((Operations.isLogout(Operations.Input(1).actions().get(x)) && 
            Operations.afterLogin(Operations.Input(1).actions().get(y))) && 
            (!Operations.isLogin(Operations.Input(1).actions().get(y)))) && 
            Operations.EQUAL(Operations.Input(2), Operations.copyActionTo(Operations.Input(1), x, y)))) {
            ifThenBlock();
            boolean _different = Operations.different(Operations.Session(Operations.Input(2), (y - 1)), Operations.Session(Operations.Input(2), y));
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
    }
    return true;
  }
}
