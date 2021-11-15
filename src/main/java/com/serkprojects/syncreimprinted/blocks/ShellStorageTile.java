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
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ShellStorageTile extends TileEntity implements ITickableTileEntity, IEnergyStorage {
    private boolean top;
    private ShellStorageTile PairedBlock;

    private boolean occupied;
    private boolean updatedVisuals;

    private int currentEnergy;
    private int maxEnergy;

    public ShellStorageTile() {
        super(Registration.SHELLSTORAGE_TILE.get());
        currentEnergy = 0;
        maxEnergy = 10000;
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
        currentEnergy = tag.getInt("currentenergy");
        maxEnergy = tag.getInt("maxenergy");
        super.read(state, tag);
    }

    @Override
    public CompoundNBT write(CompoundNBT tag) {
        tag = super.write(tag);
        tag.putBoolean("occupied", occupied);
        tag.putInt("currentenergy", currentEnergy);
        tag.putInt("maxenergy", maxEnergy);
        return tag;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        return 0;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return 0;
    }

    @Override
    public int getEnergyStored() {
        return !top ? currentEnergy : 0;
    }

    @Override
    public int getMaxEnergyStored() {
        return !top ? maxEnergy : 0;
    }

    @Override
    public boolean canExtract() {
        return false;
    }

    @Override
    public boolean canReceive() {
        return !top;
    }
}
