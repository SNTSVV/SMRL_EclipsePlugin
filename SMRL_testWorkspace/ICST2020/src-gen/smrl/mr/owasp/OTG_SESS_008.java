package smrl.mr.owasp;

import java.util.List;
import smrl.mr.language.Action;
import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class OTG_SESS_008 extends MR{
  public boolean mr() {
    List<Action> _actions = Operations.Input(1).actions();
    for (final Action action : _actions) {
      {
        ifThenBlock();
        if (((Operations.notAvailableWithoutLoggingIn(action) && 
          Operations.NOT(Operations.NULL(Operations.ActionAvailableWithoutLogin().getSession()))) && 
          Operations.EQUAL(Operations.Input(2), Operations.Input(Operations.ActionAvailableWithoutLogin(), action)))) {
          ifThenBlock();
          boolean _different = Operations.different(Operations.Output(Operations.Input(1), action.getPosition()), Operations.Output(Operations.Input(2), 1));
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
