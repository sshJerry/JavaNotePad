package com.main;

import java.util.List;
import java.util.stream.Collectors;

public class BCollections {
	public List<Integer> filterList(List<Integer> list, String filter) {
		if(filter.equalsIgnoreCase("even")) {
			list = list.stream().filter(l->l%2==0).collect(Collectors.toList());
		}
		if(filter.equalsIgnoreCase("odd")) {
			list =list.stream().filter(l->l%2==1).collect(Collectors.toList());
		}
		return list;
	}

}
