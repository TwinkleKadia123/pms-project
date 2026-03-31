package com.pms.building.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.pms.building.dao.BuildingsRepository;
import com.pms.building.dao.IBuildingDAO;
import com.pms.building.entity.Building;
import com.pms.building.service.IBuildingService;
import com.pms.search.specification.BuildingSpecification;;

@Service
public class BuildingServiceImpl implements IBuildingService {

static final Logger logger = LoggerFactory.getLogger(BuildingServiceImpl.class);
	
	@Autowired
	private IBuildingDAO dao;
	
	@Autowired
	private BuildingsRepository buildingRepository;
	
	

	public BuildingServiceImpl(IBuildingDAO dao, BuildingsRepository buildingRepository) {
		super();
		this.dao = dao;
		this.buildingRepository = buildingRepository;
	}

	public List<Building> getBuildings() {
//		return dao.getFloors();
		return buildingRepository.findAll();
	}

	public Building createBuilding(Building building) {
//		return dao.createFloor(Floor);
		 return buildingRepository.saveAndFlush(building);
	}

	public Building updateBuilding(int buildingId, Building building) {
		return dao.updateBuilding(buildingId, building);
	}

	public Building getBuilding(int buildingId) {
		return dao.getBuilding(buildingId);
	}

	public boolean deleteBuilding(int buildingId) {
		return dao.deleteBuilding(buildingId);
	}
	
	
	 public Building getBuildingById(Integer id) { // ✅ Implemented method
	        return dao.findById(id);
	    }

	 @Override
	 public List<Building> search(String name, String description) {
	        Specification<Building> spec = Specification
	                .where(BuildingSpecification.hasName(name))
	                .and(BuildingSpecification.hasDescription(description));

	        return buildingRepository.findAll(spec);
	    }

}
