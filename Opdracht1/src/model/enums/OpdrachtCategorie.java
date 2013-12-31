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
	
	public static OpdrachtCategorie getCategorie(String cat){
		for(OpdrachtCategorie c: OpdrachtCategorie.values()){
			if(c.getDescription().equalsIgnoreCase(cat))
			{return c;}
		}
		return OpdrachtCategorie.TBA;
	}
	
	@Override
    public String toString() {
        return description;
    }
}
