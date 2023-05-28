package com.patrickchang.atomrebuild.common.world.inventory;

import com.patrickchang.atomrebuild.AtomRebuild;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(AtomRebuild.MOD_ID)
public class ModMenuType {
    public static final MenuType<AtomRebuilderMenu> ATOM_REBUILDER = null;
    public static final MenuType<AtomBreakerMenu> ATOM_BREAKER = null;
}
