# SonarCloud CircleCI Orb

This is a CircleCI Orb to analyze projects on SonarCloud.

The Orb is intended to make it easier to integrate with SonarCloud.
It includes the following features:

  * Scanner parameters for branch and pull request analysis
  * Scanner commands for NPM, Maven and Gradle
  * Command and job to wait for the quality gate status

The Orb is primarily intended to be used as commands within your existing jobs.
It also contains a job to wait for the quality gate to be updated after an analysis.

## Examples

```
version: 2.1
orbs:
  sonarcloud: extendaretail/sonarcloud@1.0.0
job:
  commit:
    docker:
      - image: openjdk:11
    steps:
      - checkout
      - run: mvn package
      - sonarcloud/scan_with_maven
workflows:
  main:
    jobs:
      - commit:
          context: sonarcloud
      - sonarcloud/check_quality_gate:
          context: sonarcloud
          requires:
            - commit
```
