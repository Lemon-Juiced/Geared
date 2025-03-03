package dev.lemonjuice.geared.item.factory;

import dev.lemonjuice.geared.item.tool.*;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

import static dev.lemonjuice.scalar_core.item.ToolItemPropFactory.getSwordItemProperties;

public class ToolGearFactory {

    private ArrayList<TierPair> gearTiers = new ArrayList<>(List.of(
            new TierPair("wooden", Tiers.WOOD),
            new TierPair("stone", Tiers.STONE),
            new TierPair("iron", Tiers.IRON),
            new TierPair("golden", Tiers.GOLD),
            new TierPair("diamond", Tiers.DIAMOND),
            new TierPair("netherite", Tiers.NETHERITE)
    ));

    public static DeferredRegister.Items ITEMS;

    public ToolGearFactory(DeferredRegister.Items ITEMS) {
        this.ITEMS = ITEMS;
    }

    public void createSwordItems() {
        for (TierPair tierPair : gearTiers) {
            String name = tierPair.getName();
            Tiers tier = tierPair.getTier();
            ITEMS.register(name + "_gear_sword", () -> new GearSwordItem(tier, getSwordItemProperties(tier)));
        }
    }

    public void createPickaxeItems() {
        for (TierPair tierPair : gearTiers) {
            String name = tierPair.getName();
            Tiers tier = tierPair.getTier();
            ITEMS.register(name + "_gear_pickaxe", () -> new GearPickaxeItem(tier, getSwordItemProperties(tier)));
        }
    }

    public void createAxeItems() {
        for (TierPair tierPair : gearTiers) {
            String name = tierPair.getName();
            Tiers tier = tierPair.getTier();
            ITEMS.register(name + "_gear_axe", () -> new GearAxeItem(tier, getSwordItemProperties(tier)));
        }
    }

    public void createShovelItems() {
        for (TierPair tierPair : gearTiers) {
            String name = tierPair.getName();
            Tiers tier = tierPair.getTier();
            ITEMS.register(name + "_gear_shovel", () -> new GearShovelItem(tier, getSwordItemProperties(tier)));
        }
    }

    public void createHoeItems() {
        for (TierPair tierPair : gearTiers) {
            String name = tierPair.getName();
            Tiers tier = tierPair.getTier();
            ITEMS.register(name + "_gear_hoe", () -> new GearHoeItem(tier, getSwordItemProperties(tier)));
        }
    }



    private static class TierPair {
        private String name;
        private Tiers tier;

        public TierPair(String name, Tiers tier) {
            this.name = name;
            this.tier = tier;
        }

        public String getName() {
            return name;
        }

        public Tiers getTier() {
            return tier;
        }
    }
}