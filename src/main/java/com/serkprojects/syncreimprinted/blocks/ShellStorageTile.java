package com.serkprojects.syncreimprinted.blocks;

import com.serkprojects.syncreimprinted.setup.Registration;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class ShellStorageTile extends TileEntity implements ITickableTileEntity {
    public ShellStorageTile() {
        super(Registration.SHELLSTORAGE_TILE.get());
    }

    @Override
    public void tick() {

    }
}
