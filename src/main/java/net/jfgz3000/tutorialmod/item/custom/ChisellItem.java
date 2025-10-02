package net.jfgz3000.tutorialmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.HashMap;
import java.util.Map;

public class ChisellItem extends Item {

    private static final Map<Block, Block> CHISEL_MAP = new HashMap<>();

    static {
        CHISEL_MAP.put(Blocks.STONE, Blocks.STONE_BRICKS);
        CHISEL_MAP.put(Blocks.END_STONE, Blocks.END_STONE_BRICKS);
        CHISEL_MAP.put(Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
        CHISEL_MAP.put(Blocks.COPPER_BLOCK, Blocks.GOLD_BLOCK);
        CHISEL_MAP.put(Blocks.RAW_IRON_BLOCK, Blocks.IRON_BLOCK);
        CHISEL_MAP.put(Blocks.RAW_GOLD_BLOCK, Blocks.GOLD_BLOCK);
        CHISEL_MAP.put(Blocks.AMETHYST_BLOCK, Blocks.AMETHYST_CLUSTER);
        CHISEL_MAP.put(Blocks.SHROOMLIGHT, Blocks.OCHRE_FROGLIGHT);
        // Aquí tu bloque custom
        // ⚠️ asegúrate que ModBlocks.BISMUTH_BLOCK esté bien registrado
        // CHISEL_MAP.put(Blocks.NETHERRACK, ModBlocks.BISMUTH_BLOCK.get());
    }

    public ChisellItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Block clickedBlock = level.getBlockState(pos).getBlock();

        if (CHISEL_MAP.containsKey(clickedBlock)) {
            if (!level.isClientSide()) {
                // Cambia el bloque
                level.setBlockAndUpdate(pos, CHISEL_MAP.get(clickedBlock).defaultBlockState());

                // Daño al ítem
                if (level instanceof ServerLevel serverLevel) {
                    context.getItemInHand().hurtAndBreak(1, serverLevel, context.getPlayer(),
                            item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
                }

                // Sonido
                level.playSound(null, pos, SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS, 1.0f, 1.0f);
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}
