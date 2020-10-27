# SMRL_EclipsePlugin

This project contains all the XText-based plugins necessary to have an Editor for SMRL in Eclipse.

Tested with Xtext 2.16 and 2.23.

Folder SMRL_testWorkspace is not a source project, it is supposed to be used when testing the Eclipse plugin as workspace root.


For more information https://sntsvv.github.io/SMRL/

## Setup instructions

Import all the projects except SMRL_testWorkspace as Eclipse projects.

After the projects are recompiled you need to update runtime module. Please follow the instructions in /lu.svv.lang/src-custom/lu/svv/lang/SMRLJvmModelGenerator.java

To test the plugin in the development environment please setup an Eclipse Application configuration as in the following picture (note the Workspace location)
