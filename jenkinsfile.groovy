pipeline{
	agent any
        environment{
	    AWS_ACCESS_KEY_ID = credentials('access_k')
        AWS_SECRET_ACCESS_KEY = credentials('secret_k')
	 }
	stages{
stage( "git checkout"){
	steps{
git branch: 'master', url: 'https://github.com/swetha8998/node_App.git'
	}
}	
stage( "build" ){
	steps{
 sh 'echo "compressing the files present " '
sh 'tar -cvf nodeapp.tar package.json server.js'
	}
}
stage( "aprroval"){
	steps{
	 timeout(time: 15, unit: "MINUTES") {    input message: 'Do you want to approve the deploy in production?', ok: 'Yes'}
	}
}
stage( "deploy"){
	 steps{
  sh 'npm start'
	 }
 }

	}
}
