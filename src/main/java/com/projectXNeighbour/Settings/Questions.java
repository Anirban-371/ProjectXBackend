package com.projectXNeighbour.Settings;
import org.springframework.data.annotation.Id;

public class Questions {
	
	@Id
	private String Id;
	private String title;
	private boolean is_input;
	private boolean is_selection;
	private boolean is_check;
	
	
}
