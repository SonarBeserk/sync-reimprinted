package com.serkprojects.syncreimprinted.datagen;

import com.serkprojects.syncreimprinted.setup.Registration;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import java.util.function.Consumer;

public class Recipes extends RecipeProvider {
    public Recipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        super.registerRecipes(consumer);

        ShapedRecipeBuilder.shapedRecipe(Registration.shellStorage)
                .patternLine("xxx")
                .patternLine("x x")
                .patternLine("xxx")
                .key('x', Blocks.TORCH)
                .setGroup("syncreimprinted")
                .addCriterion("torch", InventoryChangeTrigger.Instance.forItems(Blocks.TORCH))
                .build(consumer);
    }
}
