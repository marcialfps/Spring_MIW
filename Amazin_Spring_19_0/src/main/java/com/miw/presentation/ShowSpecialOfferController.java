package com.miw.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miw.business.bookmanager.BookManagerService;

@Controller
public class ShowSpecialOfferController {

	@Autowired
	private BookManagerService bookManagerService;
	
	public void setBookManagerService(BookManagerService bookManagerService) {
		this.bookManagerService = bookManagerService;
	}
	
	@RequestMapping ("private/showSpecialOffer")
	public String showSpecialOffer(Model model)
	{
		try {
			model.addAttribute("book", bookManagerService.getSpecialOffer());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return "private/showSpecialOffer";
	}
}

