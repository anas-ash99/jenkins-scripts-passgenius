
def call( String deploymentFilePath, String imageTag, String imageTagName, String gitCredentialsUsr, String gitCredentialsPsw, String manifestRepoName = "deployment-manifest-passgenius") {

    // Default repository URL
    def manifestRepoURL = "https://github.com/anas-ash99/${manifestRepoName}"

    bat """
        rmdir /S /Q ${manifestRepoName}
        cd ..  
        git clone ${manifestRepoURL}
        cd ${manifestRepoName}
        powershell -Command "(Get-Content -Path '${deploymentFilePath}\\deployment.yaml') -replace '${imageTag}:.*', '${imageTag}:${imageTagName}' | Set-Content -Path '${deploymentFilePath}\\deployment.yaml'"
        git add .
        git commit -m 'update tag image by Jenkins to version ${imageTagName}'
        git push https://${gitCredentialsUsr}:${gitCredentialsPsw}@github.com/${gitCredentialsUsr}/${manifestRepoName}.git
        rmdir /S /Q ${manifestRepoName}
    """


}


