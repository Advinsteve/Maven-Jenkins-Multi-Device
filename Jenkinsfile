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
    }

    stages {
        stage('Build') {
            script {
                def allureResultsDir = "${env.WORKSPACE}/allure-results"
                if (fileExists(allureResultsDir)) {
                    echo "Directory 'allure-results' found. Deleting it before generating the report."
                    sh "rm -rf ${allureResultsDir}"
                } else {
                    echo "Directory 'allure-results' not found. Proceeding to generate the report."
                }
            }
            steps {
                sh 'mvn -version'
                sh 'mvn clean'
                sh 'pwd'
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
                    -Dcloud=${CLOUD}
                """
            }
        }
    }

    post {
        always {
            sh 'echo "Generating reports..."'
            sh '${ALLURE} --version'
            sh '${ALLURE} serve'
            sh 'pwd'
            sh '''
                ${ALLURE} serve & 
                echo $! > allure-server.pid
            '''
        }
    }
}
