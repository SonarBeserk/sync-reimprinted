package com.serkprojects.syncreimprinted;

import com.serkprojects.syncreimprinted.proxy.ClientProxy;
import com.serkprojects.syncreimprinted.proxy.IProxy;
import com.serkprojects.syncreimprinted.proxy.ServerProxy;
import com.serkprojects.syncreimprinted.setup.Registration;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SyncReimprinted.MODID)
public class SyncReimprinted {
    public static final String MODID = "syncreimprinted";
    private static final Logger LOGGER = LogManager.getLogger();
    public static IProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    public SyncReimprinted() {
        Registration.init();
    }
}
