package de.komoot.hackathon.openstreetmap;

import com.google.common.base.Preconditions;
import com.vividsolutions.jts.geom.Geometry;

import java.util.Map;

/**
 * @author jan
 * @date 23.08.13
 */
public abstract class OsmEntityImpl<T extends Geometry> implements OsmEntity<T> {

	private final long osmId;

	private final T geometry;

	private final Map<String,String> tags;

	protected OsmEntityImpl(long osmId, T geometry, Map<String, String> tags) {
		Preconditions.checkNotNull(geometry);
		Preconditions.checkNotNull(tags);
		this.osmId = osmId;
		this.geometry = geometry;
		this.tags = tags;
	}

	public long getOsmId() {
		return osmId;
	}

	public T getGeometry() {
		return geometry;
	}

	public Map<String, String> getTags() {
		return tags;
	}
}
