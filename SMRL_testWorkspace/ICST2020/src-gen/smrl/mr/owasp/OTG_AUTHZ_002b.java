package smrl.mr.owasp;

import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class OTG_AUTHZ_002b extends MR{
  public boolean mr() {
    for (int x = 0; (x < Operations.Input(1).actions().size()); x++) {
      for (int y = (x + 1); (Operations.isLogin(Operations.Input(1).actions().get(x)) && (y < Operations.Input(1).actions().size())); y++) {
        {
          ifThenBlock();
          if ((((((((!Operations.isSupervisorOf(Operations.User(), Operations.Input(1).actions().get(y).getUser())) && 
            Operations.cannotReachThroughGUI(Operations.User(), Operations.Input(1).actions().get(y).getUrl())) && 
            Operations.EQUAL(Operations.Input(2), Operations.Input(1).actions().get(x))) && 
            Operations.EQUAL(Operations.Input(3), Operations.changeCredentials(Operations.Input(2), Operations.User()))) && 
            Operations.EQUAL(Operations.Input(4), Operations.addAction(Operations.Input(1), y, Operations.Input(3).actions().get(0)))) && 
            Operations.EQUAL(Operations.Input(5), Operations.addAction(Operations.Input(4), (y + 1), Operations.Input(1).actions().get(y)))) && 
            Operations.EQUAL(Operations.Input(6), Operations.addAction(Operations.Input(5), (y + 2), Operations.Input(1).actions().get(x))))) {
            ifThenBlock();
            boolean _EQUAL = Operations.EQUAL(
              Operations.Output(Operations.Input(1), y), 
              Operations.Output(Operations.Input(6), (y + 3)));
            if (_EQUAL) {
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
