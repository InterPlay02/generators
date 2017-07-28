/*
 * Copyright (c) bdew, 2014 - 2016
 * https://github.com/bdew/generators
 *
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://bdew.net/minecraft-mod-public-license/
 */

package net.bdew.generators.modules.teslaOutput

import net.bdew.generators.modules.BaseModule
import net.bdew.lib.multiblock.block.BlockOutput
import net.minecraft.block.state.IBlockState
import net.minecraft.util.EnumFacing
import net.minecraft.util.math.BlockPos
import net.minecraft.world.{IBlockAccess, World}

object BlockTeslaOutput extends BaseModule("tesla_output", "PowerOutput", classOf[TileTeslaOutput]) with BlockOutput[TileTeslaOutput] {
  override def canConnectRedstone(state: IBlockState, world: IBlockAccess, pos: BlockPos, side: EnumFacing): Boolean = true

  override def rotateBlock(world: World, pos: BlockPos, axis: EnumFacing): Boolean = {
    val te = getTE(world, pos)
    if (!world.isRemote && te.getCore.isDefined) {
      te.forcedSides(axis) := !te.forcedSides(axis)
      te.doRescanFaces()
      true
    } else false
  }
}