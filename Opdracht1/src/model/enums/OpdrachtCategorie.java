package model.enums;

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
