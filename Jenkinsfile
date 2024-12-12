pipeline {
    agent any

    environment {
        MAVEN_HOME = "/usr/share/maven" 
        PATH = "$PATH:$MAVEN_HOME/bin"
        ALLURE = "/usr/bin/allure"
        USERNAME = "${USERNAME}"  
        APIKEY = "${APIKEY}"      
        APPIUM_VERSION = "${APPIUM_VERSION}" 
        ANDROID_APPLICATION = "${ANDROID_APPLICATION}"
        IOS_APPLICATION = "${IOS_APPLICATION}"
        ANDROID_APPPACKAGE = "${ANDROID_APPPACKAGE}"
        ANDROID_APPACTIVITY = "${ANDROID_APPACTIVITY}"
        IOS_BUNDLEID = "${IOS_BUNDLEID}"
        CLOUD = "${CLOUD}"
        PROJECT_NAME="${PROJECT_NAME}"
        BUILD_NAME="${BUILD_NAME}"
        TEST_NAME="${TEST_NAME}"
        TAG_NAME="${TAG_NAME}"
    }

    stages {
        stage('Build') {
            steps {
				 script {
                    def allureResultsDir = "${env.WORKSPACE}/allure-results"
                    if (fileExists(allureResultsDir)) {
                        echo "Directory 'allure-results' found. Deleting it before generating the report."
                        sh "rm -rf ${allureResultsDir}"
                    } else {
                        echo "Directory 'allure-results' not found. Proceeding to generate the report."
                    }
                }
                sh 'mvn -version'
                sh 'mvn clean'
            }
        }
        stage('Test') {
            steps {
                sh """
                    mvn test \
                    -Dusername=${USERNAME} \
                    -DapiKey=${APIKEY} \
                    -DappiumVersion=${APPIUM_VERSION} \
                    -DandroidApplication=${ANDROID_APPLICATION} \
                    -DiosApplication=${IOS_APPLICATION} \
                    -DandroidAppPackage=${ANDROID_APPPACKAGE} \
                    -DandroidAppActivity=${ANDROID_APPACTIVITY} \
                    -DiosBundleId=${IOS_BUNDLEID} \
                    -Dcloud=${CLOUD} \
                    -DprojectName= ${PROJECT_NAME}\
                    -DbuildName=${BUILD_NAME} \
                    -DtestName=${TEST_NAME} \
                    -DtagName=${TAG_NAME}
                """
            }
        }
    }
     post {
        always {
            sh 'echo "Generating reports..."'
            sh '${ALLURE} --version'
            sh '${ALLURE} serve'
        }
    }

}
