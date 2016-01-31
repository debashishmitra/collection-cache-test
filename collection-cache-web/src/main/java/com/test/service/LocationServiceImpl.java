package com.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.LocationDao;
import com.test.entity.Country;

/**
 * @author Debashish Mitra
 *
 */
@Service("locationService")
public class LocationServiceImpl implements LocationService {

    @Resource(name = "locationDao")
    private LocationDao locationDao;

    @Override
    @Transactional
    public List<Country> getAllCountries() {
	return locationDao.getAllCountries();
    }

    public LocationDao getLocationDao() {
	return locationDao;
    }

    public void setLocationDao(LocationDao locationDao) {
	this.locationDao = locationDao;
    }

}
