# Downloading and installing Jenkins

Completing the previous steps enables you to download and install Jenkins on AWS. To download and install Jenkins:

Ensure that your software packages are up-to-date on your instance by using the following command to perform a quick
software update:

```script
sudo yum update –y
```

Add the Jenkins repo using the following command:

```script
sudo wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat-stable/jenkins.repo
```

Import a key file from Jenkins-CI to enable installation from the package:

```script
sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io-2023.key
sudo yum upgrade
```

Install Java (Amazon Linux 2023):

```script
sudo dnf install java-17-amazon-corretto -y
```

Install Jenkins:

```script
sudo yum install jenkins -y
```

Enable the Jenkins service to start at boot:

```script
sudo systemctl enable jenkins
```

Start Jenkins as a service:

```script
sudo systemctl start jenkins
```

You can check the status of the Jenkins service using the command:

```script
sudo systemctl status jenkins
```