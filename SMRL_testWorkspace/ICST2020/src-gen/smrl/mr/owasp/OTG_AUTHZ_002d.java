package smrl.mr.owasp;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import smrl.mr.language.Action;
import smrl.mr.language.Operations;

import smrl.mr.language.MR;

@SuppressWarnings("all")
public class OTG_AUTHZ_002d extends MR{
  public boolean mr() {
    for (int x = 0; (Operations.Input(1).containFormInputForFilePath() && (x < Operations.Input(1).actions().size())); x++) {
      {
        Action action = Operations.Input(1).actions().get(x);
        Object randomPath = Operations.RandomAdminFilePath();
        JsonArray formInputs = action.getFormInputs();
        for (int i = 0; (action.containFormInputForFilePath() && (i < formInputs.size())); i++) {
          {
            JsonObject formInput = action.getFormInputs().get(i).getAsJsonObject();
            {
              ifThenBlock();
              if (((((!Operations.isAdmin(action.getUser())) && 
                Operations.isFormInputForFilePath(formInput)) && 
                Operations.EQUAL(Operations.Input(2), Operations.Input(1))) && 
                Operations.updateStringFormInput(Operations.Input(2).actions().get(x).getFormInputs().get(i).getAsJsonObject(), randomPath))) {
                ifThenBlock();
                boolean _OR = Operations.OR(
                  Operations.isError(Operations.Output(Operations.Input(1))), 
                  Operations.different(
                    Operations.Output(Operations.Input(1)), 
                    Operations.Output(Operations.Input(2))));
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
    }
    return true;
  }
}
