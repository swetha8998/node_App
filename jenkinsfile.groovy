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
 stage( "initializing terraform"){
	 steps{
  sh 'terraform init'
	 }
 }
 stage( "validating the configuration files"){
	 steps{
  sh 'terraform validate'
	 }
 }
 stage( "terraform planning"){
	 steps{
  sh 'terraform plan'
	 }
 }
 stage( "terraform apply"){
	 steps{
  sh 'terraform apply --auto-approve'
	 }
 }
stage ( "approve"){
	steps{
sh 'echo "in approval stage" '
	}

}
stage ( " deploy "){
	steps{
sh 'echo "in deployement stage"'
	}

}
	}
}
