# SMRL_EclipsePlugin

This project contains all the XText-based plugins necessary to have an Editor for SMRL in Eclipse.

Tested with Xtext 2.16 and 2.23.

Folder SMRL_testWorkspace is not a source project, it is supposed to be used when testing the Eclipse plugin as workspace root.


For more information https://sntsvv.github.io/SMRL/

## Setup instructions

Import all the projects except SMRL_testWorkspace as Eclipse projects.

![SMRL Workspace Configuration](/Documentation/images/SMRL_WorkspaceSetup.png)


After the projects are recompiled you need to update runtime module. Please follow the instructions in /lu.svv.lang/src-custom/lu/svv/lang/SMRLJvmModelGenerator.java

To test the plugin in the development environment please setup an Eclipse Application configuration as in the following picture (note the Workspace location)

![SMRL Test Configuration](/Documentation/images/SMRL_EclipsePlugin_TestConfiguration.png)

After sucesfuly executing the plugin you should be able to see the following editor when opening a MR.

![SMRL Editor](/Documentation/images/SMRL_Editor.png)

Please try to edit the MR (e.g., delete a white space) and save it. If the plugn is correctly compiled you should see the followng compiled code. 

![SMRL Generated Code](/Documentation/images/SMRL_GeneratedCode.png)

If you forgot to update the runtime module as per SMRLJvmModelGenerator.java, the generated code will include an invocation of IMPLIES instead of a set of nested if conditions.

