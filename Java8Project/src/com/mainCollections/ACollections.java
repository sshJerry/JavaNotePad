package com.mainCollections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ACollections {
	List<Integer> list; //null
	public ACollections() {
		list = Arrays.asList(2,3,1,6,4,5,7);
	}
	// OR this
	{
		list = Arrays.asList(2,3,1,6,4,5,7);
	}
	
	public List<Integer> getList(){
		
		//list = Arrays.asList(2,3,1,6,4,5,7); //until assigned
		//REMOVE THE ABOVE
		return list;
	}
	public List<Integer> getSortedList(){
		Collections.sort(list);
		return list;
	}
}
