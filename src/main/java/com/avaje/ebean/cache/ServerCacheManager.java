package com.avaje.ebean.cache;

/**
 * The cache service for server side caching of beans and query results.
 */
public interface ServerCacheManager {

  /**
   * Return true if there is an active bean cache for this type of bean.
   */
  boolean isBeanCaching(Class<?> beanType);

  /**
   * Return the cache for mapping natural keys to id values.
   */
  ServerCache getNaturalKeyCache(Class<?> beanType);

  /**
   * Return the cache for beans of a particular type.
   */
  ServerCache getBeanCache(Class<?> beanType);

  /**
   * Return the cache for associated many properties of a bean type.
   */
  ServerCache getCollectionIdsCache(Class<?> beanType, String propertyName);

  /**
   * Return the cache for query results of a particular type of bean.
   */
  ServerCache getQueryCache(Class<?> beanType);

  /**
   * This clears both the bean and query cache for a given type.
   */
  void clear(Class<?> beanType);

  /**
   * Clear all the caches.
   */
  void clearAll();

}
