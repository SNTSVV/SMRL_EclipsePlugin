package smrl.mr.owasp;

import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class OTG_AUTHZ_002e extends MR{
  public boolean mr() {
    for (int x = 0; (x < Operations.Input(1).actions().size()); x++) {
      for (int y = (x + 1); (Operations.isLogin(Operations.Input(1).actions().get(x)) && (y < Operations.Input(1).actions().size())); y++) {
        {
          ifThenBlock();
          if ((((((!Operations.isSupervisorOf(Operations.User(), Operations.Input(1).actions().get(y).getUser())) && 
            Operations.cannotReachThroughGUI(Operations.User(), Operations.Input(1).actions().get(y).getUrl())) && 
            Operations.EQUAL(Operations.Input(2), Operations.Input(1).actions().get(x))) && 
            Operations.EQUAL(Operations.Input(3), Operations.changeCredentials(Operations.Input(2), Operations.User()))) && 
            Operations.EQUAL(Operations.Input(4), Operations.addAction(Operations.Input(1), y, Operations.Input(3).actions().get(0))))) {
            ifThenBlock();
            boolean _OR = Operations.OR(
              Operations.userCanRetrieveContent(Operations.Input(4).actions().get((y + 1)).getUser(), Operations.Output(Operations.Input(4), (y + 1))), 
              Operations.Output(Operations.Input(4), (y + 1)).isError());
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
