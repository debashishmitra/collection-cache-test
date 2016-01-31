package com.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.test.entity.Country;
import com.test.util.CacheStatisticsUtil;

/**
 * @author Debashish Mitra
 *
 */
@Repository("locationDao")
public class LocationDaoImpl implements LocationDao {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Country> getAllCountries() {
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Country.class).setCacheable(true).setCacheRegion("query-cache");
	List<Country> countries = criteria.list();
	CacheStatisticsUtil.printCacheStatistics(sessionFactory.getCurrentSession());
	return countries;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }
}
