package com.serkprojects.syncreimprinted.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ShellStorage extends Block {
    public ShellStorage() {
        super(Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(2.0f));
        setRegistryName("shellstorage");
    }
}
