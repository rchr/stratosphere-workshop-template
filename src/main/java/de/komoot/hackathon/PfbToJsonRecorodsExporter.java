package de.komoot.hackathon;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividsolutions.jts.geom.Geometry;
import de.komoot.hackathon.openstreetmap.*;
import org.openstreetmap.osmosis.pbf2.v0_6.PbfReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.List;

/**
 * Exports a Pbf openstreetmap file to a file containing rows of json objects.
 *
 * @author jan
 */
public class PfbToJsonRecorodsExporter {
	/** automatically generated Logger statement. */
	private final static org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PfbToJsonRecorodsExporter.class);

	public static void main(String[] args) throws IOException {
		PbfReader in = new PbfReader(new File(args[0]), 4);
		OsmToKmtSink out = new OsmToKmtSink(10000);
		in.setSink(out);
		in.run();

		File directory = new File(args[1]);

		writeGeometries(out.getNodes(), out.getWays(), out.getAreas(), directory);
		LOGGER.info("Wrote all files to " + directory);
	}

	private static void write(Collection<? extends OsmEntity<?>> entities, Writer writer, ObjectMapper mapper) throws IOException {
		for(OsmEntity<?> e : entities) {
			JsonGeometryEntity<Geometry> g = new JsonGeometryEntity<Geometry>(e.getId(), e.getGeometry(), e.getTags());
			mapper.writeValue(writer, g);
			writer.write('\n');
		}
	}

	private static void writeGeometries(List<OsmNode> nodes, List<OsmWay> ways, List<OsmArea> areas, File directory) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new GeometryModule());
		mapper.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);

		try(Writer writer = new FileWriter(new File(directory, "nodes-raw.csv"))) {
			write(nodes, writer, mapper);
		}

		try(Writer writer = new FileWriter(new File(directory, "ways-raw.csv"))) {
			write(ways, writer, mapper);
		}

		try(Writer writer = new FileWriter(new File(directory, "areas-raw.csv"))) {
			write(areas, writer, mapper);
		}
	}
}
