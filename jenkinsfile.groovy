node{
stage( "git checkout"){
git branch: 'master', url: 'https://github.com/swetha8998/node_App.git'
}
stage( "build" ){
 sh 'echo "compressing the files present " '
sh 'tar -cvf nodeapp.tar package.json server.js'
}
 stage( "initializing terraform"){
  sh 'terraform init'
 }
 stage( "validating the configuration files"){
  sh 'terraform validate'
 }
 stage( "terraform planning"){
  sh 'terraform plan')
 }
 stage( "terraform apply"){
  sh 'terraform apply'
 }
stage ( "approve"){
sh 'echo "in approval stage" '


}
stage ( " deploy "){
sh 'echo "in deployement stage"'

}
}
