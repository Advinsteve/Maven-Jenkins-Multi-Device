pipeline {
    agent any
    
    environment {
        MAVEN_HOME = "/usr/share/maven" 
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
                sh '${MAVEN_HOME}/bin/mvn clean' 
            }
        }
        stage('Test') {
            steps {
                sh """
                    ${MAVEN_HOME}/bin/mvn test \
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
