package com.doublechaintech.his;

import com.skynet.infrastructure.graphservice.BaseQuery;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class HisQuery extends BaseQuery {
	
	public HisQuery(Class startType, String ... pStart) {
        super(startType, pStart);
        super.setProject("his");
  }

  public HisQuery(Object start){
    this(start.getClass(), getId(start));
  }

  private static String getId(Object pStart) {
      BeanWrapper bw = new BeanWrapperImpl(pStart);
      return String.valueOf(bw.getPropertyValue("id"));
  }
}























