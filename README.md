# PowerStat's TicTacToe

TODO

## Installation

TODO

To compile this project yourself you could use:

    mvn clean install org.pitest:pitest-maven:mutationCoverage site
    
or simply:

     mvn clean install
     
To find newer dependencies:

    mvn versions:display-dependency-updates
    
To find newer plugins:

    mvn versions:display-plugin-updates
    
To make a new release:

    mvn --batch-mode release:clean release:prepare release:perform
    git push -–tags
    git push origin master
    
To run checkstyle:

    mvn checkstyle:check
    
To run pmd:

    mvn pmd:check
    
To run spotbugs:

    mvn spotbugs:check
    
To run arch-unit:

    mvn arch-unit:arch-test
    
To run JDeprScan:

    mvn jdeprscan:jdeprscan jdeprscan:test-jdeprscan
    
To run toolchain:

    mvn toolchains:toolchain
    
If you use a sonar server:

    mvn sonar:sonar -Dsonar.token=<token>
    
If you use [infer][https://fbinfer.com/]:

    infer run -- mvn clean compile

To create a spdx:

    mvn spdx:createSPDX

To create a cycloneDX:

    mvn cyclonedx:makeBom
    
To upload bom to dependency-track:

    mvn dependency-track:upload-bom
    
To look for dependency-track findings: 

    mvn dependency-track:findings


## Usage

TODO

## Contributing

If you would like to contribute to this project please read [How to contribute](CONTRIBUTING.md).

## License

This code is licensed under the [Apache License Version 2.0](LICENSE.md).
