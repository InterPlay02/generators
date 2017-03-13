/*
 * Copyright (c) bdew, 2014 - 2017
 * https://github.com/bdew/generators
 *
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://bdew.net/minecraft-mod-public-license/
 */

package net.bdew.generators.controllers.exchanger

import net.bdew.generators.network.ContainerCanDumpBuffers
import net.bdew.lib.data.base.ContainerDataSlots
import net.bdew.lib.gui.NoInvContainer
import net.bdew.lib.multiblock.interact.ContainerOutputFaces
import net.minecraft.entity.player.EntityPlayer

class ContainerExchanger(val te: TileExchangerController, player: EntityPlayer) extends NoInvContainer with ContainerDataSlots with ContainerOutputFaces with ContainerCanDumpBuffers {
  lazy val dataSource = te

  bindPlayerInventory(player.inventory, 8, 94, 152)

  override def dumpBuffers(): Unit = {
    te.heaterIn.drainInternal(Double.MaxValue, false, true)
    te.coolerIn.drainInternal(Double.MaxValue, false, true)
    te.heaterOut.drainInternal(Double.MaxValue, false, true)
    te.coolerOut.drainInternal(Double.MaxValue, false, true)
  }
}
