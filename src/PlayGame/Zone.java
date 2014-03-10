package PlayGame;

import java.io.Serializable;
import java.util.UUID;

import Profile.Player;

/**
 * @author Frank Chen
 * @version 0.1
 * @since 2014-01-01
 */
public class Zone implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7366511024130652320L;
	private Keyword zoneType;
	private Player associatedPlayer;
	private UUID zoneID;

	public Zone() {
		setZoneID(UUID.randomUUID());
	}

	public Zone(Keyword zoneType) {
		setZoneType(zoneType);
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
	 * @param zoneID
	 *            the zoneID to set
	 */
	public void setZoneID(UUID zoneID) {
		this.zoneID = zoneID;
	}

	/**
	 * @return the associatedPlayer
	 */
	public Player getAssociatedPlayer() {
		return associatedPlayer;
	}

	/**
	 * @param associatedPlayer
	 *            the associatedPlayer to set
	 */
	public void setAssociatedPlayer(Player associatedPlayer) {
		this.associatedPlayer = associatedPlayer;
	}

	public String toString() {
		return getZoneType().toString();
	}
}
