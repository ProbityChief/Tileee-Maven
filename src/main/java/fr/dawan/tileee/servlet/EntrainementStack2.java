package fr.dawan.tileee.servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.tileee.bean.Tag;
import fr.dawan.tileee.service.TagsService;

@Controller
@RequestMapping("tileee")
public class EntrainementStack2 {

	@Autowired
	private TagsService service;
	
	private String displayPag(Integer page, Integer max,  Model model) {
		int start = (page - 1) * max;
		List<Tag> ls = service.pagination(start, max);
		model.addAttribute("lst", ls);
		
		boolean suivExist = (page*max) < service.count();
		System.out.println(service.count());
		model.addAttribute("suivExist", suivExist);
		model.addAttribute("page", page);
		model.addAttribute("max", max);
		
		return "entrainement";	
	}
	
	@GetMapping("/pagination/{page}")
	public String pagination(@PathVariable("page") Integer page, 
			@PathVariable("max") Integer max, Model model) {
		int TagPerPage = 5;
		if( page == null) page = 1;
		
		return displayPag(page, TagPerPage, model);
	}
}
