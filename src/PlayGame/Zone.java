package PlayGame;

import java.util.UUID;

/**
 * @author Frank Chen
 * @version 0.1
 * @since 2014-01-01
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
