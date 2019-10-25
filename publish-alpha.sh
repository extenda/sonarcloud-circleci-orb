#!/bin/bash

circleci config pack src > orb.yml
circleci orb publish orb.yml extendaretail/sonarcloud@dev:alpha
rm -rf orb.yml
