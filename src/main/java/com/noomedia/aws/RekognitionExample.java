package com.noomedia.aws;

import com.amazonaws.services.rekognition.*;
import com.amazonaws.services.rekognition.model.*;
import java.util.List;

public class RekognitionExample {

	// TODO: Replace "bucket_name" with the name of the S3 bucket in *your* AWS account.
	// NOTE: The S3 bucket must be in the *same AWS region* specified in the REGION variable below.
	public static final String S3_BUCKET = "bucket_name";
	public static final String REGION = "us-east-1";

	public static void main ( String[] args ) {

		AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder
			.standard()
			.withRegion( RekognitionExample.REGION )
			.build();

		// TODO: Replace source_image.jpg and target_image.jpg with the filenames of the two images you have
		//  uploaded to *your* S3 bucket.
		CompareFacesRequest compareFacesRequest = new CompareFacesRequest()
			.withSourceImage( getImageUtil("source_image.jpg" ) )
			.withTargetImage( getImageUtil("target_image.jpg" ) );

		CompareFacesResult compareFacesResult = rekognitionClient.compareFaces( compareFacesRequest );

		List<CompareFacesMatch> matchingFaces = compareFacesResult.getFaceMatches();
		System.out.println( "Number of matching faces = " + matchingFaces.size() );
		matchingFaces.forEach( m -> System.out.println(
			"Matching confidence = " + m.getFace().getConfidence() + "%"
		) );

	}

	private static Image getImageUtil( String key ) {
		return new Image()
			.withS3Object( new S3Object()
				.withBucket( RekognitionExample.S3_BUCKET )
				.withName( key )
			);
	}

}