// Create Workflow GIT Job 
// Docs:
// https://javadoc.jenkins.io/jenkins/model/Jenkins.html#createProject(hudson.model.TopLevelItemDescriptor,java.lang.String)
// https://javadoc.jenkins.io/plugin/workflow-job/org/jenkinsci/plugins/workflow/job/WorkflowJob.html
// https://javadoc.jenkins.io/plugin/workflow-api/org/jenkinsci/plugins/workflow/flow/FlowDefinition.html
// https://javadoc.jenkins.io/plugin/workflow-cps/org/jenkinsci/plugins/workflow/cps/CpsScmFlowDefinition.html
// https://javadoc.jenkins.io/plugin/git/hudson/plugins/git/GitSCM.html
// https://javadoc.jenkins.io/plugin/git/hudson/plugins/git/UserRemoteConfig.html
// https://javadoc.jenkins.io/plugin/git/hudson/plugins/git/BranchSpec.html

gitConfig = new hudson.plugins.git.UserRemoteConfig("https://github.com/SimonStiil/repository-cleanup.git", null, null, "github-login-secret")
scm = new hudson.plugins.git.GitSCM([gitConfig], [new hudson.plugins.git.BranchSpec("*/main")] , null, null, [])
definition = new org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition(scm, "Jenkinsfile")
definition.setLightweight(true)
newJob = Jenkins.instance.createProject(org.jenkinsci.plugins.workflow.job.WorkflowJob, "repository-cleanup")
newJob.setDefinition(definition)
newJob.save()

gitConfig = new hudson.plugins.git.UserRemoteConfig("https://github.com/SimonStiil/deployment-cleanup.git", null, null, "github-login-secret")
scm = new hudson.plugins.git.GitSCM([gitConfig], [new hudson.plugins.git.BranchSpec("*/main")] , null, null, [])
definition = new org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition(scm, "Jenkinsfile")
definition.setLightweight(true)
newJob = Jenkins.instance.createProject(org.jenkinsci.plugins.workflow.job.WorkflowJob, "deployment-cleanup")
newJob.setDefinition(definition)
newJob.save()

// Decompiling an old job

println(Jenkins.instance.getItems())
Definition = Jenkins.instance.getItemByFullName("repository-cleanup").getDefinition()
println(Definition.isLightweight())
git = Definition.getScm()
println(git)
UserRemoteConfig = git.getUserRemoteConfigs()[0]
println(UserRemoteConfig.getUrl())
println(UserRemoteConfig.getName())
println(UserRemoteConfig.getRefspec())
println(UserRemoteConfig.getCredentialsId())
println(git.getBranches())
println(git.getDoGenerateSubmoduleConfigurations())
println(git.getSubmoduleCfg())
println(git.getBrowser())
println(git.getGitTool())
println(git.getExtensions())
println(Definition.getScriptPath())