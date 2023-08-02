# SMRL_EclipsePlugin

This project contains all the XText-based plugins necessary to have an Editor for SMRL in Eclipse.

Tested with Xtext 2.16 and 2.23.

Folder SMRL_testWorkspace is not a source project, it is supposed to be used when testing the Eclipse plugin as workspace root.


For more information https://sntsvv.github.io/SMRL/


## Installing a pre-compiled version of the SMRL Eclipse plugin

1. Install Eclipse for Java developers

2. Download [SMRL-Eclipse-Plugins.zip](https://zenodo.org/record/5562254/files/SMRL-Eclipse-Plugins.zip?download=1)

3. Uncompress the downloaded zip, it will create the folder "SMRL-export"

4. Start Eclipse

5. Do Help > Install New Software

6. Next to "Work with" select "-- All available sites --"

7. Under "Modeling" select "Xtext complete SDK"

8. Click on "Next",  "Next", select "I accept the terms of this licence agreement", "Finish", and "Restart now"

9. After Eclipse is restanted, do "Help > Install New Software"

10. Click on "Add.."

11. Click on "Local repository"

12. Select the folder "SMRL-export", provide the name SMRL to the repository, and click on "Add" as in the following picture.

![Add Repository](/Documentation/images/AddRepository.png)

13. In the "Install" window, unselect "Group items by category", and select SMRL as in the following

![Install](/Documentation/images/Install2.png)

14. Click on "Next",  "Next", select "I accept the terms of this licence agreement", "Finish", and "Restart now"

15. Testing the installation:
16. Open a workspace with a SMRL prject
17. Open a ".smrl" file, no syntax error should be shown
18. Verify that the "src-gen" folder of teh project contains a ".java" file with the same name as the ".smrl" file above.

## Using the SMRL Eclipse plugin

You can test the framework by replication the demo that we have shown at ICSE 2020. For that, please download and import into Eclipse the SMRL project at https://zenodo.org/record/5562254/files/EclipseProjectSMRL.zip?download=1

The demo can be replicated by executing JUnit test cases. However, before executing the test, you have to download and run the virtal machine provided in our replicability package (see https://sntsvv.github.io/SMRL/ link to https://zenodo.org/record/4752931)

![SMRL Executing JUnit Test](/Documentation/images/SMRL_Test.png)

The exection of the test case should lead to a failure that indicates the presence of a (real) vulnerability in Jenkins, as shown in the following images.

![SMRL Test Execution Result](/Documentation/images/SMRL_TestExecution.png)

You can install the latest version of our MST/SMRL library to observe an improved output, as shown in the following image.

To install the latest version of MST, you need to:
1. Download the precompiled MST library jar from https://github.com/SNTSVV/SMRL_EclipsePlugin/blob/master/MST-1.0.0-jar-with-dependencies.jar or
    1. Clone https://github.com/MetamorphicSecurityTesting/MST
    1. Compile it according to instructions
1. Copy the MST library jar to OWASP_MR_SET/lib
1. In OWASP_MR_SET remove SMRL.jar from the build path and add the MST library jar.

The console output in the figure below provides the following information:
1. The failure was detected when testing the MR OTG_AUTHZ_002 (see JUnit tab).
1. The inputs used when the failure was observed are: Input(2), which is a follow-up input, and Input(1), which is a source input. They differ for the user perfoming the action (i.e., user1 VS admin), as specified in line 34 of the MR.
1. The execution of the metamorphic relation lead to the collection of output information for the following inputs, in the given order, that is
    1. Input(1); indeed, it is requested in line 37 of the MR
    1. Input(1); indeed, it is the first input requsted in line 38 of the MR
    1. Input(2); indeed, it is the second input requsted in line 38 of the MR    
1. For all the inputs above, the action verified by the 'Output' call is the third Action (i.e., the one that acesses http://192.168.56.102:8080/computer/slave1/launchSlaveAgent ). It means that the failure is observed when verifying the output for the fourth action (i.e., action number 3, actions are enumerated counting from 0). This happens within the iteration in Line 30. 

The information above enables the end-user to understand the problem, that is, an unauthorized user (i.e., (user1,user1Pass) ), can access a URL he should not (i.e., http://192.168.56.102:8080/computer/slave1/launchSlaveAgent what is accessed by action number 3, the fourth action). This is what characterize a real vunerability affecting Jenkis (see https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2018-1999004).

![SMRL Test Execution Result](/Documentation/images/SMRL_TestExecution_Improved.png)


A project with a larger catalog of MRs is available at: https://zenodo.org/record/7702754/files/Software.zip?download=1


## Compiling the SMRL Eclipse plugin (only for contributors)

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

