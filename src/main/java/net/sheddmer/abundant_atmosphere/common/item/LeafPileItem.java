package net.sheddmer.abundant_atmosphere.common.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class LeafPileItem extends BlockItem {

    public LeafPileItem(Block block, Item.Properties properties) {
        super(block, properties);
    }

    @Override
    @NotNull
    public InteractionResult useOn(@NotNull UseOnContext context) {
        return InteractionResult.PASS;
    }

    @Override
    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        BlockHitResult blockhitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
        BlockHitResult blockhitresult1 = blockhitresult.withPosition(blockhitresult.getBlockPos().relative(blockhitresult.getDirection()));
        InteractionResult interactionresult;
        if (level.getBlockState(blockhitresult.getBlockPos()).is(this.getBlock())) {
            interactionresult = super.useOn(new UseOnContext(player, hand, blockhitresult));
        } else {
            interactionresult = super.useOn(new UseOnContext(player, hand, blockhitresult1));
        }
        return new InteractionResultHolder<>(interactionresult, player.getItemInHand(hand));
    }
}