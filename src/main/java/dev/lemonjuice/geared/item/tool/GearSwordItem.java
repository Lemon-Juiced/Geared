package dev.lemonjuice.geared.item.tool;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class GearSwordItem extends SwordItem {
    public GearSwordItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    /**
     * Upon right-click with the item, repair 1 durability.
     * If the stack is at max durability, do nothing.
     *
     * @param level The level
     * @param player The player using the item
     * @param usedHand The hand used
     */
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        // Get the correct hand
        ItemStack stack = player.getItemInHand(usedHand);

        // Repair 1 durability
        int maxDurability = stack.getMaxDamage();
        int currentDurability = maxDurability - stack.getDamageValue();
        if (currentDurability < maxDurability) stack.setDamageValue(stack.getDamageValue() - 1);

        return super.use(level, player, usedHand);
    }

    /**
     * Add tooltip to the item.
     *
     * @param stack The item stack
     * @param context The tooltip context
     * @param tooltipComponents The list of tooltip components
     * @param tooltipFlag The tooltip flag
     */
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        Component component = Component.translatable("tooltip.geared.gear_tool").withStyle(ChatFormatting.GRAY);
        tooltipComponents.add(component);
    }
}
