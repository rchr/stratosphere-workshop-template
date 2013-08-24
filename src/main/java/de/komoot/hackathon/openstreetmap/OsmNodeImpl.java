package de.komoot.hackathon.openstreetmap;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Point;

import java.util.Map;

/** @author jan */
public class OsmNodeImpl extends OsmEntityImpl<Point> implements OsmNode {

	public OsmNodeImpl(long osmId, Point geometry, Map<String, String> tags) {
		super(osmId, geometry, tags);
	}

	@Override
	public Coordinate getCoordinate() {
		Point g = getGeometry();
		return g == null ? null : g.getCoordinate();
	}

	@Override
	public String getId() {
		return "N" + getOsmId();
	}
}
