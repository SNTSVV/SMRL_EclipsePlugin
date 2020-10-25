package smrl.mr.owasp;

import java.util.List;
import smrl.mr.language.Action;
import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class OTG_AUTHN_010 extends MR{
  public boolean mr() {
    List<Action> _actions = Operations.Input(1).actions();
    for (final Action action : _actions) {
      {
        int pos = action.getPosition();
        {
          ifThenBlock();
          if ((((Operations.afterLogin(action) && (!Operations.Input(1).actions().get(pos).getChannel().equals("http"))) && Operations.EQUAL(Operations.Input(2), Operations.Input(1))) && Operations.Input(2).actions().get(pos).setChannel("http"))) {
            ifThenBlock();
            boolean _different = Operations.different(Operations.Output(Operations.Input(1), pos), Operations.Output(Operations.Input(2), pos));
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
