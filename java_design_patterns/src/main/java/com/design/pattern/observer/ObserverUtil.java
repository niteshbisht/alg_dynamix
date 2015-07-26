package com.design.pattern.observer;

public class ObserverUtil {
	public static void invokeObserverCode() {
		ElasticDBStore est = new ElasticDBStore();
		RestWeb rstwbObserver = new RestWeb();
		SoapWeb soapwbObserver = new SoapWeb();
		est.registerObserver(soapwbObserver);
		est.registerObserver(rstwbObserver);
		est.setOperation("ReadOnly");
		est.setRecord("MessagingQueueStore");
		est.editRecords("Read Write", "TopicStore");
	}
}
