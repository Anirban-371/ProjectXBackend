package com.projectXNeighbour.Settings;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class QuestionList {
	@Id
	private String id;
	List<String> questionList = new ArrayList<String>();
	private boolean is_promotion;
	private String promotion_last_date;
	private String image;
	private Boolean is_required;
}
