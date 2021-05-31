package com.ec.onlineplantnursery.seed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ec.onlineplantnursery.seed.entity.Seed;

public interface SeedRepository extends JpaRepository<Seed,Integer>, CustomSeedRepository{

}
