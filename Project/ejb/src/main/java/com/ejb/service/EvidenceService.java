package com.ejb.service;

import com.ejb.model.Evidence;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class EvidenceService{

	@PersistenceContext(unitName = "EvidencePU")
	private EntityManager em;

    public void saveEvidence(Evidence evidence) {
        em.persist(evidence);
    }
    
    public List<Evidence> getAllEvidence() {
        return em.createQuery("SELECT e FROM Evidence e", Evidence.class)
                            .getResultList();
    }

    public List<Evidence> getInCustody() {
        return em.createQuery("SELECT e FROM Evidence e where e.custodyStatus = " + Evidence.CustodyStatus.IN_CUSTODY, Evidence.class)
                            .getResultList();
    }
}
