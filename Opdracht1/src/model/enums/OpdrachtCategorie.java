package model.enums;

/**
 * 
 * @author TBD
 * 
 * @Version 2013        - Initial version
 * @Version 20131110-01 - Modified by Tom Vaes - Added description.
 *
 */

public enum OpdrachtCategorie {
	TBA(" "),
	WISKUNDE("Wiskunde"),
	AARDRIJKSKUNDE("Aardrijkskunde"),
	NEDERLANDS("Nederlands"),
	WETENSCHAPPEN("Wetenschappen");
	
	private final String description;

	public String getDescription()
	{
		return description;
	}

	private OpdrachtCategorie(String description)
	{
		this.description = description;
	}
	
	@Override
    public String toString() {
        return description;
    }
}
