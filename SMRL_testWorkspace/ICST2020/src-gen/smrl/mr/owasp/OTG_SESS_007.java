package smrl.mr.owasp;

import java.util.List;
import smrl.mr.language.Action;
import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class OTG_SESS_007 extends MR{
  public boolean mr() {
    List<Action> _actions = Operations.Input(1).actions();
    for (final Action action : _actions) {
      {
        ifThenBlock();
        if ((((Operations.notAvailableWithoutLoggingIn(action) && 
          Operations.NOT(Operations.NULL(action.getSession()))) && 
          (action.getSession().getTimeout() > 0)) && 
          Operations.EQUAL(Operations.Input(2), 
            Operations.addAction(Operations.Input(1), action.getPosition(), Operations.Wait(action.getSession().getTimeout()))))) {
          ifThenBlock();
          boolean _different = Operations.different(
            Operations.Output(Operations.Input(1), action.getPosition()), 
            Operations.Output(Operations.Input(2), action.getPosition()));
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
