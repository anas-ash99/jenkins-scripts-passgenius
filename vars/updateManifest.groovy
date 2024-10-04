
def call(String manifestRepo, String manifestRepoName, String deploymentFilePath, String imageTag, String imageTagName, String gitCredentialsUsr, String gitCredentialsPsw) {
    bat "cd .."

    bat "git clone ${manifestRepo}"

    bat "cd ${manifestRepoName}"

    bat """
        powershell -Command "(Get-Content -Path '${deploymentFilePath}\\deployment.yaml') -replace '${imageTag}:.*', '${imageTag}:${imageTagName}' | Set-Content -Path '${deploymentFilePath}\\deployment.yaml'"
    """

    bat "git add ."

    bat "git commit -m 'update tag image by Jenkins to version ${imageTagName}'"

    bat "git push https://${gitCredentialsUsr}:${gitCredentialsPsw}@github.com/${gitCredentialsUsr}/${manifestRepoName}.git"

    bat "cd .."

    bat "rmdir /S /Q ${manifestRepoName}"
}


