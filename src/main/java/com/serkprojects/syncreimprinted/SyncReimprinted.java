package com.serkprojects.syncreimprinted;

import com.serkprojects.syncreimprinted.setup.ClientProxy;
import com.serkprojects.syncreimprinted.setup.IProxy;
import com.serkprojects.syncreimprinted.setup.Registration;
import com.serkprojects.syncreimprinted.setup.ServerProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SyncReimprinted.MODID)
public class SyncReimprinted {
    public static final String MODID = "syncreimprinted";

    private static final Logger LOGGER = LogManager.getLogger();

    public SyncReimprinted() {
        MinecraftForge.EVENT_BUS.register(Registration.class);
    }
}
