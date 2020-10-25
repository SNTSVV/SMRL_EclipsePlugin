package smrl.mr.owasp;

import java.util.List;
import smrl.mr.language.Action;
import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class OTG_CRYPST_004 extends MR{
  public boolean mr() {
    List<Action> _actions = Operations.Input(1).actions();
    for (final Action action : _actions) {
      {
        ifThenBlock();
        if (((Operations.isEncrypted(action) && 
          Operations.EQUAL(Operations.Input(2), Operations.Input(1))) && 
          Operations.Input(2).actions().get(action.getPosition()).setEncryption(Operations.WeakEncryption()))) {
          ifThenBlock();
          boolean _different = Operations.different(Operations.Output(Operations.Input(1)), Operations.Output(Operations.Input(2)));
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
