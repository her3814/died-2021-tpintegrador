package bdd;

import java.util.HashMap;

public class BddInMemoryCache {

	private static HashMap<String, Object> cache = new HashMap<String, Object>();
	private static BddInMemoryCache bddCacheInstance = null;

	public static BddInMemoryCache getCacheInstance() {

		if (bddCacheInstance == null) {
			bddCacheInstance = new BddInMemoryCache();
		}
		return bddCacheInstance;
	}

	public Object get(String key) {
		return cache.get(key);
	}

	public Boolean contains(String key) {
		return cache.containsKey(key);

	}

	public void remove(String key) {
		cache.remove(key);

	}

	public void put(String key, Object val) {
		cache.put(key, val);
	}
}
