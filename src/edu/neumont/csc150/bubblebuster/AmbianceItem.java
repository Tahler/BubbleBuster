package edu.neumont.csc150.bubblebuster;

@SuppressWarnings("serial")
public class AmbianceItem extends ShopItem {
	
	public AmbianceItem(String title, String folderPath, int cost) {
		super(title, folderPath, cost);
		if (Preferences.ambianceFolderLocation.equals(folderPath)) equip();
		else unequip();
	}
	
	public void equip() {
		super.equip();
		Preferences.ambianceFolderLocation = folderPath;
		Preferences.save();
	}
}
