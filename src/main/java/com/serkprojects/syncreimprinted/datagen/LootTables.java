package com.serkprojects.syncreimprinted.datagen;

import com.serkprojects.syncreimprinted.setup.Registration;
import net.minecraft.data.DataGenerator;

public class LootTables extends BaseLootTableProvider {
    public LootTables(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void addTables() {
        lootTables.put(Registration.SHELLSTORAGE.get(), createStandardTable("shellstorage", Registration.SHELLSTORAGE.get()));
    }
}
