package idv.hsiehpinghan.querydsljpaassistant.service;

import idv.hsiehpinghan.querydsljpaassistant.entity.CacheModeOneEntity;
import idv.hsiehpinghan.querydsljpaassistant.entity.QCacheModeOneEntity;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;

import com.querydsl.jpa.hibernate.HibernateQueryFactory;

@Service
@Transactional
public class CacheModeService {
	private QCacheModeOneEntity qEntity = QCacheModeOneEntity.cacheModeOneEntity;
	@Autowired
	private SessionFactory sessionFactory;

	public void save(CacheModeOneEntity entity) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(entity);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public void cacheModePut(Long id) {
		CacheMode cacheMode = CacheMode.PUT;
		long entityLoadCount = 1;
		long secondLevelCacheMissCount = 0;
		long secondLevelCacheHitCount = 0;
		long secondLevelCachePutCount = 1;
		assertCacheMode(id, cacheMode, entityLoadCount,
				secondLevelCacheMissCount, secondLevelCacheHitCount,
				secondLevelCachePutCount);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public void cacheModeNormal(Long id) {
		CacheMode cacheMode = CacheMode.NORMAL;
		long entityLoadCount = 1;
		long secondLevelCacheMissCount = 1;
		long secondLevelCacheHitCount = 0;
		long secondLevelCachePutCount = 1;
		assertCacheMode(id, cacheMode, entityLoadCount,
				secondLevelCacheMissCount, secondLevelCacheHitCount,
				secondLevelCachePutCount);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public void cacheModeIgnore(Long id) {
		CacheMode cacheMode = CacheMode.IGNORE;
		long entityLoadCount = 1;
		long secondLevelCacheMissCount = 0;
		long secondLevelCacheHitCount = 0;
		long secondLevelCachePutCount = 0;
		assertCacheMode(id, cacheMode, entityLoadCount,
				secondLevelCacheMissCount, secondLevelCacheHitCount,
				secondLevelCachePutCount);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public void cacheModeGet(Long id) {
		CacheMode cacheMode = CacheMode.GET;
		long entityLoadCount = 1;
		long secondLevelCacheMissCount = 1;
		long secondLevelCacheHitCount = 0;
		long secondLevelCachePutCount = 0;
		assertCacheMode(id, cacheMode, entityLoadCount,
				secondLevelCacheMissCount, secondLevelCacheHitCount,
				secondLevelCachePutCount);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public void cacheModeRefresh(Long id) {
		CacheMode cacheMode = CacheMode.REFRESH;
		long entityLoadCount = 1;
		long secondLevelCacheMissCount = 0;
		long secondLevelCacheHitCount = 0;
		long secondLevelCachePutCount = 1;
		assertCacheMode(id, cacheMode, entityLoadCount,
				secondLevelCacheMissCount, secondLevelCacheHitCount,
				secondLevelCachePutCount);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public void timeToLiveSeconds_0(Long id) {
		sessionFactory.getCache().evictEntityRegion(CacheModeOneEntity.class);
		long entityLoadCount = 1;
		long secondLevelCacheMissCount = 1;
		long secondLevelCacheHitCount = 0;
		long secondLevelCachePutCount = 1;
		assertTimeToLiveSeconds(sessionFactory, id, entityLoadCount,
				secondLevelCacheMissCount, secondLevelCacheHitCount,
				secondLevelCachePutCount);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public void timeToLiveSeconds_1(Long id) {
		long entityLoadCount = 0;
		long secondLevelCacheMissCount = 0;
		long secondLevelCacheHitCount = 1;
		long secondLevelCachePutCount = 0;
		assertTimeToLiveSeconds(sessionFactory, id, entityLoadCount,
				secondLevelCacheMissCount, secondLevelCacheHitCount,
				secondLevelCachePutCount);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public void timeToLiveSeconds_2(Long id) {
		long entityLoadCount = 1;
		long secondLevelCacheMissCount = 1;
		long secondLevelCacheHitCount = 0;
		long secondLevelCachePutCount = 1;
		assertTimeToLiveSeconds(sessionFactory, id, entityLoadCount,
				secondLevelCacheMissCount, secondLevelCacheHitCount,
				secondLevelCachePutCount);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public void queryDslCache_0(Long id) {
		sessionFactory.getCache().evictEntityRegion(CacheModeOneEntity.class);
		long entityLoadCount_0 = 1;
		long secondLevelCacheMissCount_0 = 0;
		long secondLevelCacheHitCount_0 = 0;
		long secondLevelCachePutCount_0 = 1;
		assertQueryDslCache(sessionFactory, id, entityLoadCount_0,
				secondLevelCacheMissCount_0, secondLevelCacheHitCount_0,
				secondLevelCachePutCount_0);
		long entityLoadCount_1 = 0;
		long secondLevelCacheMissCount_1 = 0;
		long secondLevelCacheHitCount_1 = 0;
		long secondLevelCachePutCount_1 = 0;
		assertQueryDslCache(sessionFactory, id, entityLoadCount_1,
				secondLevelCacheMissCount_1, secondLevelCacheHitCount_1,
				secondLevelCachePutCount_1);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public void queryDslCache_1(Long id) {
		long entityLoadCount = 1;
		long secondLevelCacheMissCount = 0;
		long secondLevelCacheHitCount = 0;
		long secondLevelCachePutCount = 0;
		assertQueryDslCache(sessionFactory, id, entityLoadCount,
				secondLevelCacheMissCount, secondLevelCacheHitCount,
				secondLevelCachePutCount);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public void queryCache_0(Long id) {
		sessionFactory.getCache().evictEntityRegion(CacheModeOneEntity.class);
		long prepareStatementCount = 1;
		long queryCacheMissCount = 1;
		long queryCacheHitCount = 0;
		long queryCachePutCount = 1;
		assertQueryCache(sessionFactory, id, prepareStatementCount,
				queryCacheMissCount, queryCacheHitCount, queryCachePutCount);
	}

	public void queryCache_1(Long id) {
		long prepareStatementCount = 0;
		long queryCacheMissCount = 0;
		long queryCacheHitCount = 1;
		long queryCachePutCount = 0;
		assertQueryCache(sessionFactory, id, prepareStatementCount,
				queryCacheMissCount, queryCacheHitCount, queryCachePutCount);
	}

	private void assertQueryCache(SessionFactory sessionFactory, Long id,
			long prepareStatementCount, long queryCacheMissCount,
			long queryCacheHitCount, long queryCachePutCount) {
		Statistics statistics = clearAndGetStatistics(sessionFactory);
		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery("from CacheModeOneEntity e where e.id = :id");
		query.setLong("id", id);
		query.setCacheable(true);
		query.uniqueResult();
		Assert.assertEquals(statistics.getPrepareStatementCount(),
				prepareStatementCount);
		Assert.assertEquals(statistics.getQueryCacheMissCount(),
				queryCacheMissCount);
		Assert.assertEquals(statistics.getQueryCacheHitCount(),
				queryCacheHitCount);
		Assert.assertEquals(statistics.getQueryCachePutCount(),
				queryCachePutCount);
	}

	private void assertQueryDslCache(SessionFactory sessionFactory, Long id,
			long entityLoadCount, long secondLevelCacheMissCount,
			long secondLevelCacheHitCount, long secondLevelCachePutCount) {
		Statistics statistics = clearAndGetStatistics(sessionFactory);
		Session session = sessionFactory.getCurrentSession();
		getHibernateQueryFactory(session).from(qEntity)
				.where(qEntity.id.eq(id)).fetchOne();
		Assert.assertEquals(statistics.getEntityLoadCount(), entityLoadCount);
		Assert.assertEquals(statistics.getSecondLevelCacheMissCount(),
				secondLevelCacheMissCount);
		Assert.assertEquals(statistics.getSecondLevelCacheHitCount(),
				secondLevelCacheHitCount);
		Assert.assertEquals(statistics.getSecondLevelCachePutCount(),
				secondLevelCachePutCount);
	}

	private void assertTimeToLiveSeconds(SessionFactory sessionFactory,
			Long id, long entityLoadCount, long secondLevelCacheMissCount,
			long secondLevelCacheHitCount, long secondLevelCachePutCount) {
		Statistics statistics = clearAndGetStatistics(sessionFactory);
		Session session = sessionFactory.getCurrentSession();
		session.get(CacheModeOneEntity.class, id);
		Assert.assertEquals(statistics.getEntityLoadCount(), entityLoadCount);
		Assert.assertEquals(statistics.getSecondLevelCacheMissCount(),
				secondLevelCacheMissCount);
		Assert.assertEquals(statistics.getSecondLevelCacheHitCount(),
				secondLevelCacheHitCount);
		Assert.assertEquals(statistics.getSecondLevelCachePutCount(),
				secondLevelCachePutCount);
	}

	private void assertCacheMode(Long id, CacheMode cacheMode,
			long entityLoadCount, long secondLevelCacheMissCount,
			long secondLevelCacheHitCount, long secondLevelCachePutCount) {
		Statistics statistics = clearAndGetStatistics(sessionFactory);
		Session session = evictAndGetSession(sessionFactory);
		session.setCacheMode(cacheMode);
		CacheModeOneEntity entity = (CacheModeOneEntity) session.load(
				CacheModeOneEntity.class, id);
		entity.getName();
		Assert.assertEquals(statistics.getEntityLoadCount(), entityLoadCount);
		Assert.assertEquals(statistics.getSecondLevelCacheMissCount(),
				secondLevelCacheMissCount);
		Assert.assertEquals(statistics.getSecondLevelCacheHitCount(),
				secondLevelCacheHitCount);
		Assert.assertEquals(statistics.getSecondLevelCachePutCount(),
				secondLevelCachePutCount);
	}

	private Session evictAndGetSession(SessionFactory sessionFactory) {
		sessionFactory.getCache().evictEntityRegion(CacheModeOneEntity.class);
		return sessionFactory.openSession();
	}

	private Statistics clearAndGetStatistics(SessionFactory sessionFactory) {
		Statistics statistics = sessionFactory.getStatistics();
		statistics.clear();
		return statistics;
	}

	private HibernateQueryFactory getHibernateQueryFactory(Session session) {
		return new HibernateQueryFactory(session);
	}
}
