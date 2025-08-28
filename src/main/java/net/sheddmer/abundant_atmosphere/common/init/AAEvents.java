package net.sheddmer.abundant_atmosphere.common.init;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.sheddmer.abundant_atmosphere.AbundantAtmosphere;

@EventBusSubscriber(modid = AbundantAtmosphere.MODID)
public class AAEvents {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        Player player = event.getEntity();
        ItemStack stack = event.getItemStack();
        // Shearing events
        if (stack.canPerformAction(ItemAbilities.SHEARS_TRIM) && !player.isSpectator()) {
            // Removing moss from Stone blocks
            if (state.is(Blocks.MOSSY_COBBLESTONE) || state.is(Blocks.MOSSY_COBBLESTONE_STAIRS) || state.is(Blocks.MOSSY_COBBLESTONE_SLAB) || state.is(Blocks.MOSSY_COBBLESTONE_WALL) || state.is(Blocks.MOSSY_STONE_BRICKS) || state.is(Blocks.MOSSY_STONE_BRICK_STAIRS) || state.is(Blocks.MOSSY_STONE_BRICK_SLAB) || state.is(Blocks.MOSSY_STONE_BRICK_WALL) || state.is(Blocks.INFESTED_MOSSY_STONE_BRICKS) || state.is(AABlocks.MOSSY_STONE) || state.is(AABlocks.MOSSY_STONE_STAIRS) || state.is(AABlocks.MOSSY_STONE_SLAB) || state.is(AABlocks.MOSSY_STONE_WALL) || state.is(AABlocks.MOSSY_BASALT) || state.is(AABlocks.MOSSY_MUD_BRICKS) || state.is(AABlocks.MOSSY_MUD_BRICK_STAIRS) || state.is(AABlocks.MOSSY_MUD_BRICK_SLAB) || state.is(AABlocks.MOSSY_MUD_BRICK_WALL) || state.is(AABlocks.MOSSY_SHUFFLED_BRICKS) || state.is(AABlocks.MOSSY_SHUFFLED_BRICK_STAIRS) || state.is(AABlocks.MOSSY_SHUFFLED_BRICK_SLAB) || state.is(AABlocks.MOSSY_SHUFFLED_BRICK_WALL)) {
                level.playSound(player, pos, SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0f, 1.0f);
                level.playSound(player, pos, SoundEvents.MOSS_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);
                if (!level.isClientSide && !player.isCreative())
                    stack.hurtAndBreak(1, player, stack.getEquipmentSlot());
                ParticleUtils.spawnParticlesOnBlockFaces(level, pos, AAParticleTypes.FALLING_MOSS.get(), UniformInt.of(2, 4));
                level.setBlockAndUpdate(pos,
                        state.is(Blocks.MOSSY_COBBLESTONE) ? Blocks.COBBLESTONE.withPropertiesOf(state) :
                                state.is(Blocks.MOSSY_COBBLESTONE_STAIRS) ? Blocks.COBBLESTONE_STAIRS.withPropertiesOf(state) :
                                        state.is(Blocks.MOSSY_COBBLESTONE_SLAB) ? Blocks.COBBLESTONE_SLAB.withPropertiesOf(state) :
                                                state.is(Blocks.MOSSY_COBBLESTONE_WALL) ? Blocks.COBBLESTONE_WALL.withPropertiesOf(state) :
                                                        state.is(Blocks.MOSSY_STONE_BRICKS) ? Blocks.STONE_BRICKS.withPropertiesOf(state) :
                                                                state.is(Blocks.MOSSY_STONE_BRICK_STAIRS) ? Blocks.STONE_BRICK_STAIRS.withPropertiesOf(state) :
                                                                        state.is(Blocks.MOSSY_STONE_BRICK_SLAB) ? Blocks.STONE_BRICK_SLAB.withPropertiesOf(state) :
                                                                                state.is(Blocks.MOSSY_STONE_BRICK_WALL) ? Blocks.STONE_BRICK_WALL.withPropertiesOf(state) :
                                                                                        state.is(Blocks.INFESTED_MOSSY_STONE_BRICKS) ? Blocks.INFESTED_STONE_BRICKS.withPropertiesOf(state) :
                                                                                                state.is(AABlocks.MOSSY_STONE) ? Blocks.STONE.withPropertiesOf(state) :
                                                                                                        state.is(AABlocks.MOSSY_STONE_STAIRS) ? Blocks.STONE_STAIRS.withPropertiesOf(state) :
                                                                                                                state.is(AABlocks.MOSSY_STONE_SLAB) ? Blocks.STONE_SLAB.withPropertiesOf(state) :
                                                                                                                        state.is(AABlocks.MOSSY_STONE_WALL) ? AABlocks.STONE_WALL.get().withPropertiesOf(state) :
                                                                                                                                state.is(AABlocks.MOSSY_BASALT) ? Blocks.BASALT.withPropertiesOf(state) :
                                                                                                                                        state.is(AABlocks.MOSSY_MUD_BRICKS) ? Blocks.MUD_BRICKS.withPropertiesOf(state) :
                                                                                                                                                state.is(AABlocks.MOSSY_MUD_BRICK_STAIRS) ? Blocks.MUD_BRICK_STAIRS.withPropertiesOf(state) :
                                                                                                                                                        state.is(AABlocks.MOSSY_MUD_BRICK_SLAB) ? Blocks.MUD_BRICK_SLAB.withPropertiesOf(state) :
                                                                                                                                                                state.is(AABlocks.MOSSY_MUD_BRICK_WALL) ? Blocks.MUD_BRICK_WALL.withPropertiesOf(state) :
                                                                                                                                                                        state.is(AABlocks.MOSSY_SHUFFLED_BRICKS) ? AABlocks.SHUFFLED_BRICKS.get().withPropertiesOf(state) :
                                                                                                                                                                                state.is(AABlocks.MOSSY_SHUFFLED_BRICK_STAIRS) ? AABlocks.SHUFFLED_BRICK_STAIRS.get().withPropertiesOf(state) :
                                                                                                                                                                                        state.is(AABlocks.MOSSY_SHUFFLED_BRICK_SLAB) ? AABlocks.SHUFFLED_BRICK_SLAB.get().withPropertiesOf(state) :
                                                                                                                                                                                                state.is(AABlocks.MOSSY_SHUFFLED_BRICK_WALL) ? AABlocks.SHUFFLED_BRICK_WALL.get().withPropertiesOf(state) : state);
                if (!level.isClientSide && level.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS))
                    Block.popResourceFromFace(level, pos, event.getFace(), AABlocks.MOSS_CLUMP.toStack());

                event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
                event.setCanceled(true);
            }
            // Removing moss from Deepslate blocks
            if (state.is(AABlocks.MOSSY_DEEPSLATE) || state.is(AABlocks.MOSSY_COBBLED_DEEPSLATE) || state.is(AABlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS) || state.is(AABlocks.MOSSY_COBBLED_DEEPSLATE_SLAB) || state.is(AABlocks.MOSSY_COBBLED_DEEPSLATE_WALL) || state.is(AABlocks.MOSSY_POLISHED_DEEPSLATE) || state.is(AABlocks.MOSSY_POLISHED_DEEPSLATE_STAIRS) || state.is(AABlocks.MOSSY_POLISHED_DEEPSLATE_SLAB) || state.is(AABlocks.MOSSY_POLISHED_DEEPSLATE_WALL) || state.is(AABlocks.MOSSY_DEEPSLATE_BRICKS) || state.is(AABlocks.MOSSY_DEEPSLATE_BRICK_STAIRS) || state.is(AABlocks.MOSSY_DEEPSLATE_BRICK_SLAB) || state.is(AABlocks.MOSSY_DEEPSLATE_BRICK_WALL) || state.is(AABlocks.MOSSY_DEEPSLATE_TILES) || state.is(AABlocks.MOSSY_DEEPSLATE_TILE_STAIRS) || state.is(AABlocks.MOSSY_DEEPSLATE_TILE_SLAB) || state.is(AABlocks.MOSSY_DEEPSLATE_TILE_WALL)) {
                level.playSound(player, pos, SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0f, 1.0f);
                level.playSound(player, pos, SoundEvents.MOSS_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);
                if (!level.isClientSide && !player.isCreative())
                    stack.hurtAndBreak(1, player, stack.getEquipmentSlot());
                ParticleUtils.spawnParticlesOnBlockFaces(level, pos, AAParticleTypes.FALLING_RUST_MOSS.get(), UniformInt.of(2, 4));
                level.setBlockAndUpdate(pos,
                        state.is(AABlocks.MOSSY_DEEPSLATE) ? Blocks.DEEPSLATE.withPropertiesOf(state) :
                                state.is(AABlocks.MOSSY_COBBLED_DEEPSLATE) ? Blocks.COBBLED_DEEPSLATE.withPropertiesOf(state) :
                                        state.is(AABlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS) ? Blocks.COBBLED_DEEPSLATE_STAIRS.withPropertiesOf(state) :
                                                state.is(AABlocks.MOSSY_COBBLED_DEEPSLATE_SLAB) ? Blocks.COBBLED_DEEPSLATE_SLAB.withPropertiesOf(state) :
                                                        state.is(AABlocks.MOSSY_COBBLED_DEEPSLATE_WALL) ? Blocks.COBBLED_DEEPSLATE_WALL.withPropertiesOf(state) :
                                                                state.is(AABlocks.MOSSY_POLISHED_DEEPSLATE) ? Blocks.POLISHED_DEEPSLATE.withPropertiesOf(state) :
                                                                        state.is(AABlocks.MOSSY_POLISHED_DEEPSLATE_STAIRS) ? Blocks.POLISHED_DEEPSLATE_STAIRS.withPropertiesOf(state) :
                                                                                state.is(AABlocks.MOSSY_POLISHED_DEEPSLATE_SLAB) ? Blocks.POLISHED_DEEPSLATE_SLAB.withPropertiesOf(state) :
                                                                                        state.is(AABlocks.MOSSY_POLISHED_DEEPSLATE_WALL) ? Blocks.POLISHED_DEEPSLATE_WALL.withPropertiesOf(state) :
                                                                                                state.is(AABlocks.MOSSY_DEEPSLATE_BRICKS) ? Blocks.DEEPSLATE_BRICKS.withPropertiesOf(state) :
                                                                                                        state.is(AABlocks.MOSSY_DEEPSLATE_BRICK_STAIRS) ? Blocks.DEEPSLATE_BRICK_STAIRS.withPropertiesOf(state) :
                                                                                                                state.is(AABlocks.MOSSY_DEEPSLATE_BRICK_SLAB) ? Blocks.DEEPSLATE_BRICK_SLAB.withPropertiesOf(state) :
                                                                                                                        state.is(AABlocks.MOSSY_DEEPSLATE_BRICK_WALL) ? Blocks.DEEPSLATE_BRICK_WALL.withPropertiesOf(state) :
                                                                                                                                state.is(AABlocks.MOSSY_DEEPSLATE_TILES) ? Blocks.DEEPSLATE_TILES.withPropertiesOf(state) :
                                                                                                                                        state.is(AABlocks.MOSSY_DEEPSLATE_TILE_STAIRS) ? Blocks.DEEPSLATE_TILE_STAIRS.withPropertiesOf(state) :
                                                                                                                                                state.is(AABlocks.MOSSY_DEEPSLATE_TILE_SLAB) ? Blocks.DEEPSLATE_TILE_SLAB.withPropertiesOf(state) :
                                                                                                                                                        state.is(AABlocks.MOSSY_DEEPSLATE_TILE_WALL) ? Blocks.DEEPSLATE_TILE_WALL.withPropertiesOf(state) : state);
                if (!level.isClientSide && level.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS))
                    Block.popResourceFromFace(level, pos, event.getFace(), AABlocks.RUST_MOSS_CLUMP.toStack());

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
                ParticleUtils.spawnParticlesOnBlockFaces(level, pos, new BlockParticleOption(ParticleTypes.BLOCK, Blocks.MUD.defaultBlockState()), UniformInt.of(3, 3));
                level.setBlockAndUpdate(pos, Blocks.MANGROVE_ROOTS.withPropertiesOf(state));
                if (!level.isClientSide && level.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) Block.popResourceFromFace(level, pos, event.getFace(), Items.MUD.getDefaultInstance());

                event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
                event.setCanceled(true);
            }
        }
    }

}
