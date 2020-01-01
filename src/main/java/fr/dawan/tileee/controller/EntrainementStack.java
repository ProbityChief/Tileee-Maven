package fr.dawan.tileee.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dawan.tileee.bean.Card;
import fr.dawan.tileee.bean.Tag;
import fr.dawan.tileee.bean.User;
import fr.dawan.tileee.dao.CardDao;
import fr.dawan.tileee.service.TagsService;

@Controller
@RequestMapping("/EntrainementStack")
public class EntrainementStack {

	@GetMapping("/{user}/{tag}")
	public String chargementstack(@PathVariable("user") long id, @PathVariable("tag") String tag, Model model) {
		System.out.println(tag);
		System.out.println(id);
		CardDao carddao = new CardDao("tileee");
		List<Card> listCard = carddao.findByTag(id, tag, true);
		ArrayList<String> mot = new ArrayList<String>();
		ArrayList<String> traduction = new ArrayList<String>();
		
		System.out.println(listCard.get(0).getWord());
		for(Card c : listCard) {
			mot.add(c.getWord());
			traduction.add(c.getTranslation());
		}

		model.addAttribute("mot", mot);
		model.addAttribute("traduction", traduction);
		return "demo";
	}
	
//	@RequestMapping(value = "/EntrainementStack", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "entrainementstack";
//	}
}
