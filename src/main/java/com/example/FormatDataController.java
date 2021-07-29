package com.example;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FormatDataController {

	@GetMapping("/formatData")
	public List<Person> formatDataAndSort(
		@RequestParam String dataUrl, 
		@RequestParam String sheetName, 
		@RequestParam(value = "sortBy", required = false) String sortBy) throws Exception {

		List<Person> dataFormatted = DataFormatter.getFormattedData(dataUrl, sheetName);
		
		if(sortBy != null) {
			DataSorter.sortData(dataFormatted, sortBy);
		}

		return dataFormatted;
	}
}
