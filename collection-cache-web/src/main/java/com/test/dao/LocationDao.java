/**
 * 
 */
package com.test.dao;

import java.util.List;

import com.test.entity.Country;

/**
 * @author Debashish Mitra
 *
 */
public interface LocationDao {
    public List<Country> getAllCountries();
}
