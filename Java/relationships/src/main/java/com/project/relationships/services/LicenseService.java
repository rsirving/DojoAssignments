package com.project.relationships.services;
import com.project.relationships.models.*;
import com.project.relationships.repositories.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LicenseService {
	// Member variables / service initializations go here
	private LicenseRepo licenseRepo;
	public LicenseService(LicenseRepo licenseRepo){
		this.licenseRepo = licenseRepo;
	}

	public License newLicense(License license){
		Long personId = license.getPerson().getId();
		String licNumber = String.format("%06d", personId);
		license.setNumber(licNumber);
		License lic = licenseRepo.save(license);
		return lic;
	}
	
	// Crud methods to act on services go here.
}
