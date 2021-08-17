/*
 * Work under Copyright. Licensed under the EUPL.
 * See the project README.md and LICENSE.txt for more information.
 */

package net.dries007.tfc.objects.items.wood;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.item.ItemStack;

import mcp.MethodsReturnNonnullByDefault;
import net.dries007.tfc.api.capability.size.Size;
import net.dries007.tfc.api.capability.size.Weight;
import net.dries007.tfc.api.types.Tree;
import net.dries007.tfc.objects.items.ItemTFC;
import net.dries007.tfc.util.OreDictionaryHelper;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ItemWoodPulpTFC extends ItemTFC
{
    private static final Map<Tree, ItemWoodPulpTFC> MAP = new HashMap<>();

    public static ItemWoodPulpTFC get(Tree wood)
    {
        return MAP.get(wood);
    }

    public static ItemStack get(Tree wood, int amount)
    {
        return new ItemStack(MAP.get(wood), amount);
    }

    public final Tree wood;

    public ItemWoodPulpTFC(Tree wood)
    {
        this.wood = wood;
        if (MAP.put(wood, this) != null) throw new IllegalStateException("There can only be one.");
        setMaxDamage(0);
        OreDictionaryHelper.register(this, "wood_pulp");
        //noinspection ConstantConditions
        OreDictionaryHelper.register(this, "wood_pulp", wood.getRegistryName().getPath());
    }

    @Nonnull
    @Override
    public Size getSize(ItemStack stack)
    {
        return Size.SMALL;
    }

    @Nonnull
    @Override
    public Weight getWeight(ItemStack stack)
    {
        return Weight.VERY_LIGHT;
    }
}