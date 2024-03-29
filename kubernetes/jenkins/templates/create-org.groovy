def folder = Jenkins.instance.createProject(jenkins.branch.OrganizationFolder, 'github')
def navigator = new org.jenkinsci.plugins.github_branch_source.GitHubSCMNavigator("SimonStiil")
navigator.traits = [
  // new jenkins.scm.impl.trait.WildcardSCMSourceFilterTrait('go-greetings-app', ""),
  new org.jenkinsci.plugins.github_branch_source.TopicsTrait('jenkins-kubernetes'),
  new org.jenkinsci.plugins.github_branch_source.BranchDiscoveryTrait(1), // Exclude branches that are also filed as PRs.
  new org.jenkinsci.plugins.github_branch_source.OriginPullRequestDiscoveryTrait(1),
  new org.jenkinsci.plugins.github_branch_source.TagDiscoveryTrait(),
]
navigator.credentialsId = "github-login-secret"
folder.navigators.replace(navigator)
buildStrategies = [
  new jenkins.branch.buildstrategies.basic.ChangeRequestBuildStrategyImpl(false,false),
  new jenkins.branch.buildstrategies.basic.BranchBuildStrategyImpl(),
  new jenkins.branch.buildstrategies.basic.SkipInitialBuildOnFirstBranchIndexing(),
  new jenkins.branch.buildstrategies.basic.TagBuildStrategyImpl("-1", "604800000")
]
folder.buildStrategies = new hudson.util.DescribableList(folder,buildStrategies)
folder.addTrigger(new com.cloudbees.hudson.plugins.folder.computed.PeriodicFolderTrigger("1d"))
folder.setOrphanedItemStrategy(new com.cloudbees.hudson.plugins.folder.computed.DefaultOrphanedItemStrategy(true, 7, -1))
folder.save()

//For adding functionality:
//def folder = Jenkins.instance.getItem("github")
//Jenkins.instance.items[0].buildStrategies.owner

// examples:
// https://javadoc.jenkins.io/plugin/branch-api/jenkins/branch/OrganizationFolder.html
// https://javadoc.jenkins.io/plugin/github-branch-source/org/jenkinsci/plugins/github_branch_source/GitHubSCMNavigator.html
// https://javadoc.jenkins.io/plugin/github-branch-source/org/jenkinsci/plugins/github_branch_source/TagDiscoveryTrait.html
