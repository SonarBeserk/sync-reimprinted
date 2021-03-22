package com.serkprojects.syncreimprinted.proxy;

import net.minecraft.world.World;

public class ServerProxy implements IProxy {
    @Override
    public World getClientWorld() {
        throw new IllegalStateException("Only available on the client side");
    }
}
