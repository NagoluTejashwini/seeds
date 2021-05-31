package com.ec.onlineplantnursery.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class SeedDTO {
	private Integer seedId;
	private String commonName;
	private String bloomTime;
	private String watering;
	private String difficultyLevel;
	private String temparature;
	private String typeOfSeeds;
	private String seedsDescription;
	private Integer seedsStock;
	private double seedsCost;
	private Integer seedsPerPacket;
	public SeedDTO(String commonName, String bloomTime, String watering, String difficultyLevel,
			String temparature, String typeOfSeeds, String seedsDescription, Integer seedsStock, double seedsCost,
			Integer seedsPerPacket) {
		super();
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.temparature = temparature;
		this.typeOfSeeds = typeOfSeeds;
		this.seedsDescription = seedsDescription;
		this.seedsStock = seedsStock;
		this.seedsCost = seedsCost;
		this.seedsPerPacket = seedsPerPacket;
	}
	public Integer getSeedId() {
		return seedId;
	}
	public void setSeedId(Integer seedId) {
		this.seedId = seedId;
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getBloomTime() {
		return bloomTime;
	}
	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}
	public String getWatering() {
		return watering;
	}
	public void setWatering(String watering) {
		this.watering = watering;
	}
	public String getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	public String getTemparature() {
		return temparature;
	}
	public void setTemparature(String temparature) {
		this.temparature = temparature;
	}
	public String getTypeOfSeeds() {
		return typeOfSeeds;
	}
	public void setTypeOfSeeds(String typeOfSeeds) {
		this.typeOfSeeds = typeOfSeeds;
	}
	public String getSeedsDescription() {
		return seedsDescription;
	}
	public void setSeedsDescription(String seedsDescription) {
		this.seedsDescription = seedsDescription;
	}
	public Integer getSeedsStock() {
		return seedsStock;
	}
	public void setSeedsStock(Integer seedsStock) {
		this.seedsStock = seedsStock;
	}
	public double getSeedsCost() {
		return seedsCost;
	}
	public void setSeedsCost(double seedsCost) {
		this.seedsCost = seedsCost;
	}
	public Integer getSeedsPerPacket() {
		return seedsPerPacket;
	}
	public void setSeedsPerPacket(Integer seedsPerPacket) {
		this.seedsPerPacket = seedsPerPacket;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bloomTime == null) ? 0 : bloomTime.hashCode());
		result = prime * result + ((commonName == null) ? 0 : commonName.hashCode());
		result = prime * result + ((difficultyLevel == null) ? 0 : difficultyLevel.hashCode());
		//result = prime * result + ((seedId == null) ? 0 : seedId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(seedsCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((seedsDescription == null) ? 0 : seedsDescription.hashCode());
		result = prime * result + ((seedsPerPacket == null) ? 0 : seedsPerPacket.hashCode());
		result = prime * result + ((seedsStock == null) ? 0 : seedsStock.hashCode());
		result = prime * result + ((temparature == null) ? 0 : temparature.hashCode());
		result = prime * result + ((typeOfSeeds == null) ? 0 : typeOfSeeds.hashCode());
		result = prime * result + ((watering == null) ? 0 : watering.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeedDTO other = (SeedDTO) obj;
		if (bloomTime == null) {
			if (other.bloomTime != null)
				return false;
		} else if (!bloomTime.equals(other.bloomTime))
			return false;
		if (commonName == null) {
			if (other.commonName != null)
				return false;
		} else if (!commonName.equals(other.commonName))
			return false;
		if (difficultyLevel == null) {
			if (other.difficultyLevel != null)
				return false;
		} else if (!difficultyLevel.equals(other.difficultyLevel))
			return false;
		/*if (seedId == null) {
			if (other.seedId != null)
				return false;
		} else if (!seedId.equals(other.seedId))
			return false;*/
		if (Double.doubleToLongBits(seedsCost) != Double.doubleToLongBits(other.seedsCost))
			return false;
		if (seedsDescription == null) {
			if (other.seedsDescription != null)
				return false;
		} else if (!seedsDescription.equals(other.seedsDescription))
			return false;
		if (seedsPerPacket == null) {
			if (other.seedsPerPacket != null)
				return false;
		} else if (!seedsPerPacket.equals(other.seedsPerPacket))
			return false;
		if (seedsStock == null) {
			if (other.seedsStock != null)
				return false;
		} else if (!seedsStock.equals(other.seedsStock))
			return false;
		if (temparature == null) {
			if (other.temparature != null)
				return false;
		} else if (!temparature.equals(other.temparature))
			return false;
		if (typeOfSeeds == null) {
			if (other.typeOfSeeds != null)
				return false;
		} else if (!typeOfSeeds.equals(other.typeOfSeeds))
			return false;
		if (watering == null) {
			if (other.watering != null)
				return false;
		} else if (!watering.equals(other.watering))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SeedDTO [seedId=" + seedId + ", commonName=" + commonName + ", bloomTime=" + bloomTime + ", watering="
				+ watering + ", difficultyLevel=" + difficultyLevel + ", temparature=" + temparature + ", typeOfSeeds="
				+ typeOfSeeds + ", seedsDescription=" + seedsDescription + ", seedsStock=" + seedsStock + ", seedsCost="
				+ seedsCost + ", seedsPerPacket=" + seedsPerPacket + "]";
	}
	
	
	
}
