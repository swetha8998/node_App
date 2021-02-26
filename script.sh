#!/bin/bash
sudo apt-get update -y
sudo apt-get install -y yum
echo "installing nodejs"
curl -sL https://rpm.nodesource.com/setup_10.x | sudo bash -
sudo apt-get install nodejs
sudo apt-get install npm
nodejs -v
echo "startin the server"
node server.js
