package smrl.mr.owasp;

import java.util.List;
import smrl.mr.language.Action;
import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class OTG_AUTHZ_001b extends MR{
  public boolean mr() {
    String sep = "/";
    for (int par = 0; (par < 3); par++) {
      {
        List<Action> _actions = Operations.Input(1).actions();
        for (final Action action : _actions) {
          {
            int pos = action.getPosition();
            String _urlPath = action.getUrlPath();
            String _plus = (_urlPath + sep);
            Object _RandomFilePath = Operations.RandomFilePath();
            String newUrl = (_plus + _RandomFilePath);
            {
              ifThenBlock();
              if ((((((!Operations.isAdmin(action.getUser())) && 
                Operations.afterLogin(action)) && 
                Operations.EQUAL(Operations.Input(2), Operations.Input(1))) && 
                Operations.Input(2).actions().get(pos).setUrl(newUrl)) && 
                Operations.notTried(action.getUser(), newUrl))) {
                ifThenBlock();
                boolean _TRUE = Operations.TRUE(
                  ((Operations.Output(Operations.Input(2), pos).noFile() || 
                    Operations.userCanRetrieveContent(
                      action.getUser(), 
                      Operations.Output(Operations.Input(2), pos).file())) || 
                    Operations.Output(Operations.Input(2), pos).isError()));
                if (_TRUE) {
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
        sep = (sep + "../");
      }
    }
    return true;
  }
}
