<!DOCTYPE html>
<html lang="en">
<body>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jenkins Pipeline Configuration README</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            background-color: #121212;
            color: #ffffff;
            padding: 20px;
        }
        h1, h2 {
            color: #90caf9;
        }
        code {
            background-color: #1e1e1e;
            border: 1px solid #333;
            padding: 5px;
            font-size: 1.1em;
            display: inline-block;
            margin: 4px 0;
            color: #ffcc00;
        }
        pre {
            background-color: #1e1e1e;
            border: 1px solid #333;
            padding: 10px;
            font-size: 1em;
            overflow-x: auto;
            color: #ffcc00;
        }
        ul {
            margin: 20px 0;
            padding: 0 20px;
        }
        .section {
            margin-bottom: 30px;
        }
        a {
            color: #81d4fa;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        .header {
            display: flex;
            flex-direction: row;
            align-items: center;
        }
        .header img {
            max-width: 100%;
            margin-right: 15px;
        }
    </style>

</head>
    <h1 class="header">
        <a target="_blank" rel="noopener noreferrer" href="https://www.pcloudy.com">
            <img src="./images/logo.webp" alt="pCloudy">
        </a>
        <span>pCloudy Jenkins Sample Projects</span>
    </h1>
    <div class="section">
        <h2>About <a href="https://www.pcloudy.com" target="_blank">pCloudy</a></h2>
        <p>pCloudy platform provides single click access to real Android and iOS devices directly from your browser. Use these real Mobile Devices to click-and-perform Manual Testing and Automation Testing for your App. Integrate our platform with CI for continuous Automation Testing and test your App on multiple real Mobile Devices with every change of your App.</p>
        <p>pCloudy is a popular mobile testing platform integrated with Appium script which enables you to automate test of mobile apps as well.</p>
        <p>Read more here: <a href="https://www.pcloudy.com" target="_blank">https://www.pcloudy.com</a></p>
    </div>
    <div class="section">
        <h2>1. Host the Jenkins Server</h2>
        <p>Follow these steps to host the Jenkins server:</p>
        <ul>
            <li>Install Java (preferably OpenJDK 11 or higher) on your system.</li>
            <li>Download the Jenkins WAR file from the <a href="https://www.jenkins.io/download/" target="_blank">official Jenkins website</a>.</li>
            <li>Run the Jenkins server using the command:
                <pre><code>java -jar jenkins.war</code></pre>
            </li>
            <li>Access Jenkins in your browser at <a href="http://localhost:8080" target="_blank">http://localhost:8080</a>.</li>
            <li>Complete the initial setup by unlocking Jenkins and installing the recommended plugins.</li>
        </ul>
    </div>
    <div class="section">
        <h2>2. Configure the Pipeline</h2>
        <p>To configure a Jenkins pipeline:</p>
        <ul>
            <li>Create a new pipeline job in Jenkins</li>
            <li>Follow the <a href="https://www.pcloudy.com/docs/jenkins" target="_blank">Dcox</a></li>
        </ul>
    </div>
    <div class="section">
        <h2>3. Add Parameter Configuration</h2>
        <p>To add parameters to your pipeline job:</p>
        <ul>
            <li>Click on <strong>Configure</strong> for your pipeline job.</li>
            <li>Scroll down to the <strong>General</strong> section and check <strong>This project is parameterized</strong>.</li>
            <li>Click <strong>Add Parameter</strong> and add the following parameters:</li>
            <ul>
                <li><strong>String Parameter:</strong>
                    <ul>
                        <li>Name: <code>USERNAME</code></li>
                        <li>Description: * Enter username</li>
                    </ul>
                </li>
                <li><strong>Password Parameter:</strong>
                    <ul>
                        <li>Name: <code>APIKEY</code></li>
                        <li>Description: * Enter APi key</li>
                    </ul>
                </li>
                 <li><strong>Choice Parameter:</strong>
                    <ul>
                        <li>Name: <code>APPIUM_VERSION</code></li>
                        <li>Description:* Select appium Version</li>
                        <li>Choices: 1.22.0,1.21.0,1.20.2,1.19.0</li>
                    </ul>
                </li>
                <li><strong>String Parameter:</strong>
                    <ul>
                        <li>Name: <code>ANDROID_APPLICATION</code></li>
                        <li>Description: Enter Android Application name for test</li>
                        <li>Default value: null</li>
                    </ul>
                </li>
                 <li><strong>String Parameter:</strong>
                    <ul>
                        <li>Name: <code>IOS_APPLICATION</code></li>
                        <li>Description: Enter iso Application name</li>
                        <li>Default value: null</li>
                    </ul>
                </li>
                <li><strong>String Parameter:</strong>
                    <ul>
                        <li>Name: <code>ANDROID_APPPACKAGE</code></li>
                        <li>Description:Enter Android Application package name</li>
                        <li>Default value: null</li>
                    </ul>
                </li>
                 <li><strong>String Parameter:</strong>
                    <ul>
                        <li>Name: <code>ANDROID_APPACTIVITY</code></li>
                        <li>Description: Enter Android Application activity name</li>
                        <li>Default value: null</li>
                    </ul>
                </li>
                <li><strong>String Parameter:</strong>
                    <ul>
                        <li>Name: <code>IOS_BUNDLEID</code></li>
                        <li>Description:Enter IOS Application bundle id</li>
                        <li>Default value: null</li>
                    </ul>
                </li>
                 <li><strong>String Parameter:</strong>
                    <ul>
                        <li>Name: <code>CLOUD</code></li>
                        <li>Description: * Enter cloud name</li>
                    </ul>
                </li>
                <li><strong>String Parameter:</strong>
                    <ul>
                        <li>Name: <code>PROJECT_NAME</code></li>
                        <li>Description: * Enter Project name for PR Report</li>
                    </ul>
                </li>
                 <li><strong>String Parameter:</strong>
                    <ul>
                        <li>Name: <code>BUILD_NAME</code></li>
                        <li>Description: * Enter build name name for PR Report</li>
                    </ul>
                </li>
                <li><strong>String Parameter:</strong>
                    <ul>
                        <li>Name: <code>TEST_NAME</code></li>
                        <li>Description: * Enter test name name for PR Report</li>
                    </ul>
                </li>
                 <li><strong>String Parameter:</strong>
                    <ul>
                        <li>Name: <code>TAG_NAME </code></li>
                        <li>Description:* Enter tag name name for PR Report</li>
                    </ul>
                </li>
            </ul>
        </ul>
    </div>
    <div class="section">
        <h2>4. Run the Job</h2>
        <p>To execute the pipeline:</p>
        <ul>
            <li>Go to the pipeline job page.</li>
            <li>Click on <strong>Build with Parameters</strong>.</li>
            <li>Provide the required parameter values.</li>
            <li>Click <strong>Build</strong> to run the job.</li>
        </ul>
    </div>
    <div class="section">
        <h2>5. Get the Report</h2>
        <p>After the job execution is complete:</p>
        <ul>
            <li>Go to the pipeline job page.</li>
            <li>Click on the <strong>Build Number</strong> to view the job details.</li>
            <li>Navigate to the <strong>Reports</strong> or <strong>Artifacts</strong> section to download and review the generated report.</li>
        </ul>
    </div>
    <div>
    <p><strong><b>Note</b></strong> : The jenkins file provided is according to the linux machine</p>
    </div>
</body>
</html>
