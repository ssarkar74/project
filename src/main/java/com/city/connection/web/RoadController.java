package com.city.connection.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.city.connection.aggregator.CityAggregator;
import com.city.connection.util.FileProcessor;


@Controller
public class RoadController {

	private static final String STRING_YES = "YES";
	private static final String STRING_NO = "NO";
	private static final String INDEX_PAGE = "result";
	private static final String CITY_FILE = "city.txt";
	
    @Autowired
    public RoadController() {

    }

    @RequestMapping("/")
    public String index(){
        return "redirect:/result";
    }
    
    
    @RequestMapping(value = "/connected", method = RequestMethod.GET)
    public String result(@RequestParam String origin, @RequestParam String destination, Model model) throws IOException {
    	model.addAttribute("origin", origin);
    	model.addAttribute("destination", destination);
		CityAggregator aggregator = FileProcessor.buildRoads(CITY_FILE);
		String connected  = STRING_NO;
		if((origin == null) || (destination == null)) {
			connected = STRING_NO;
		}
		else {
			connected = aggregator.isConnected(origin.trim(), destination.trim()) ? STRING_YES : STRING_NO;
		}
    	model.addAttribute("result", connected);
    	return INDEX_PAGE;
    }

    public static void main(String[] args) throws IOException {
    	CityAggregator aggregator0 = FileProcessor.buildRoads(CITY_FILE);
    	System.out.println(aggregator0.isConnected("Albany".toUpperCase(), "Trenton".toUpperCase()));
    	
    	CityAggregator aggregator1 = FileProcessor.buildRoads(CITY_FILE);
    	System.out.println(aggregator1.isConnected("Albany".toUpperCase(), "New York".toUpperCase()));

    	CityAggregator aggregator2 = FileProcessor.buildRoads(CITY_FILE);
    	System.out.println(aggregator2.isConnected("Albany".toUpperCase(), "Trenton".toUpperCase()));

    	CityAggregator aggregator3 = FileProcessor.buildRoads(CITY_FILE);
    	System.out.println(aggregator3.isConnected("New York".toUpperCase(), "Boston".toUpperCase()));

    	
    }
}