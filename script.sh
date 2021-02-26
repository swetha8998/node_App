#!/bin/bash
sudo apt-get update -y
sudo apt-get install -y yum
echo "installing nodejs"
curl -sL https://rpm.nodesource.com/setup_10.x | sudo bash -
sudo yum install nodejs
node --version
npm --version
echo "startin the server"
node server.js
