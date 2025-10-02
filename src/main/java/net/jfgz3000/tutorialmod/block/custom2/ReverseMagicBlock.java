package net.jfgz3000.tutorialmod.block.custom2;

import net.jfgz3000.tutorialmod.item.Moditems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ReverseMagicBlock extends Block {
    public ReverseMagicBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hitResult) {
        level.playSound(player, pos, SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            // Diamante -> Raw Bismuth
            if (itemEntity.getItem().getItem() == Items.WITHER_ROSE) {
                itemEntity.setItem(new ItemStack(Items.DANDELION, itemEntity.getItem().getCount()));
            }
            if (itemEntity.getItem().getItem() == Items.NETHERITE_INGOT) {
                itemEntity.setItem(new ItemStack(Moditems.BISMUTH.get(), itemEntity.getItem().getCount()));
            }
            // Diamante -> Raw Bismuth
            if (itemEntity.getItem().getItem() == Items.DIAMOND) {
                itemEntity.setItem(new ItemStack(Moditems.RAW_BISMUTH.get(), itemEntity.getItem().getCount()));
            }

            // Dandelion -> Wither Rose
            if (itemEntity.getItem().getItem() == Items.DANDELION) {
                itemEntity.setItem(new ItemStack(Items.WITHER_ROSE, itemEntity.getItem().getCount()));
            }
        }

        super.stepOn(level, pos, state, entity);
    }
}
