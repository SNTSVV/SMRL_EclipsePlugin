package smrl.mr.owasp;

import java.util.List;
import smrl.mr.language.Action;
import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class OTG_AUTHZ_002 extends MR{
  public boolean mr() {
    List<Action> _actions = Operations.Input(1).actions();
    for (final Action action : _actions) {
      {
        ifThenBlock();
        if ((((!Operations.isSupervisorOf(Operations.User(), action.getUser())) && 
          Operations.cannotReachThroughGUI(Operations.User(), action.getUrl())) && Operations.EQUAL(Operations.Input(2), Operations.changeCredentials(Operations.Input(1), Operations.User())))) {
          ifThenBlock();
          boolean _OR = Operations.OR(
            Operations.isError(Operations.Output(Operations.Input(1), action.getPosition())), 
            Operations.NOT(Operations.Output(Operations.Input(1), action.getPosition()).equals(Operations.Output(Operations.Input(2), action.getPosition()))));
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
    return true;
  }
}
