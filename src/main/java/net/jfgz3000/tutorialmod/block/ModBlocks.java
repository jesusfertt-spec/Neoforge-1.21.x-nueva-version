package net.jfgz3000.tutorialmod.block;

import com.mojang.blaze3d.shaders.Uniform;
import net.jfgz3000.tutorialmod.Tutorialmod;
import net.jfgz3000.tutorialmod.block.custom.MagicBlock;
import net.jfgz3000.tutorialmod.block.custom2.ReverseMagicBlock;
import net.jfgz3000.tutorialmod.item.Moditems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Tutorialmod.MOD_ID);
    public static final DeferredBlock<Block> REVERSE_MAGIC_BLOCK = registerBlock("reverse_magic_block" ,
            () -> new ReverseMagicBlock(BlockBehaviour .Properties.of().strength(2f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BISMUTH_BLOCK = registerBlock("bismuth_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> BISMUTH_ORE = registerBlock("bismuth_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.ANCIENT_DEBRIS)));
    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block" ,
            () -> new MagicBlock(BlockBehaviour .Properties.of().strength(2f).requiresCorrectToolForDrops()));



    // Helper para registrar bloque + su BlockItem
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn); // ✅ Aquí se crea el BlockItem
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

