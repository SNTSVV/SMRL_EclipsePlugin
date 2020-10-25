package smrl.mr.owasp;

import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class OTG_AUTHZ_002c extends MR{
  public boolean mr() {
    for (int y = (Operations.Input(1).actions().size() - 1); (y > 0); y--) {
      {
        ifThenBlock();
        if (((((!Operations.isSupervisorOf(Operations.User(), Operations.Input(1).actions().get(y).getUser())) && 
          Operations.afterLogin(Operations.Input(1).actions().get(y))) && 
          Operations.cannotReachThroughGUI(Operations.User(), Operations.Input(1).actions().get(y).getUrl())) && 
          Operations.EQUAL(Operations.Input(2), Operations.Input(Operations.LoginAction(Operations.User()), Operations.Input(1).actions().get(y))))) {
          ifThenBlock();
          boolean _OR = Operations.OR(
            Operations.isError(Operations.Output(Operations.Input(1), y)), 
            Operations.different(
              Operations.Output(Operations.Input(1), y), 
              Operations.Output(Operations.Input(2), 1)));
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
