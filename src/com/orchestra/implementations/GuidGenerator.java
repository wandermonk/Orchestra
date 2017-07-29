package com.orchestra.implementations;

import java.util.UUID;

import com.orchestra.interfaces.IDGenerator;

public final class GuidGenerator implements IDGenerator {
	
	private final String uniqueID = UUID.randomUUID().toString();
	
	private GuidGenerator() {}
	
	private static class GuidHolder{
		private static final GuidGenerator id = new GuidGenerator();		
	}
	
	public static GuidGenerator getInstance(){
		return GuidHolder.id;
	}
	
	public String createJobID(){
		return uniqueID;
	}
	
	
}
