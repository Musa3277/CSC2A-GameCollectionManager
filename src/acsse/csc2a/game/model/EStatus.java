package acsse.csc2a.game.model;

/**
 * enumeration representing the play status of a game.
 * each constant carries a display label and color hex code.
 */
public enum EStatus {
	
	WISHLIST("On Wishlist", "#FFA500"),
	PLAYING("Currently Playing", "#00FF00"),
	COMPLETED("Completed", "#0000FF");
	
	private final String displayLabel;
	private final String colourHex;
	
	/**
	 * private constructor to instantiate new enum instance
	 * 
	 * @param displayLabel
	 * @param colourHex
	 */
	private EStatus(String displayLabel, String colourHex) {
		this.displayLabel = displayLabel;
		this.colourHex = colourHex;
	}
	
	/**
	 * 
	 * @return human readable display label of the status
	 */
	public String getDisplayLabel() {
		return displayLabel;
	}
	
	/**
	 * @return the hex colour code associated with the status
	 */
	public String getColourHex() {
		return colourHex;
	}
}
