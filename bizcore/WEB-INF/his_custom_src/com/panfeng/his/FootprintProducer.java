package com.panfeng.his;

public interface FootprintProducer {

	boolean canReplaceFootPrint(Footprint fp, Footprint item);
	boolean clearTop();
	String getBeanName();
}


