resource "aws_key_pair" "mykey"{
key_name="mykey"
public_key=file(var.PATH_TO_PUBLIC_KEY)
}
resource "aws_instance" "example"{
ami = "ami-07f5c641c23596eb9"
instance_type ="t2.micro"
key_name = "${aws_key_pair.mykey.key_name}"
  connection{
     host        = coalesce(self.public_ip, self.private_ip)
    type        = "ssh"
user = "${var.INSTANCE_USERNAME}"
private_key =file(var.PATH_TO_PRIVATE_KEY)
   

}
  
 provisioner "file" {
    source      = "script.sh"
    destination = "/tmp/script.sh"
  }
  provisioner "file" {
    source ="package.json"
    destination ="/tmp/package.json"
    }
  provisioner "file" {
    source = "server.js"
    destination ="/tmp/server.js"
    }
  provisioner "remote-exec" {
    inline = [
      "chmod +x /tmp/script.sh",
      "chmod +x /tmp/package.json",
      "chmod +x /tmp/server.js",
      "sudo sed -i -e 's/\r$//' /tmp/script.sh",  # Remove the spurious CR characters.
      "sudo /tmp/script.sh",
    ]
  }
  

}
