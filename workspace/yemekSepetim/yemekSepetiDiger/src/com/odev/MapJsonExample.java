package com.odev;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;

public class MapJsonExample {
	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "mkyong");
		map.put("age", 29);

		List<Object> list = new ArrayList<Object>();
		list.add("msg 1");
		list.add("msg 2");
		list.add("msg 3");

		map.put("messages", list);

		try {

			// write JSON to a file
			mapper.writeValue(new File("c:\\user.json"), map);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}