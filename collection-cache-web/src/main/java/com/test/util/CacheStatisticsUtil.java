/**
 * 
 */
package com.test.util;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.stat.QueryStatistics;
import org.hibernate.stat.SecondLevelCacheStatistics;
import org.hibernate.stat.Statistics;

/**
 * @author Debashish Mitra
 *
 */
public class CacheStatisticsUtil {
	/**
	 * Temporary utility method for getting statistics of the caches. To get info about all parameters at runtime, debug and inspect
	 * the 'statistics' and 'cacheStatistics' variables in the method below
	 * 
	 */
	public static void printCacheStatistics(Session session) {
		Statistics statistics = session.getSessionFactory().getStatistics();
		String[] regions = statistics.getSecondLevelCacheRegionNames();
		
		//Printing the names of all the caches loaded in memory
		System.out.println("+++++++++++++++++ The following caches have been loaded +++++++++++++++++++++++++");
		for (String region : regions) {
			System.out.println(region);
		}
		//Printing the Put count, Hit count and Miss count for all the caches
		System.out.println("+++++++++++++++++ Printing Statistics for the loaded caches +++++++++++++++++++++++++");
		for(String region: regions) {
			System.out.println("Cache Name : " + region);
			SecondLevelCacheStatistics cacheStatistics = statistics.getSecondLevelCacheStatistics(region);
			System.out.println("Put Count : " + cacheStatistics.getPutCount());
			System.out.println("Hit Count : " + cacheStatistics.getHitCount());
			System.out.println("Miss Count : " + cacheStatistics.getMissCount());
			
			
			//See info for the caches (except the query caches - which are inspected differently)
			if((region.contains("-") && !region.equals("query-cache")) || region.contains("com.macys")) {
				//Inspect the 'cacheEntries' variable in Debug mode to see the actual contents of the cache
				Map cacheEntries = session.getSessionFactory().getStatistics().getSecondLevelCacheStatistics(region).getEntries();
				//Put breakpoint in the line hereunder for debugging 'cacheEntries' above
				System.out.println("Total number of entries in cache " + region + " is " + cacheEntries.size());
			} else {
				//Query Cache info
				if (region.equals("org.hibernate.cache.internal.StandardQueryCache") || region.equals("query-cache")) {
					QueryStatistics queryStatistics = statistics.getQueryStatistics(region);
					System.out.println("Query cache Put count - " + queryStatistics.getCachePutCount());
					System.out.println("Query cache Miss count - " + queryStatistics.getCacheMissCount());
					System.out.println("Query cache Hit count - " + queryStatistics.getCacheHitCount());
				}
			}
			System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		}
	}
}
