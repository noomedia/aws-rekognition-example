# Rekognition Example

A simple example of the [AWS Rekognition](https://aws.amazon.com/rekognition/) service using the [AWS SDK for Java](https://aws.amazon.com/sdk-for-java/) that compares and matches faces in two different images.

## Prerequisites

* An AWS Account — [aws.amazon.com](https://aws.amazon.com)
* The AWS Command Line Interface (CLI) tools — [aws.amazon.com/cli](https://aws.amazon.com/cli/)
* A Java 8 JDK — [Oracle Java](https://www.java.com/en/), [AdoptOpenJDK](https://adoptopenjdk.net) or alternative
* Apache Maven — [maven.apache.org](https://maven.apache.org)

## Configure

In your AWS Account you will need an IAM user that has read/write permissions to an S3 bucket that will be used for this example.
That same IAM user will also need an Access Key to call the AWS service APIs.
If you do not have either of these then you will need to create them.

Upload two images to your S3 bucket. The first should be an image with a number of people in it, e.g. a family photo. This will be the *target* image.
The second image should be a portrait or a selfie of someone in the first image. This will be the *source* image.
The AWS Rekognition service will search inside the *target* image for the *source* image.

On your local machine you will then need to install the AWS CLI tools.
Once you have done that, run the ``aws configure`` command and enter the Access Key ID and Secret Access Key you had previously generated for your IAM user.
If you have not yet installed a Java 8 JDK or Apache Maven you will need to do that now.
Your local environment will now be configured and ready to build and execute the example.

## Build

Clone or [download](https://github.com/noomedia/aws-rekognition-example/archive/master.zip) and unzip the source code. You should now have a directory that
contains a __pom.xml__ file and a __src__ subdirectory that contains the __RekognitionExample.java__ file. You will need to amend this .java file to reference
the S3 bucket and the source and target images.

Once you have done this you can use Maven to compile the source with the following command:

```bash
mvn package
```

This will create a __target__ directory that contains two __.jar__ files.

## Run

If the configuration and build have been successful you can execute the RekognitionExample class with the following command:

```bash
java -classpath target/aws-rekognition-example-1.0-SNAPSHOT-jar-with-dependencies.jar com.noomedia.aws.RekognitionExample
```

## License
[MIT](https://choosealicense.com/licenses/mit/)