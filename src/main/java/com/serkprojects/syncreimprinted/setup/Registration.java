package com.serkprojects.syncreimprinted.setup;

import com.serkprojects.syncreimprinted.blocks.ShellStorage;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

public class Registration {
    @ObjectHolder("syncreimprinted:shellstorage")
    public static ShellStorage shellStorage;

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new ShellStorage());
        }

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new BlockItem(Registration.shellStorage,
                    new Item.Properties().group(ItemGroup.TRANSPORTATION))
                    .setRegistryName("shellstorage"));
        }
    }
}
