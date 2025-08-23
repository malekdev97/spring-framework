package com.backend.backend;


import com.backend.backend.utils.General;
import com.backend.backend.utils.T;
import com.backend.backend.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class BackendApplication {


	public static void main(String[] args) {
		// SpringApplication.run(BackendApplication.class, args);
		System.out.println("Working...");
		Utils utils = new Utils<T>();
		T t = new T();
		t.name = "str name";
		utils.genericList.add(t);

		System.out.println(utils.genericList.get(0));
	}
}
