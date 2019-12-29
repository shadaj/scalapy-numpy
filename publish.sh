#!/bin/bash

set -e # exit with nonzero exit code if anything fails

openssl aes-256-cbc -K $encrypted_e61d3e3c6cc6_key -iv $encrypted_e61d3e3c6cc6_iv -in secrets.tar.enc -out secrets.tar -d

tar xvf secrets.tar

sbt +publishSigned sonatypeRelease
