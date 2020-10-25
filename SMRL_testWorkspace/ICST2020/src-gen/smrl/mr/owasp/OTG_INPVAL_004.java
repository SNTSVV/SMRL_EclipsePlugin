package smrl.mr.owasp;

import java.util.List;
import smrl.mr.language.Action;
import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class OTG_INPVAL_004 extends MR{
  public boolean mr() {
    List<Action> _actions = Operations.Input(1).actions();
    for (final Action action : _actions) {
      for (int par = 0; (par < action.getParameters().size()); par++) {
        {
          int pos = action.getPosition();
          {
            ifThenBlock();
            if ((Operations.EQUAL(Operations.Input(2), Operations.Input(1)) && 
              Operations.Input(2).actions().get(pos).addParameter(
                action.getParameterName(par), 
                action.getParameterValue(par)))) {
              ifThenBlock();
              boolean _EQUAL = Operations.EQUAL(Operations.Output(Operations.Input(1), pos), Operations.Output(Operations.Input(2), pos));
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
    }
    return true;
  }
}
