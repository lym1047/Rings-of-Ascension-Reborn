package com.ming.ringsofascension_reborn.item.rings;

import com.ming.ringsofascension_reborn.client.GlintRenderTypes;
import com.ming.ringsofascension_reborn.item.ItemRingBase;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.KelpBlock;
import net.minecraft.world.level.block.KelpPlantBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SeaPickleBlock;
import net.minecraft.world.level.block.SeagrassBlock;
import net.minecraft.world.level.block.TallSeagrassBlock;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.FluidState;

import java.util.function.Supplier;

public class ItemRingSponge extends ItemRingBase {

    private final FlowingFluid staticFluidType;
    private final FlowingFluid flowingFluidType;

    public ItemRingSponge(Properties properties, String tooltip, Supplier<Boolean> enabled,
                          FlowingFluid staticFluidType, FlowingFluid flowingFluidType, GlintRenderTypes glintType) {
        super(properties, tooltip, enabled, glintType);
        this.staticFluidType = staticFluidType;
        this.flowingFluidType = flowingFluidType;
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if (!isEnabled.get()) return;
        if (livingEntity.level().isClientSide || livingEntity.isCrouching()) return;

        Level world = livingEntity.level();
        BlockPos entityPos = new BlockPos(livingEntity.getBlockX(), livingEntity.getBlockY(), livingEntity.getBlockZ());
        int range = 3;

        for (BlockPos pos : BlockPos.betweenClosed(entityPos.getX() - range, entityPos.getY() - range, entityPos.getZ() - range, entityPos.getX() + range, entityPos.getY() + range, entityPos.getZ() + range)) {
            BlockState state = world.getBlockState(pos);
            FluidState fluid = world.getFluidState(pos);

            if (fluid.is(staticFluidType) || fluid.is(flowingFluidType)) {
                Block block = state.getBlock();

                if (block instanceof LiquidBlock) {
                    world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                } else if (isWaterPlant(block)) {
                    BlockEntity tileentity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
                    Block.dropResources(state, world, pos, tileentity);
                    world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                }
            }
        }
    }

    private static boolean isWaterPlant(Block block) {
        return block instanceof KelpBlock || block instanceof KelpPlantBlock
                || block instanceof SeagrassBlock || block instanceof TallSeagrassBlock
                || block instanceof WaterlilyBlock || block instanceof SeaPickleBlock;
    }

}
