
package net.mcreator.simplemissiles.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class LeensItem extends Item {
	public LeensItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
