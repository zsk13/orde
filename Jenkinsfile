node {
	stage('SCM') {
	    git 'https://github.com/zsk13/orde.git/'
	}
	stage('build') { 
	    def mvnHome = tool 'maven'
	    sh "${mvnHome}/bin/mvn -B clean package"
	}

	stage('deploy') {
		sh "mv target/orderWineBackend.war /var/lib/tomcat8/webapps"
	}
}