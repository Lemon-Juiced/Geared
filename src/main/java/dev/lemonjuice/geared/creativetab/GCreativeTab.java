package dev.lemonjuice.geared.creativetab;

import dev.lemonjuice.geared.Geared;
import dev.lemonjuice.geared.item.GItems;
import dev.lemonjuice.geared.item.tool.GearSwordItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Geared.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GEARED_ITEMS_TAB = CREATIVE_MODE_TABS.register("geared_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.geared_items.tab"))
            .icon(() -> new ItemStack(GItems.WOODEN_GEAR.get()))
            .build());

    public static void registerTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == GEARED_ITEMS_TAB.get()) {
            event.accept(GItems.WOODEN_GEAR.get());
            event.accept(GItems.STONE_GEAR.get());
            event.accept(GItems.IRON_GEAR.get());
            event.accept(GItems.GOLDEN_GEAR.get());
            event.accept(GItems.DIAMOND_GEAR.get());
            event.accept(GItems.NETHERITE_GEAR.get());

            for (DeferredHolder<Item, ? extends Item> item: GItems.ITEMS.getEntries()) {
                if(item.get() instanceof GearSwordItem)
                    event.accept(item.get());
            }
        }
    }

    public static void register(IEventBus eventBus) {CREATIVE_MODE_TABS.register(eventBus);}
}
