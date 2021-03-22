package com.serkprojects.syncreimprinted.setup;

import com.serkprojects.syncreimprinted.SyncReimprinted;
import com.serkprojects.syncreimprinted.blocks.ShellStorage;
import com.serkprojects.syncreimprinted.blocks.ShellStorageTile;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
    public static ItemGroup syncItems = new ItemGroup("syncitems") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Registration.SHELLSTORAGE.get());
        }
    };

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SyncReimprinted.MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SyncReimprinted.MODID);
    private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, SyncReimprinted.MODID);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        TILES.register(bus);
    }

    public static final RegistryObject<ShellStorage> SHELLSTORAGE = BLOCKS.register("shellstorage", ShellStorage::new);
    public static final RegistryObject<Item> SHELLSTORAGE_ITEM = ITEMS.register("shellstorage", () -> new BlockItem(Registration.SHELLSTORAGE.get(), new Item.Properties().group(syncItems).maxStackSize(16)));
    public static final RegistryObject<TileEntityType<ShellStorageTile>> SHELLSTORAGE_TILE = TILES.register("shellstorage", () -> TileEntityType.Builder.create(ShellStorageTile::new, Registration.SHELLSTORAGE.get()).build(null));
}
