package superbas11.test;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import superbas11.test.gui.TestArrayEntry;

import java.io.File;

import static net.minecraftforge.common.config.Property.Type.STRING;

@Mod(modid = "testcase", name = "ForgeTestCase", version = "1", clientSideOnly = true, guiFactory = "superbas11.test.gui.ModGuiFactoryHandler")
public class Test {
    @Instance(value = "testcase")
    public static Test instance;
    public static Configuration config;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        File file = event.getSuggestedConfigurationFile();
        config = new Configuration(file);
        syncConfig();
    }

    public void syncConfig() {
        String ctgyGen = Configuration.CATEGORY_GENERAL;
        config.load();

        config.get(ctgyGen, "test", new String[]{}, "test list", STRING).setArrayEntryClass(TestArrayEntry.class);

        config.save();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(instance);
    }

    @SubscribeEvent
    public void onConfigChanged(OnConfigChangedEvent event) {
        if (event.getModID().equals("testcase")) {
            config.save();
            syncConfig();
        }
    }
}
