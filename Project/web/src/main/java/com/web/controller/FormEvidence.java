package com.web.controller;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejb.model.Evidence;
import com.ejb.service.EvidenceService;

import jakarta.annotation.PostConstruct;

@Controller
public class FormEvidence {
    
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
	
    @GetMapping("/evidence/form")
    public String getForm() {
    	return "form";
    }

    @PostMapping("/evidence/form")
    public String postForm(
        @RequestParam("description") String description,
        @RequestParam("sourceOfficerDepartment") String sourceOfficerDepartment,
        @RequestParam("dateOfAcquisition") String dateOfAcquisition,
        @RequestParam("custodyStatus") String custodyStatus,
        @RequestParam("lastCustodianName") String lastCustodianName,
        @RequestParam("encryptionStatus") String encryptionStatus
    ){
        System.out.println("-- GOT FORM DATA");
        System.out.println(description);
        System.out.println(sourceOfficerDepartment);
        System.out.println(dateOfAcquisition);
        System.out.println(custodyStatus);
        System.out.println(lastCustodianName);
        System.out.println(encryptionStatus);

        // Save Evidence
        Evidence newEvidence = new Evidence();
        newEvidence.setDescription(description);
        newEvidence.setSourceOfficerDepartment(sourceOfficerDepartment);
        newEvidence.setDateOfAcquisition(dateOfAcquisition);
        newEvidence.setCustodyStatus(custodyStatus.equals("IN_CUSTODY") ? Evidence.CustodyStatus.IN_CUSTODY : Evidence.CustodyStatus.RELEASED);
        newEvidence.setLastCustodianName(lastCustodianName);
        newEvidence.setEncryptionStatus(encryptionStatus.equals("TRUE") ? true : false);

        evidenceService.saveEvidence(newEvidence);

        return "success";
    }
}
