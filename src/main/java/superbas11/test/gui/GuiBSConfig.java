package superbas11.test.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import superbas11.test.Test;

public class GuiBSConfig extends GuiConfig {
    public GuiBSConfig(GuiScreen parent) {
        super(parent, (new ConfigElement(Test.config.getCategory(Configuration.CATEGORY_GENERAL))).getChildElements(),
                "testcase", false, false, GuiConfig.getAbridgedConfigPath(Test.config.toString()));
    }
}
