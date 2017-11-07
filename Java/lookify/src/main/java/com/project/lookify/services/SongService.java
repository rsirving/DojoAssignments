package com.project.lookify.services;
import com.project.lookify.models.Song;
import com.project.lookify.repositories.SongRepo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SongService {
	// Member variables / service initializations go here
	private SongRepo songRepo;
	public SongService(SongRepo songRepo){
		this.songRepo = songRepo;
	}
	
	// Crud methods to act on services go here.
	public List<Song> allSongs(){
		return songRepo.findAll();
	}

	public Song findSong(Long id){
		return songRepo.findOne(id);
	}

	public void addSong(Song song){
		songRepo.save(song);
	}

	public void updateSong(Song song){
		songRepo.save(song);
	}

	public void destroySong(Long id){
		songRepo.delete(id);
	}
}
