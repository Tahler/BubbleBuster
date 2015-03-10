package edu.neumont.csc150.bubblebuster;

@SuppressWarnings("serial")
public class SkinItem extends ShopItem {
	
	public SkinItem(String title, String folderPath, int cost) {
		super(title, folderPath, cost);
		if (Preferences.skinFolderLocation.equals(folderPath)) equip();
		else unequip();
	}
	
	public void equip() {
		super.equip();
		Preferences.skinFolderLocation = folderPath;
		Preferences.save();
	}
}
