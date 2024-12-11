pipeline {
    agent any
    
    environment {
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
            steps {

                sh 'export PATH=/var/jenkins_home/abhinav/apache-maven-3.9.5/bin:$PATH'
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
                    -Dcloud=${CLOUD}
                """
            }
        }
    }
}
