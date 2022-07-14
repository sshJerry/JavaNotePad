package com.mainCollections;

import java.util.List;

public class App {
	public static void main(String[] args) {
		ACollections a =new ACollections();
		List <Integer> list = a.getSortedList();
		
		for(int e :list)
			System.out.println(e);
		System.out.println();
		
		BCollections b = new BCollections();
		String filter ="even";
		List<Integer> filteredList = b.filterList(list,filter);
		for(int e :filteredList)
			System.out.println(e);
		System.out.println();
	}
}
