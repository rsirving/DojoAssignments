package com.project.countries.services;
import com.project.countries.models.*;
import com.project.countries.repositories.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ApiService {
	// Member variables / service initializations go here
	private CitiesRepo citiesRepo;
	private CountriesRepo countriesRepo;
	private LanguagesRepo languagesRepo;
	public ApiService(CitiesRepo citiesRepo, CountriesRepo countriesRepo, LanguagesRepo languagesRepo){
		this.citiesRepo = citiesRepo;
		this.countriesRepo = countriesRepo;
		this.languagesRepo = languagesRepo;
	}
	
	// Crud methods to act on services go here.
	public List<Countries> taskOne(){
	}
}
