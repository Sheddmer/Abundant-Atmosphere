package net.sheddmer.abundant_atmosphere.init;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;
import net.sheddmer.abundant_atmosphere.common.block.MidnightLilyBlock;
import net.sheddmer.abundant_atmosphere.common.block.MudLampBlock;
import net.sheddmer.abundant_atmosphere.common.block.StoneBrazierBlock;
import net.sheddmer.abundant_atmosphere.common.block.WallMudLampBlock;

@EventBusSubscriber(modid = AbundantAtmosphere.MODID)
public class AAEvents {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        Player player = event.getEntity();
        ItemStack stack = event.getItemStack();
        // Bonemealing events
        if (stack.is(Items.BONE_MEAL) && !player.isSpectator()) {
            // Growing trees from Pumpkins
            if (state.is(Blocks.PUMPKIN) && level.getBlockState(pos.below()).is(BlockTags.DIRT)) {
                level.playSound(player, pos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0f, 1.0f);
                level.addParticle(ParticleTypes.COMPOSTER, pos.getX() + Math.random(), pos.getY() + 0.2 + Math.random(), pos.getZ() + Math.random(), 0, 0, 0);
                if (!level.isClientSide && !player.isCreative()) stack.shrink(1);
                if (!level.isClientSide && level.random.nextFloat() < 0.35) {
                    advancePumpkinTree((ServerLevel) level, pos, state, level.random);
                }
                event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
                event.setCanceled(true);
            }
        }
        // Shearing events
        if (stack.canPerformAction(ItemAbilities.SHEARS_TRIM) && !player.isSpectator()) {
            // Clipping Midnight Lilies
            if (state.is(AABlocks.MIDNIGHT_LILY) && !state.getValue(MidnightLilyBlock.PERSISTENT)) {
                level.playSound(player, pos, SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0f, 1.0f);
                level.setBlockAndUpdate(pos, state.setValue(MidnightLilyBlock.PERSISTENT, true));
                if (!level.isClientSide && !player.isCreative()) stack.hurtAndBreak(1, player, stack.getEquipmentSlot());
                if (state.getValue(MidnightLilyBlock.NIGHTLIGHT))
                    level.setBlockAndUpdate(pos, state.setValue(MidnightLilyBlock.NIGHTLIGHT, false));

                level.gameEvent(player, GameEvent.SHEAR, pos);
                event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
                event.setCanceled(true);
            }
            // Removing moss from mossy blocks
            if (state.is(Blocks.MOSSY_COBBLESTONE) || state.is(Blocks.MOSSY_COBBLESTONE_STAIRS) || state.is(Blocks.MOSSY_COBBLESTONE_SLAB) || state.is(Blocks.MOSSY_COBBLESTONE_WALL) || state.is(Blocks.MOSSY_STONE_BRICKS) || state.is(Blocks.MOSSY_STONE_BRICK_STAIRS) || state.is(Blocks.MOSSY_STONE_BRICK_SLAB) || state.is(Blocks.MOSSY_STONE_BRICK_WALL) || state.is(Blocks.INFESTED_MOSSY_STONE_BRICKS) || state.is(AABlocks.MOSSY_STONE) || state.is(AABlocks.MOSSY_BASALT)) {
                level.playSound(player, pos, SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0f, 1.0f);
                level.playSound(player, pos, SoundEvents.MOSS_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);
                if (!level.isClientSide && !player.isCreative()) stack.hurtAndBreak(1, player, stack.getEquipmentSlot());
                ParticleUtils.spawnParticlesOnBlockFaces(level, pos, new BlockParticleOption(ParticleTypes.BLOCK, Blocks.MOSS_BLOCK.defaultBlockState()), UniformInt.of(1, 1));
                level.setBlockAndUpdate(pos, state.is(Blocks.MOSSY_COBBLESTONE) ? Blocks.COBBLESTONE.withPropertiesOf(state) : state.is(Blocks.MOSSY_COBBLESTONE_STAIRS) ? Blocks.COBBLESTONE_STAIRS.withPropertiesOf(state) : state.is(Blocks.MOSSY_COBBLESTONE_SLAB) ? Blocks.COBBLESTONE_SLAB.withPropertiesOf(state) : state.is(Blocks.MOSSY_COBBLESTONE_WALL) ? Blocks.COBBLESTONE_WALL.withPropertiesOf(state) : state.is(Blocks.MOSSY_STONE_BRICKS) ? Blocks.STONE_BRICKS.withPropertiesOf(state) : state.is(Blocks.MOSSY_STONE_BRICK_STAIRS) ? Blocks.STONE_BRICK_STAIRS.withPropertiesOf(state) : state.is(Blocks.MOSSY_STONE_BRICK_SLAB) ? Blocks.STONE_BRICK_SLAB.withPropertiesOf(state) : state.is(Blocks.MOSSY_STONE_BRICK_WALL) ? Blocks.STONE_BRICK_WALL.withPropertiesOf(state) : state.is(Blocks.INFESTED_MOSSY_STONE_BRICKS) ? Blocks.INFESTED_STONE_BRICKS.withPropertiesOf(state) : state.is(AABlocks.MOSSY_STONE) ? Blocks.STONE.withPropertiesOf(state) : state.is(AABlocks.MOSSY_BASALT) ? Blocks.BASALT.withPropertiesOf(state) : state);
                if (!level.isClientSide && level.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) Block.popResourceFromFace(level, pos, event.getFace(), AABlocks.MOSS_CLUMP.toStack());

                event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
                event.setCanceled(true);
            }
            // Removing irish moss from blocks
            if (state.is(AABlocks.MOSSY_DEEPSLATE) || state.is(AABlocks.MOSSY_COBBLED_DEEPSLATE) || state.is(AABlocks.MOSSY_POLISHED_DEEPSLATE) || state.is(AABlocks.MOSSY_DEEPSLATE_BRICKS) || state.is(AABlocks.MOSSY_DEEPSLATE_TILES)) {
                level.playSound(player, pos, SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0f, 1.0f);
                level.playSound(player, pos, SoundEvents.MOSS_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);
                if (!level.isClientSide && !player.isCreative()) stack.hurtAndBreak(1, player, stack.getEquipmentSlot());
                ParticleUtils.spawnParticlesOnBlockFaces(level, pos, new BlockParticleOption(ParticleTypes.BLOCK, AABlocks.IRISH_MOSS_BLOCK.get().defaultBlockState()), UniformInt.of(1, 1));
            level.setBlockAndUpdate(pos, state.is(AABlocks.MOSSY_DEEPSLATE) ? Blocks.DEEPSLATE.withPropertiesOf(state) : state.is(AABlocks.MOSSY_COBBLED_DEEPSLATE) ? Blocks.COBBLED_DEEPSLATE.withPropertiesOf(state) : state.is(AABlocks.MOSSY_POLISHED_DEEPSLATE) ? Blocks.POLISHED_DEEPSLATE.withPropertiesOf(state) : state.is(AABlocks.MOSSY_DEEPSLATE_BRICKS) ? Blocks.DEEPSLATE_BRICKS.withPropertiesOf(state) : state.is(AABlocks.MOSSY_DEEPSLATE_TILES) ? Blocks.DEEPSLATE_TILES.withPropertiesOf(state) : state);
                if (!level.isClientSide && level.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) Block.popResourceFromFace(level, pos, event.getFace(), AABlocks.IRISH_MOSS_CLUMP.toStack());

                event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
                event.setCanceled(true);
            }
        }
        // Shoveling events
        if (stack.canPerformAction(ItemAbilities.SHOVEL_FLATTEN) && !player.isSpectator()) {
            // Emptying Mud from Muddy roots
            if (state.is(Blocks.MUDDY_MANGROVE_ROOTS)) {
                level.playSound(player, pos, SoundEvents.MUD_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);
                if (!level.isClientSide && !player.isCreative()) stack.hurtAndBreak(1, player, stack.getEquipmentSlot());
                ParticleUtils.spawnParticlesOnBlockFaces(level, pos, new BlockParticleOption(ParticleTypes.BLOCK, Blocks.MUD.defaultBlockState()), UniformInt.of(2, 2));
                level.setBlockAndUpdate(pos, Blocks.MANGROVE_ROOTS.defaultBlockState());
                if (!level.isClientSide && level.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) Block.popResourceFromFace(level, pos, event.getFace(), Items.MUD.getDefaultInstance());

                event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
                event.setCanceled(true);
            }
        }
    }

    public static void advancePumpkinTree(ServerLevel level, BlockPos pPos, BlockState pState, RandomSource pRandom) {
        TreeGrower.OAK.growTree(level, level.getChunkSource().getGenerator(), pPos, pState, pRandom);

    }

}
