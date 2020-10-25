package smrl.mr.owasp;

import java.util.List;
import smrl.mr.language.Action;
import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class OTG_AUTHZ_004 extends MR{
  public boolean mr() {
    List<Action> _actions = Operations.Input(1).actions();
    for (final Action action : _actions) {
      for (int par = 0; (par < action.getParameters().size()); par++) {
        {
          int pos = action.getPosition();
          {
            ifThenBlock();
            if ((Operations.EQUAL(Operations.Input(2), Operations.Input(1)) && Operations.Input(2).actions().get(pos).setParameterValue(par, 
              Operations.RandomValue(Operations.typeOf(action.getParameterValue(par)))))) {
              ifThenBlock();
              boolean _OR = Operations.OR(Operations.Output(Operations.Input(2), pos).isError(), 
                Operations.userCanRetrieveContent(action.getUser(), Operations.Output(Operations.Input(2), pos)));
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
    }
    return true;
  }
}
