package com.web.controller;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ejb.model.Evidence;
import com.ejb.service.EvidenceService;

import jakarta.annotation.PostConstruct;

@Controller
public class InCustody {
	
	private EvidenceService evidenceService;

	@PostConstruct
	public void init() {
	    try {
	        InitialContext context = new InitialContext();
	        evidenceService = (EvidenceService) context.lookup("java:app/com.custody-ejb-0.0.1/EvidenceService");
	    } catch (NamingException e) {
	        throw new RuntimeException("EJB lookup failed", e);
	    }
	}

	@GetMapping("/evidence/in_custody")
    public ModelAndView getInCustody(Model model) {
    	List<Evidence> incustody = evidenceService.getInCustody();
    	return new ModelAndView("inCustody", "evidences", incustody);
    }
}
