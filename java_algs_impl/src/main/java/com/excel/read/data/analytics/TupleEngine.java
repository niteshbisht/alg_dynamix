package com.excel.read.data.analytics;

public class TupleEngine {
	private static TupleEngine tupleEngine;
	
	private TupleEngine()
	{
		
	}
	
	public static TupleEngine getTupleEngine(){
		if(tupleEngine==null){
			tupleEngine= new TupleEngine();
			return tupleEngine;
		}else
			return tupleEngine;
	}

}

