
package net.mcreator.simplemissiles.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class NavigationSystemItem extends Item {
	public NavigationSystemItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
