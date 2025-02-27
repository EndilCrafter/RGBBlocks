package platinpython.rgbblocks.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import platinpython.rgbblocks.RGBBlocks;
import platinpython.rgbblocks.util.registries.BlockRegistry;
import platinpython.rgbblocks.util.registries.EntityRegistry;
import platinpython.rgbblocks.util.registries.ItemRegistry;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output) {
        super(output, RGBBlocks.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("item_group.rgbblocks.tab", "RGB Blocks");

        add("rgbblocks.pack_title", "RGB Blocks Textures");
        add("rgbblocks.pack_description", "Textures generated by and for RGB Blocks");

        add(ItemRegistry.PAINT_BUCKET.get(), "Paint Bucket");

        add(BlockRegistry.RGB_CONCRETE.get(), "RGB Concrete");
        add(BlockRegistry.RGB_CONCRETE_SLAB.get(), "RGB Concrete Slab");
        add(BlockRegistry.RGB_CONCRETE_STAIRS.get(), "RGB Concrete Stairs");
        add(BlockRegistry.RGB_CONCRETE_POWDER.get(), "RGB Concrete Powder");
        add(BlockRegistry.RGB_WOOL.get(), "RGB Wool");
        add(BlockRegistry.RGB_WOOL_SLAB.get(), "RGB Wool Slab");
        add(BlockRegistry.RGB_WOOL_STAIRS.get(), "RGB Wool Stairs");
        add(BlockRegistry.RGB_CARPET.get(), "RGB Carpet");
        add(BlockRegistry.RGB_PLANKS.get(), "RGB Planks");
        add(BlockRegistry.RGB_PLANKS_SLAB.get(), "RGB Plank Slab");
        add(BlockRegistry.RGB_PLANKS_STAIRS.get(), "RGB Plank Stairs");
        add(BlockRegistry.RGB_TERRACOTTA.get(), "RGB Terracotta");
        add(BlockRegistry.RGB_TERRACOTTA_SLAB.get(), "RGB Terracotta Slab");
        add(BlockRegistry.RGB_TERRACOTTA_STAIRS.get(), "RGB Terracotta Stairs");
        add(BlockRegistry.RGB_GLASS.get(), "RGB Glass");
        add(BlockRegistry.RGB_GLASS_SLAB.get(), "RGB Glass Slab");
        add(BlockRegistry.RGB_GLASS_STAIRS.get(), "RGB Glass Stairs");
        add(BlockRegistry.RGB_GLASS_PANE.get(), "RGB Glass Pane");
        add(BlockRegistry.RGB_ANTIBLOCK.get(), "RGB Antiblock");
        add(BlockRegistry.RGB_GLOWSTONE.get(), "RGB Glowstone");
        add(BlockRegistry.RGB_REDSTONE_LAMP.get(), "RGB Redstone Lamp");
        add(BlockRegistry.RGB_PRISMARINE.get(), "RGB Prismarine");
        add(BlockRegistry.RGB_PRISMARINE_SLAB.get(), "RGB Prismarine Slab");
        add(BlockRegistry.RGB_PRISMARINE_STAIRS.get(), "RGB Prismarine Stairs");
        add(BlockRegistry.RGB_PRISMARINE_BRICKS.get(), "RGB Prismarine Bricks");
        add(BlockRegistry.RGB_PRISMARINE_BRICK_SLAB.get(), "RGB Prismarine Brick Slab");
        add(BlockRegistry.RGB_PRISMARINE_BRICK_STAIRS.get(), "RGB Prismarine Brick Stairs");
        add(BlockRegistry.RGB_DARK_PRISMARINE.get(), "Dark RGB Prismarine");
        add(BlockRegistry.RGB_DARK_PRISMARINE_SLAB.get(), "Dark RGB Prismarine Slab");
        add(BlockRegistry.RGB_DARK_PRISMARINE_STAIRS.get(), "Dark RGB Prismarine Stairs");
        add(BlockRegistry.RGB_SEA_LANTERN.get(), "RGB Sea Lantern");

        add(EntityRegistry.RGB_FALLING_BLOCK.get(), "RGB Falling Block");

        addGui("useRGB", "Use RGB");
        addGui("useHSB", "Use HSB");
        addGui("red", "Red");
        addGui("green", "Green");
        addGui("blue", "Blue");
        addGui("hue", "Hue");
        addGui("saturation", "Saturation");
        addGui("brightness", "Brightness");
    }

    private void addGui(String suffix, String text) {
        add("gui." + RGBBlocks.MOD_ID + "." + suffix, text);
    }
}
