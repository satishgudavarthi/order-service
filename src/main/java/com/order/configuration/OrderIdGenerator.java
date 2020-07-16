package com.order.configuration;
import java.util.UUID;

public class OrderIdGenerator  {

	public static String generate() {
		String id = "ORD-"+UUID.randomUUID().toString().split("-")[0];
		return id;
	}

}