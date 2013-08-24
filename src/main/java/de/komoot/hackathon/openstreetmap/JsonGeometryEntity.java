package de.komoot.hackathon.openstreetmap;

import com.vividsolutions.jts.geom.Geometry;

import java.util.Map;

/**
 *
 * @author jan
 */
public class JsonGeometryEntity<T extends Geometry> {

	private final String id;

	private final T geometry;

	private final Map<String, String> tags;

	public JsonGeometryEntity(String id, T geometry, Map<String, String> tags) {
		this.id = id;
		this.geometry = geometry;
		this.tags = tags;
	}

	public String getId() {
		return id;
	}

	public T getGeometry() {
		return geometry;
	}

	public Map<String, String> getTags() {
		return tags;
	}
}
