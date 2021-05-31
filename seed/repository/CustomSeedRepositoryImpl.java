package com.ec.onlineplantnursery.seed.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.onlineplantnursery.exceptions.ResourceNotFoundException;
import com.ec.onlineplantnursery.seed.entity.Seed;



public class CustomSeedRepositoryImpl implements CustomSeedRepository{
	@Autowired
	EntityManager entityManager; // Session of Hibernate
	
	
	@Override
	public Optional<Seed> getSeedByCommonName(String commonName)  {
			
		Query q = entityManager.createQuery("from Seed where commonName=:commonName");
		q.setParameter("commonName", commonName);
		Seed s = (Seed) q.getSingleResult();
		Optional<Seed> s1 = Optional.of(s);
		return s1;
	}

	@Override
	public Optional<List<Seed>> getSeedsByTypeOfSeed(String typeOfSeed) {
		
		Query q = entityManager.createQuery("from Seed where typeOfSeeds=:typeOfSeed");
		q.setParameter("typeOfSeed", typeOfSeed);
		return Optional.of(q.getResultList());
		
	}
}
