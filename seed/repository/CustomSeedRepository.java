package com.ec.onlineplantnursery.seed.repository;

import java.util.List;
import java.util.Optional;

import com.ec.onlineplantnursery.seed.entity.Seed;

public interface CustomSeedRepository {

	Optional<Seed> getSeedByCommonName(String commonName);

	Optional<List<Seed>> getSeedsByTypeOfSeed(String typeOfSeed);

}
