package cn.nukkit.inventory;

import cn.nukkit.item.Item;

/**
 * @author MagicDroidX
 * Nukkit Project
 */
public class FurnaceRecipe implements SmeltingRecipe {

    protected final Item output;

    protected Item ingredient;

    public FurnaceRecipe(Item result, Item ingredient) {
        this.output = result.clone();
        this.ingredient = ingredient.clone();
    }

    public void setInput(Item item) {
        this.ingredient = item.clone();
    }

    @Override
    public Item getInput() {
        return this.ingredient.clone();
    }

    @Override
    public Item getResult() {
        return this.output.clone();
    }

    @Override
    public void registerToCraftingManager(CraftingManager manager) {
        manager.registerFurnaceRecipe(340, this);
    }

    @Override
    public RecipeType getType() {
        return this.ingredient.hasMeta() ? RecipeType.FURNACE_DATA : RecipeType.FURNACE;
    }
}
