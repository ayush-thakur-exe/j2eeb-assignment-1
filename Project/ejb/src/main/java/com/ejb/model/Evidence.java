package com.ejb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "evidences")
public class Evidence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "evidenceID")
    private int evidenceId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="sourceOfficerDepartment")
	private String sourceOfficerDepartment;
	
	@Column(name="dateOfAcquisition")
	private String dateOfAcquisition;
	
	public enum CustodyStatus {
        IN_CUSTODY,
        RELEASED
    }
	
	@Enumerated(EnumType.STRING)
	@Column(name="custodyStatus")
	private CustodyStatus custodyStatus;
	
	@Column(name="lastCustodianName")
	private String lastCustodianName;
	
	@Column(name="encryptionStatus")
	private boolean encryptionStatus;

	public int getEvidenceId() {
		return evidenceId;
	}

	public void setEvidenceId(int evidenceId) {
		this.evidenceId = evidenceId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSourceOfficerDepartment() {
		return sourceOfficerDepartment;
	}

	public void setSourceOfficerDepartment(String sourceOfficerDepartment) {
		this.sourceOfficerDepartment = sourceOfficerDepartment;
	}

	public String getDateOfAcquisition() {
		return dateOfAcquisition;
	}

	public void setDateOfAcquisition(String dateOfAcquisition) {
		this.dateOfAcquisition = dateOfAcquisition;
	}

	public CustodyStatus getCustodyStatus() {
		return custodyStatus;
	}

	public void setCustodyStatus(CustodyStatus custodyStatus) {
		this.custodyStatus = custodyStatus;
	}

	public String getLastCustodianName() {
		return lastCustodianName;
	}

	public void setLastCustodianName(String lastCustodianName) {
		this.lastCustodianName = lastCustodianName;
	}

	public boolean isEncryptionStatus() {
		return encryptionStatus;
	}

	public void setEncryptionStatus(boolean encryptionStatus) {
		this.encryptionStatus = encryptionStatus;
	}
	
}
