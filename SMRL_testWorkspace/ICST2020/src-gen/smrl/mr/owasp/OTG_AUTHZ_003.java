package smrl.mr.owasp;

import java.util.List;
import smrl.mr.language.Action;
import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class OTG_AUTHZ_003 extends MR{
  public boolean mr() {
    List<Action> _actions = Operations.Input(1).actions();
    for (final Action action : _actions) {
      for (int par = 0; (par < action.getParameters().size()); par++) {
        {
          int pos = action.getPosition();
          {
            ifThenBlock();
            if (((Operations.isUserIdParameter(action, par, action.getUser()) && (Operations.equal(Operations.Input(2), Operations.Input(1)) && Operations.Input(2).actions().get(pos).setParameterValue(par, Operations.User()))) && Operations.equal(Operations.Input(3), Operations.changeCredentials(Operations.Input(1), Operations.User())))) {
              ifThenBlock();
              boolean _different = Operations.different(Operations.Output(Operations.Input(2), pos), Operations.Output(Operations.Input(3), pos));
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
