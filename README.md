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


You can test the framework by replication the demo we have shown at ICSE 2020. Please run the corresponding JUnit test case as in the following picture.
Before executing the test, you have to download and run the virtal machine provided in our replicability package (see https://sntsvv.github.io/SMRL/ link to https://zenodo.org/record/4752931)

![SMRL Executing JUnit Test](/Documentation/images/SMRL_Test.png)

The exection of teh test case should lead to a failure that indicates the presence of a (real) vulnerability in Jenkins, as shown in the following images.

![SMRL Test Execution Result](/Documentation/images/SMRL_TestExecution.png)

In case you install the latest version of SMRL.java, you will observe an improved output, as shown in the following image.

To install the latest version of 'SMRL.jar', you need to download SMRL_Library and compile it using ANT. It will generate a file 'SMRL.jar' that should be copied in OWASP_MR_SET/lib.

The output provided in the figure below provides the following information:
1. The failure was detected when testing the MR OTG_AUTHZ_002 (see JUnit tab).
1. The inputs used when the falures was observed are Input(2), which is a follow-up input, and Input(1), which is a source input. They differ for the user perfoming the action (i.e., user1 VS admin), as specified in line 34 of the MR.
1. The execution of the metamorphic relation lead to the collection of output information for the following inputs, in the given order, that is
    1. Input(1), indeed it is requested in line 37 of the MR
    1. Input(1), indeed it is the first input requsted in line 38 of the MR
    1. Input(2), indeed it is the second input requsted in line 38 of the MR    
1. For all the inputs above, the action verified by the 'Output' call is the third Action (i.e., the one that acesses http://192.168.56.102:8080/computer/slave1/launchSlaveAgent ). It means that the failure is observed when verifying the output for the third action (see iteration in Line 30). 

The information above enables the end-user to understand the problem, that is, an unauthorized user (i.e., (user1,user1Pass) ), can access a URL he should not (i.e., http://192.168.56.102:8080/computer/slave1/launchSlaveAgent). This is what characterize a real vunerability affecting Jenkis (see https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2018-1999004).

![SMRL Test Execution Result](/Documentation/images/SMRL_TestExecution_Improved.png)
