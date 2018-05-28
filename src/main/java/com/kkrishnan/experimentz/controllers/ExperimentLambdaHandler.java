package com.kkrishnan.experimentz.controllers;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.kkrishnan.experimentz.ExperimentzApplication;

public class ExperimentLambdaHandler implements RequestHandler<AwsProxyRequest, AwsProxyResponse> {

	private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

	static {
		try {
			handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(ExperimentzApplication.class);
		} catch (ContainerInitializationException e) {
			// if we fail here. We re-throw the exception to force another cold
			// start
			e.printStackTrace();
			throw new RuntimeException("Could not initialize Spring Boot application", e);
		}
	}

	@Override
	public AwsProxyResponse handleRequest(AwsProxyRequest awsProxyRequest, Context context) {
		return handler.proxy(awsProxyRequest, context);
	}

}