package me.playajames.oraxentransparentblocks.OraxenMechanics;

import io.th0rgal.oraxen.OraxenPlugin;
import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import io.th0rgal.oraxen.mechanics.MechanicsManager;
import me.playajames.oraxentransparentblocks.Listeners.OraxenBlockListeners.OraxenTransparentBlockBreakListener;
import me.playajames.oraxentransparentblocks.Listeners.OraxenBlockListeners.OraxenTransparentBlockPlaceListener;
import me.playajames.oraxentransparentblocks.OraxenTransparentBlocks;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;

public class TransparentBlockMechanicFactory extends MechanicFactory {

    public TransparentBlockMechanicFactory(String mechanicID) {
        super(mechanicID);
        MechanicsManager.registerListeners(OraxenPlugin.get(), mechanicID, new OraxenTransparentBlockPlaceListener(this), new OraxenTransparentBlockBreakListener(this));
    }

    @Override
    public Mechanic parse(ConfigurationSection itemMechanicConfiguration) {
        Mechanic mechanic = new TransparentBlockMechanic(this, itemMechanicConfiguration);
        addToImplemented(mechanic);
        return mechanic;
    }
}