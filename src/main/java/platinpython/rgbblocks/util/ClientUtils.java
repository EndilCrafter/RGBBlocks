package platinpython.rgbblocks.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.RegistryObject;
import platinpython.rgbblocks.RGBBlocks;
import platinpython.rgbblocks.client.colorhandlers.PaintBucketItemColor;
import platinpython.rgbblocks.client.colorhandlers.RGBBlockColor;
import platinpython.rgbblocks.client.colorhandlers.RGBBlockItemColor;
import platinpython.rgbblocks.client.gui.screen.ColorSelectScreen;
import platinpython.rgbblocks.client.model.AntiblockBakedModel;
import platinpython.rgbblocks.client.renderer.entity.RGBFallingBlockRenderer;
import platinpython.rgbblocks.util.pack.RGBBlocksPack;
import platinpython.rgbblocks.util.registries.EntityRegistry;
import platinpython.rgbblocks.util.registries.ItemRegistry;

@EventBusSubscriber(modid = RGBBlocks.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientUtils {
    public static final RGBBlocksPack VIRTUAL_PACK = new RGBBlocksPack();

    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {
        event.addRepositorySource((infoConsumer) -> infoConsumer.accept(
                Pack.create("rgbblocks_textures", Component.translatable("rgbblocks.pack_title"), true,
                            id -> VIRTUAL_PACK,
                            new Pack.Info(Component.translatable("rgbblocks.pack_description"), 0, 0,
                                          FeatureFlagSet.of(), false
                            ), PackType.CLIENT_RESOURCES, Pack.Position.TOP, true, PackSource.BUILT_IN
                )));
    }

    @SubscribeEvent
    public static void registerReloadListener(RegisterClientReloadListenersEvent event) {
        event.registerReloadListener(VIRTUAL_PACK);
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityRegistry.RGB_FALLING_BLOCK.get(), RGBFallingBlockRenderer::new);
    }

    @SubscribeEvent
    public static void registerColorHandlers(RegisterColorHandlersEvent.Item event) {
        event.register(new RGBBlockItemColor(),
                       RegistryHandler.BLOCKS.getEntries().stream().map(RegistryObject::get).toArray(Block[]::new)
        );

        event.register(new PaintBucketItemColor(), ItemRegistry.PAINT_BUCKET.get());
    }

    @SubscribeEvent
    public static void registerColorHandlers(RegisterColorHandlersEvent.Block event) {
        event.register(new RGBBlockColor(),
                       RegistryHandler.BLOCKS.getEntries().stream().map(RegistryObject::get).toArray(Block[]::new)
        );
    }

    @SubscribeEvent
    public static void registerModelStuff(ModelEvent.RegisterGeometryLoaders event) {
        event.register("antiblock_model", new AntiblockBakedModel.ModelLoader());
    }

    public static void openColorSelectScreen(int color, boolean isRGBSelected) {
        Minecraft.getInstance().setScreen(new ColorSelectScreen(color, isRGBSelected));
    }

    public static boolean hasShiftDown() {
        return Screen.hasShiftDown();
    }
}