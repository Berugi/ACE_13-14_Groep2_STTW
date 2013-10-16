package model.enums;
import java.util.*;

public enum TijdStatus {
	VROEG("Voor 8 uur"),
	LAAT("Na 21 uur"),
	MEDIUM("Tussen 8 uur en 21 uur");
	
	private final String momentVanDag;
	
	private String getMomentVanDag(){
		return momentVanDag;
	}
	
/*	public String toString(){
		return this.name().toLowerCase();
	}*/
	
	TijdStatus(String momentVanDag){
		this.momentVanDag = momentVanDag;
	}
	
	public static void main(String[] args) {
		for (TijdStatus tijdStatus : TijdStatus.values()){
			System.out.println(tijdStatus+","+tijdStatus.getMomentVanDag());
			TijdStatus ts = TijdStatus.MEDIUM;
			
		}
			
	}

}