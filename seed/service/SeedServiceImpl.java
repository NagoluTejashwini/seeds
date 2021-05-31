package com.ec.onlineplantnursery.seed.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.onlineplantnursery.dto.SeedDTO;
import com.ec.onlineplantnursery.exceptions.InvalidInputException;
import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.ec.onlineplantnursery.seed.entity.Seed;
import com.ec.onlineplantnursery.seed.repository.SeedRepository;

@Service
public class SeedServiceImpl implements ISeedService{

	
	@Autowired
	SeedRepository repo;
	
	public SeedServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public SeedServiceImpl(SeedRepository repo) {
		super();
		this.repo = repo;
	}

	public boolean validateCommonName(String commonName)
	{
		if(commonName != null & commonName.length()>3 & !commonName.equals(""))
		{
			return true;
		}
		return false;
	}
	
	
	public boolean validateTemparature(String temparature) {
		if(temparature != null & !temparature.equals("")) {	
			return false;
		}
		return true;
	}
	public boolean validateSeedsCost(double cost) {
		if(cost < 0) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public Seed addSeed(SeedDTO seedDTO) {
		Seed seed = new Seed();
		
		if(validateCommonName(seedDTO.getCommonName())){
			seed.setCommonName(seedDTO.getCommonName());
		}
		seed.setBloomTime(seedDTO.getBloomTime());
		seed.setWatering(seedDTO.getWatering());
		seed.setDifficultyLevel(seedDTO.getDifficultyLevel());
		
		if(validateTemparature(seedDTO.getTemparature())) {
			seed.setTemparature(seedDTO.getTemparature());
		}
		seed.setTypeOfSeeds(seedDTO.getTypeOfSeeds());
		seed.setSeedsDescription(seedDTO.getSeedsDescription());
		seed.setSeedsStock(seedDTO.getSeedsStock());
		
		if(validateSeedsCost(seedDTO.getSeedsCost())) {
			seed.setSeedsCost(seedDTO.getSeedsCost());
		}
		
		seed.setSeedsPerPacket(seedDTO.getSeedsPerPacket());
		Seed s = repo.save(seed);
		return s;
	}

	@Override
	@Transactional
	public Seed updateSeed(Seed seed) throws SeedIdNotFoundException{
		int seedId = seed.getSeedId();
		Optional<Seed> s = repo.findById(seedId);
		Seed s1 = null;
		if(s.isEmpty()) {
			throw new SeedIdNotFoundException(seedId);
		}
		else {
			s1 = s.get();
			s1.setCommonName(seed.getCommonName());
			s1.setBloomTime(seed.getBloomTime());
			s1.setWatering(seed.getWatering());
			s1.setDifficultyLevel(seed.getDifficultyLevel());
			s1.setTemparature(seed.getTemparature());
			s1.setTypeOfSeeds(seed.getTypeOfSeeds());
			s1.setSeedsDescription(seed.getSeedsDescription());
			s1.setSeedsStock(seed.getSeedsStock());
			s1.setSeedsCost(seed.getSeedsCost());
			s1.setSeedsPerPacket(seed.getSeedsPerPacket());
			repo.save(s1);
		}
		
		return s1;
	}

	@Override
	@Transactional
	public Seed deleteSeed(Seed seed) throws SeedIdNotFoundException{
		boolean isDeleted = false;
		int seedId = seed.getSeedId();
		Optional<Seed> s = repo.findById(seedId);
		if(s.isEmpty()) {
			throw new SeedIdNotFoundException(seedId);
		}
		else {
			repo.delete(seed);
		}
		return seed;
	}

	@Override
	public Seed viewSeed(int seedId) throws SeedIdNotFoundException{
		Optional<Seed> s = repo.findById(seedId);
		if(s.isEmpty()) {
			throw new SeedIdNotFoundException(seedId);
		}
		return repo.findById(seedId).get();
	}

	@Override
	public Optional<Seed> viewSeed(String commonName) throws ResourceNotFoundException  {
		Optional<Seed> s1 = repo.getSeedByCommonName(commonName);
		
		if(s1.isEmpty()) throw new ResourceNotFoundException(commonName);

		return s1;
		
	}

	@Override
	public List<Seed> viewAllSeeds() {
		return repo.findAll();
	}

	@Override
	public Optional<List<Seed>> viewAllSeeds(String typeOfSeed)  throws ResourceNotFoundException {
		Optional<List<Seed>> sList = repo.getSeedsByTypeOfSeed(typeOfSeed);
		if(sList==null || sList.isEmpty()) {
			throw new ResourceNotFoundException(typeOfSeed);
		}
		return repo.getSeedsByTypeOfSeed(typeOfSeed);
	}

}








