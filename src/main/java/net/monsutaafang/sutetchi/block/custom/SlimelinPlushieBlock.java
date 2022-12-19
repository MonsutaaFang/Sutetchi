package net.monsutaafang.sutetchi.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import javax.annotation.Nullable;

public class SlimelinPlushieBlock extends HorizontalFacingBlock {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public SlimelinPlushieBlock(Settings settings) {
        super(settings);
    }

    private static VoxelShape SHAPEN = Block.createCuboidShape(3.69, 0.05, 3.25, 12.3, 10.85, 11.5);

    private static VoxelShape SHAPEE = Block.createCuboidShape(4.58, 0.05, 3.58, 12.83, 10.85, 12.18);

    private static VoxelShape SHAPES = Block.createCuboidShape(3.70, 0.05, 4.47, 12.30, 10.85, 12.72);

    private static VoxelShape SHAPEW = Block.createCuboidShape(3.36, 0.05, 3.68, 11.61, 10.85, 12.28);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPEN;
            case SOUTH:
                return SHAPES;
            case WEST:
                return SHAPEW;
            case EAST:
                return SHAPEE;
            default:
                return SHAPEN;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}