node { //allocates a Jenkins executor and the workspace for the Pipeline
stage ('Clone second git repository'){ //Define a stage/step of the pipeline called "Clone second git repository"
	try { //using try/catch structure to get the errors
	deleteDir() //deletes all the data from the workspace
	repoclone() //executes the repoclone function
	def responder //define a variable 
	println responder //prints the variable 
	responder = load 'responder/responder.groovy' //assign the second groovy file to the defined variable with the command "load"
	println responder //prints the variable 
	responder.hello('hi') // loads the second groovy file and executes the function "hello" sending as a parameter the value "hi" 
	} catch (Exception err){ //using try/catch structure to get the errors
	println err   
	}  
 }	 
}
	def repoclone(){ //defines a function to clone the repositories to the Jenkins' workspace
	checkout([$class: 'GitSCM', branches: [[name: '*/'+'master']], 
	doGenerateSubmoduleConfigurations: false, extensions: [[$class: 
	'RelativeTargetDirectory'], [$class: 'MessageExclusion', 
	excludeMessage: '(?s).*JENKINS_IGNORE.*']], submoduleCfg: [], 
	userRemoteConfigs: [[url:"https://github.com/vale1202/WorkingWithGroovyFiles.git"]]])  
	 }  
