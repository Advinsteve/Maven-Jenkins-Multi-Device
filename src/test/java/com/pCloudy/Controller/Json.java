package com.pCloudy.Controller;

import org.openqa.selenium.remote.DesiredCapabilities;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

public class Json {

	public static void jsonFormatter(DesiredCapabilities capabilities) {

		Map<String, Object> capabilitiesMap = capabilities.asMap();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String formattedJson = gson.toJson(capabilitiesMap);
		System.out.println(formattedJson);
	}

}
