package com.serkprojects.syncreimprinted.blocks;

import com.serkprojects.syncreimprinted.setup.Registration;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ShellStorageTile extends TileEntity implements ITickableTileEntity {
    private boolean occupied;
    private boolean updatedVisuals;

    public ShellStorageTile() {
        super(Registration.SHELLSTORAGE_TILE.get());
    }

    @Override
    public void tick() {
        if(!updatedVisuals) {
            world.setBlockState(this.pos, this.world.getBlockState(this.pos).with(BlockStateProperties.OPEN, !occupied), 3);
            updatedVisuals = true;
        }
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
        updatedVisuals = false;
    }

    public IItemHandler createHandler() {
        return new ItemStackHandler(1);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return super.getCapability(cap, side);
    }

    @Override
    public void read(BlockState state, CompoundNBT tag) {
        occupied = tag.getBoolean("occupied");
        super.read(state, tag);
    }

    @Override
    public CompoundNBT write(CompoundNBT tag) {
        tag = super.write(tag);
        tag.putBoolean("occupied", occupied);
        return tag;
    }
}
