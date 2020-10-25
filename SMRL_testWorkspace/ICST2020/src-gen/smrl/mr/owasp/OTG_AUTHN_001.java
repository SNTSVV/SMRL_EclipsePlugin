package smrl.mr.owasp;

import java.util.List;
import smrl.mr.language.Action;
import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class OTG_AUTHN_001 extends MR{
  public boolean mr() {
    List<Action> _actions = Operations.Input(1).actions();
    for (final Action action : _actions) {
      {
        int pos = action.getPosition();
        {
          ifThenBlock();
          if (((Operations.isLogin(action) && Operations.EQUAL(Operations.Input(2), Operations.Input(1))) && Operations.Input(2).actions().get(action.getPosition()).setChannel("http"))) {
            ifThenBlock();
            boolean _OR = Operations.OR(
              Operations.NOT(Operations.isEncrypted(action)), 
              Operations.different(Operations.Output(Operations.Input(1), pos), Operations.Output(Operations.Input(2), pos)));
            if (_OR) {
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
