package com.project.boots.services;
import org.springframework.stereotype.Service;
import com.project.boots.models.Boot;
import com.project.boots.repositories.BootRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
@Service
public class BootService {

    private BootRepository bootRepository;
    public BootService(BootRepository bootRepository){
        this.bootRepository = bootRepository;
    }
    
    // initialize the boots variable with values
    private List<Boot> boots = new ArrayList<>(Arrays.asList(
            new Boot("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309),
            new Boot("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180),
            new Boot("Moby Dick", "The saga of Captain Ahab", "english", 544),
            new Boot("Don Quixote", "Life of a retired country gentleman", "english", 150),
            new Boot("The Odyssey", "Ancient Greek epic poem", "english", 475)
            ));
    
    // returns all the boots
    public List<Boot> allBoots() {
        return bootRepository.findAll();
	}
	
	public Boot findBootByIndex(int index) {
        if (index < boots.size()){
            return boots.get(index);
        }else{
            return null;
        }
	}
	
	public void addBoot(Boot boot) {
        bootRepository.save(boot);
	}
	
	public void updateBoot(int id, Boot boot) {
		if (id < boots.size()){
            boots.set(id, boot);
        }
	}

	public void destroyBoot(int id) {
        if (id < boots.size()){
            boots.remove(id);
        }
    }
}
