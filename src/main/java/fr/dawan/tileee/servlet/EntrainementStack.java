package fr.dawan.tileee.servlet;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.tileee.bean.Card;
import fr.dawan.tileee.bean.Tag;
import fr.dawan.tileee.bean.User;
import fr.dawan.tileee.dao.CardDao;
import fr.dawan.tileee.service.TagsService;

@Controller
public class EntrainementStack {

	@GetMapping("/EntrainementStack/{tag}")
	public String pagination(@PathVariable("tag") String tag, Model model, HttpSession session) {
		CardDao carddao = new CardDao();
		
		User user = (User) session.getAttribute("user");
		List<Card> listCard = carddao.findByTag(user, tag, true);
		model.addAttribute("lC", listCard);
		return "entrainementstack";
	}
}
