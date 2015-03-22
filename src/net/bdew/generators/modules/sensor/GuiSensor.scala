/*
 * Copyright (c) bdew, 2015
 * https://github.com/bdew/generators
 *
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://bdew.net/minecraft-mod-public-license/
 */

package net.bdew.generators.modules.sensor

import net.bdew.generators.Generators
import net.bdew.lib.Misc
import net.bdew.lib.gui._
import net.bdew.lib.gui.widgets.WidgetLabel
import net.bdew.lib.sensors.widgets.{WidgetSensorBooleanResult, WidgetSensorParam, WidgetSensorType}
import net.minecraft.entity.player.EntityPlayer

class GuiSensor(val te: TileSensor, player: EntityPlayer) extends BaseScreen(new ContainerSensor(te, player), 176, 175) {
  val background = Texture(Generators.modId, "textures/gui/sensor.png", rect)

  override def initGui() {
    super.initGui()

    widgets.add(new WidgetSensorType(Point(53, 38), te.config.sensor))
    widgets.add(new WidgetSensorParam(Point(71, 38), te.config.param))
    widgets.add(new WidgetSensorBooleanResult(Point(107, 38), te.isSignalOn, "advgenerators.label.sensor"))

    widgets.add(new WidgetLabel(Misc.toLocal("advgenerators.gui.sensor.title"), 8, 6, Color.darkGray))
    widgets.add(new WidgetLabel(Misc.toLocal("container.inventory"), 8, this.ySize - 96 + 3, Color.darkGray))
  }
}

