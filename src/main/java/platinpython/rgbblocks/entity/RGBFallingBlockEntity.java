package platinpython.rgbblocks.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;
import platinpython.rgbblocks.util.registries.EntityRegistry;

public class RGBFallingBlockEntity extends FallingBlockEntity implements IEntityAdditionalSpawnData {
    private int color;

    public RGBFallingBlockEntity(EntityType<? extends FallingBlockEntity> entityType, Level world) {
        super(EntityRegistry.RGB_FALLING_BLOCK.get(), world);
    }

    public RGBFallingBlockEntity(Level world, double x, double y, double z, BlockState state, int color) {
        this(EntityRegistry.RGB_FALLING_BLOCK.get(), world);
        this.blockState = state;
        this.blocksBuilding = true;
        this.setPos(x, y + (double) ((1.0F - this.getBbHeight()) / 2.0F), z);
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    @Override
    public ItemEntity spawnAtLocation(ItemStack stack, float offset) {
        stack.getOrCreateTag().putInt("color", color);
        return super.spawnAtLocation(stack, offset);
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("color", color);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        color = compound.getInt("color");
    }

    @Override
    public void writeSpawnData(FriendlyByteBuf buffer) {
        buffer.writeInt(color);
        buffer.writeJsonWithCodec(BlockState.CODEC, blockState);
    }

    @Override
    public void readSpawnData(FriendlyByteBuf additionalData) {
        color = additionalData.readInt();
        blockState = additionalData.readJsonWithCodec(BlockState.CODEC);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
