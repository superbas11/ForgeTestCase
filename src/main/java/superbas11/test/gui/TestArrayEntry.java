package superbas11.test.gui;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.config.GuiButtonExt;
import net.minecraftforge.fml.client.config.GuiEditArray;
import net.minecraftforge.fml.client.config.GuiEditArrayEntries;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class TestArrayEntry extends GuiEditArrayEntries.BaseEntry {

    public TestArrayEntry(GuiEditArray owningScreen, GuiEditArrayEntries owningEntryList, IConfigElement configElement, Object value) {
        super(owningScreen, owningEntryList, configElement);
    }

    @Override
    public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, int mouseX, int mouseY, boolean isSelected) {
        super.drawEntry(slotIndex, x, y, listWidth, slotHeight, mouseX, mouseY, isSelected);

        //Accessing minecraft code:
        Minecraft.getMinecraft();
    }
}
