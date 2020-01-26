package com.miw.presentation;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miw.business.bookmanager.BookManagerService;
import com.miw.model.Book;

@SessionAttributes({"cart"})
@Controller
public class ShoppingCartController {
	
	@Autowired
	private BookManagerService bookManagerService;

	public void setBookManagerService(BookManagerService bookManagerService) {
		this.bookManagerService = bookManagerService;
	}
	
	@RequestMapping(path = "private/shoppingCart", method = RequestMethod.GET)
	public String shoppingCart(Model model) throws Exception {
		System.out.println("Executing shoppingCart");
		
		model.addAttribute("booklist",
				bookManagerService.getBooks());
		
		return "private/shoppingCart";
	}
	
	@RequestMapping(path = "private/showShoppingCart", method = RequestMethod.GET)
	public String showShoppingCart() throws Exception {
		System.out.println("Executing ShowShoppingCart");
		
		return "private/showShoppingCart";
	}
	
	@RequestMapping(path = "private/addToShoppingCart", method = RequestMethod.POST)
	public String addToShoppingCart(@ModelAttribute("cart") Map<String, Integer> cart, ServletRequest request) throws Exception {
		
		System.out.println(request.getParameterMap().values());
		
		for (Book b : bookManagerService.getBooks()) {
			if(request.getParameterMap().get(String.valueOf(b.getId())) != null) {
				int cantidad = 1;
				if (cart.containsKey(b.getTitle())) { //Si contiene el libro aumentamos la cantidad
					int cantidadActual = cart.get(b.getTitle());
					cantidad = cantidadActual+1;
				}
				cart.put(b.getTitle(), cantidad);
			}
		}
		
		return "private/showShoppingCart";
	}
	
	@ModelAttribute("cart")
	private Map<String, Integer> getCart() {
		return new HashMap<String, Integer>();
	}
}
