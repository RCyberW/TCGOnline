package PlayGame;

import java.util.UUID;

import BuildDeck.Keyword;

/**
 * @author Frank Chen
 * Field zone representation
 */
public class Zone {
	private Keyword zoneType;
	private UUID zoneID;

	public Zone() {
		setZoneID(UUID.randomUUID());
	}

	/**
	 * @return the zoneType
	 */
	public Keyword getZoneType() {
		return zoneType;
	}

	/**
	 * @param zoneType
	 *            the zoneType to set
	 */
	public void setZoneType(Keyword zoneType) {
		this.zoneType = zoneType;
	}

	/**
	 * @return the zoneID
	 */
	public UUID getZoneID() {
		return zoneID;
	}

	/**
	 * @param zoneID the zoneID to set
	 */
	public void setZoneID(UUID zoneID) {
		this.zoneID = zoneID;
	}
}
