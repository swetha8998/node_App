output "instance_id"{
description ="ID of the EC2 instance"
value = aws_instance.example.id
}
output "instance_public_ip"{
description = "public ip address of the ec2 instance"
value =aws_instance.example.public_ip
}



