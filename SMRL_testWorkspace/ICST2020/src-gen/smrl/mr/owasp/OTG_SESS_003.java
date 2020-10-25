package smrl.mr.owasp;

import java.util.List;
import smrl.mr.language.Action;
import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class OTG_SESS_003 extends MR{
  public boolean mr() {
    List<Action> _actions = Operations.Input(1).actions();
    for (final Action signup : _actions) {
      for (int i = 0; (Operations.isSignup(signup) && (i < Operations.Input(2).actions().size())); i++) {
        {
          Action f = Operations.Input(2).actions().get(i);
          int pos = f.getPosition();
          {
            ifThenBlock();
            if ((Operations.afterLogin(f) && 
              Operations.EQUAL(Operations.Input(3), Operations.addAction(Operations.Input(2), (pos + 1), signup)))) {
              ifThenBlock();
              boolean _different = Operations.different(Operations.Output(Operations.Input(3), pos).getSession(), 
                Operations.Output(Operations.Input(3), (pos + 1)).getSession());
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
    }
    return true;
  }
}
