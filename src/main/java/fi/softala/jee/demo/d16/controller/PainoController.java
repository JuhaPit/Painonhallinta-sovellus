package fi.softala.jee.demo.d16.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.jee.demo.d16.bean.Paino;
import fi.softala.jee.demo.d16.bean.PainoImpl;
import fi.softala.jee.demo.d16.dao.PainoDAO;

@Controller
@RequestMapping(value = "/secure/painot")
public class PainoController {

	@Inject
	private PainoDAO dao;

	public PainoDAO getDao() {
		return dao;
	}

	public void setDao(PainoDAO dao) {
		this.dao = dao;
	}

	// FORMIN TEKEMINEN
	@RequestMapping(value = "uusi", method = RequestMethod.GET)
	public String getCreateForm(Model model) {
		Paino tyhjaPaino = new PainoImpl();

		model.addAttribute("uusiPaino", tyhjaPaino);
		return "secure/lisaa";
	}

	// FORMIN TIETOJEN VASTAANOTTO
	@RequestMapping(value = "uusi", method = RequestMethod.POST)
	public String create(@ModelAttribute(value = "paino") PainoImpl paino) {
		dao.talleta(paino);
		return "redirect:/secure/painot/tarkastele";
	}

	// PAINOJEN NÄYTTÄMINEN
	@RequestMapping(value = "tarkastele", method = RequestMethod.GET)
	public String getView(Model model) {
		List<Paino> painot = dao.haeKaikki();
		model.addAttribute("painotAttr", painot);
		return "secure/view";
	}

}
