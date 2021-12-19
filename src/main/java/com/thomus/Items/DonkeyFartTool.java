package com.thomus.Items;


import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class DonkeyFartTool extends PickaxeItem {

    public DonkeyFartTool(Properties properties) {
        super(ItemTier.NETHERITE, 1, -2.8F, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World level, List<ITextComponent> list, ITooltipFlag flags) {
        super.appendHoverText(stack, level, list, flags);
        int charge = stack.hasTag() ? stack.getTag().getInt("charge"):100;
        list.add(new TranslationTextComponent("message.donkeyfarttool.tooltip",Integer.toString(charge)).withStyle(TextFormatting.DARK_AQUA));
    }

    @Override
    public ActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(hand);
        int charge = stack.getOrCreateTag().getInt("charge");
        player.setDeltaMovement(0,1,0);
        charge--;
        if (level.isClientSide()) {
            player.sendMessage(new TranslationTextComponent("message.donkefarttool.change",Integer.toString((charge))), Util.NIL_UUID);
        }
        stack.getTag().putInt("charge", charge);
        return ActionResult.success(stack);
    }

    @Override
    public boolean mineBlock(ItemStack p_179218_1_, World p_179218_2_, BlockState p_179218_3_, BlockPos p_179218_4_, LivingEntity p_179218_5_) {
        return super.mineBlock(p_179218_1_, p_179218_2_, p_179218_3_, p_179218_4_, p_179218_5_);
    }
}
