package com.capgemini.alewandowski.controllers;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.alewandowski.interfaces.UserDataService;

@RestController
public class SearchController {
	
		@Autowired
		private UserDataService uDataService;
		
		@RequestMapping("/search/{filters}")
		public String getFilters(@MatrixVariable(pathVar="filters") Map<String, List<String>> filters, Model model){
			System.out.println("Pobieranie parametrów..");
			Set<String> conditions = filters.keySet();
			
			if(conditions.contains("firstName")){
				System.out.println("Got..First Name");
				for(String p : filters.get("firstName")){
					System.out.println(p);
				}
			}
			if(conditions.contains("lastName")){
				System.out.println("Got..Last Name");
				for(String p : filters.get("lastName")){
					System.out.println(p);
				}
			}
			if(conditions.contains("email")){
				System.out.println("Got..email");
				for(String p : filters.get("email")){
					System.out.println(p);
				}
			}
			return "something";
	}
}
