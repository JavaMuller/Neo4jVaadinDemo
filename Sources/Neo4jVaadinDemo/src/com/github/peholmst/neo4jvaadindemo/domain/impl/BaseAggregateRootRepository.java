package com.github.peholmst.neo4jvaadindemo.domain.impl;

import org.neo4j.graphdb.NotFoundException;
import org.neo4j.graphdb.RelationshipType;

public abstract class BaseAggregateRootRepository extends BaseRepository {

	public BaseAggregateRootRepository(GraphDatabaseServiceProvider serviceProvider,
			RelationshipType startToSubrefType,
			RelationshipType subrefToNodesType) {
		super(serviceProvider, startToSubrefType, subrefToNodesType);
	}

	protected static final String KEY_COUNTER = "counter";

	protected synchronized long getNextId() {
		Long counter = null;
		try {
			counter = (Long) getFactoryNode().getProperty(KEY_COUNTER);
		} catch (NotFoundException e) {
			counter = 0L;
		}
		getFactoryNode().setProperty(KEY_COUNTER, new Long(counter + 1));
		return counter;
	}
}
