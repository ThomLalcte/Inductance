package com.thomus.datagen;

import com.thomus.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.thomus.inductance.Inductance.LOGGER;
import static com.thomus.inductance.Inductance.MODID;

public class Items extends ItemModelProvider {


    public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        singleTexture(
                Registration.DonkeyFartTool.get().getRegistryName().getPath(),
                new ResourceLocation("item/handheld"),
                "layer0",
                new ResourceLocation(MODID,"item/a"));
    }
}
