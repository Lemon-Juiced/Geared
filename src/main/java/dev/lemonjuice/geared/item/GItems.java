package dev.lemonjuice.geared.item;

import dev.lemonjuice.geared.Geared;
import dev.lemonjuice.geared.item.factory.ToolGearFactory;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Geared.MOD_ID);

    // Gears
    public static final DeferredItem<Item> WOODEN_GEAR = ITEMS.registerSimpleItem("wooden_gear", new Item.Properties());
    public static final DeferredItem<Item> STONE_GEAR = ITEMS.registerSimpleItem("stone_gear", new Item.Properties());
    public static final DeferredItem<Item> IRON_GEAR = ITEMS.registerSimpleItem("iron_gear", new Item.Properties());
    public static final DeferredItem<Item> GOLDEN_GEAR = ITEMS.registerSimpleItem("golden_gear", new Item.Properties());
    public static final DeferredItem<Item> DIAMOND_GEAR = ITEMS.registerSimpleItem("diamond_gear", new Item.Properties());
    public static final DeferredItem<Item> NETHERITE_GEAR = ITEMS.registerSimpleItem("netherite_gear", new Item.Properties());

    public static void register(IEventBus eventBus) {
        // Tools
        ToolGearFactory toolGearFactory = new ToolGearFactory(ITEMS);
        toolGearFactory.createSwordItems();

        ITEMS.register(eventBus);
    }
}
