package smrl.mr.owasp;

import java.util.List;
import smrl.mr.language.Action;
import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class OTG_AUTHZ_002a extends MR{
  public boolean mr() {
    List<Action> _actions = Operations.Input(1).actions();
    for (final Action action : _actions) {
      {
        int pos = action.getPosition();
        {
          ifThenBlock();
          if ((((!Operations.isSupervisorOf(Operations.User(), action.getUser())) && 
            Operations.cannotReachThroughGUI(Operations.User(), action.getUrl())) && 
            Operations.EQUAL(Operations.Input(2), Operations.changeCredentials(Operations.Input(1), Operations.User())))) {
            ifThenBlock();
            if ((((Operations.Output(Operations.Input(1), pos).redirectURL() == null) || 
              (Operations.Output(Operations.Input(2), pos).redirectURL() == null)) || 
              Operations.NOT(
                Operations.EQUAL(
                  Operations.Output(Operations.Input(2), pos).redirectURL(), 
                  Operations.Output(Operations.Input(1), pos).redirectURL())))) {
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
