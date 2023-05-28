package com.patrickchang.atomrebuild.common.world.item.crafting;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.patrickchang.atomrebuild.AtomRebuild;
import com.patrickchang.atomrebuild.common.world.level.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BreakingRecipe extends AbstractCookingRecipe {
    private static final int cookingTime = 100;
    public BreakingRecipe(RecipeType<?> recipeType, ResourceLocation id, String group, Ingredient ingredient
            , ItemStack result, float experience) {
        super(recipeType, id, group, ingredient, result, experience, this.cookingTime);
    }


    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.ATOM_BREAKER_BLOCK);
    }

    @Override

    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializer.BREAKING_RECIPE;
    }

    public static class Serializer implements RecipeSerializer<BreakingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(AtomRebuild.MOD_ID, "substance_breaking");
        @Override
        public BreakingRecipe fromJson(@NotNull ResourceLocation id, @NotNull JsonObject json) {
            String s = GsonHelper.getAsString(json, "group", "");
            JsonElement jsonelement = GsonHelper.isArrayNode(json, "ingredient")
                    ? GsonHelper.getAsJsonArray(json, "ingredient") : GsonHelper.getAsJsonObject(json, "ingredient");
            Ingredient ingredient = Ingredient.fromJson(jsonelement);
            //Forge: Check if primitive string to keep vanilla or a object which can contain a count field.
            if (!json.has("result"))
                throw new com.google.gson.JsonSyntaxException("Missing result, expected to find a string or object");
            ItemStack itemstack;
            if (json.get("result").isJsonObject()) itemstack = ShapedRecipe
                    .itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
            else {
                String s1 = GsonHelper.getAsString(json, "result");
                ResourceLocation resourcelocation = new ResourceLocation(s1);
                itemstack = new ItemStack(Registry.ITEM.getOptional(resourcelocation)
                        .orElseThrow(() -> new IllegalStateException("Item: " + s1 + " does not exist")));
            }
            float exp = GsonHelper.getAsFloat(json, "experience", 0.0F);
            return new BreakingRecipe(ModRecipeType.BREAKING, id, s, ingredient, itemstack, exp);
        }

        @Nullable
        @Override
        public BreakingRecipe fromNetwork(@NotNull ResourceLocation id, @NotNull FriendlyByteBuf buffer) {
            String s = buffer.readUtf();
            Ingredient ingredient = Ingredient.fromNetwork(buffer);
            ItemStack itemstack = buffer.readItem();
            float exp = buffer.readFloat();
            return new BreakingRecipe(ModRecipeType.BREAKING, id, s, ingredient, itemstack, exp);
        }

        @Override
        public void toNetwork(@NotNull FriendlyByteBuf buffer, @NotNull BreakingRecipe recipe) {
            buffer.writeUtf(recipe.group);
            recipe.ingredient.toNetwork(buffer);
            buffer.writeItem(recipe.result);
            buffer.writeFloat(recipe.experience);
        }

        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return INSTANCE;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return ID;
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType() {
            return Serializer.castClass(RecipeSerializer.class);
        }

        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>)cls;
        }
    }
}
