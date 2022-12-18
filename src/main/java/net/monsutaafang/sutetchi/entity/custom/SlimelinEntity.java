package net.monsutaafang.sutetchi.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.scoreboard.AbstractTeam;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.monsutaafang.sutetchi.entity.Variant.SlimelinVariant;
import net.monsutaafang.sutetchi.item.ModItems;
import net.monsutaafang.sutetchi.sound.ModSounds;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class SlimelinEntity extends TameableEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public SlimelinEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    private boolean songPlaying;
    @Nullable
    private BlockPos songSource;

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }


    public static DefaultAttributeContainer.Builder setAttributes() {
        return TameableEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D)
                .add(EntityAttributes.GENERIC_ARMOR, 0.0f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new SitGoal(this));
        this.goalSelector.add(2, new PounceAtTargetGoal(this, 0.4F));
        this.goalSelector.add(3, new MeleeAttackGoal(this, 0.75f, true));
        this.goalSelector.add(4, new FollowOwnerGoal(this, 0.75f, 2.0F, 4.0F, false));
        this.goalSelector.add(5, new WanderAroundPointOfInterestGoal(this, 0.75f, false));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 0.75f, 1));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.targetSelector.add(1, new TrackOwnerAttackerGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
        this.targetSelector.add(3, (new RevengeGoal(this, new Class[0])).setGroupRevenge(new Class[0]));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("walknew", true));
            return PlayState.CONTINUE;
        }

        if (this.isSongPlaying() && this.songSource.isWithinDistance(this.getPos(), 6.46) && this.world.getBlockState(this.songSource).isOf(Blocks.JUKEBOX)) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("dance", true));
            return PlayState.CONTINUE;
        }

        if (this.isSitting()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("sit", true));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                2, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    public void setNearbySongPlaying(BlockPos songPosition, boolean playing) {
        this.songSource = songPosition;
        this.songPlaying = playing;
    }

    public boolean isSongPlaying() {
        return this.songPlaying;
    }

    private static final TrackedData<Boolean> SITTING =
            DataTracker.registerData(SlimelinEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final TrackedData<Boolean> UPGRADE =
            DataTracker.registerData(SlimelinEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getStackInHand(hand);
        Item item = itemstack.getItem();

        Item itemForTaming = ModItems.TAME_CRYSTAL;
        Item itemForHeal = ModItems.SLIMECHOCOLATE;
        Item itemForUpgrade = ModItems.SLIMEHEART;
        Item itemForRawslime = ModItems.RAW_SLIME;
        Item itemForSea = ModItems.SEA_SLIME;
        Item itemForNether = ModItems.NETHER_SLIME;
        Item itemForEnd = ModItems.END_SLIME;
        Item itemForWitch = ModItems.WITCHES_BREW;
        Item itemForSeaWitch = ModItems.SEA_WITCHES_BREW;
        Item itemForNetherWitch = ModItems.NETHER_WITCHES_BREW;
        Item itemForEndWitch = ModItems.END_WITCHES_BREW;
        Item itemForSnow = ModItems.SNOW_BREW;
        Item itemForSeaSnow = ModItems.SEA_SNOW_BREW;
        Item itemForNetherSnow = ModItems.NETHER_SNOW_BREW;
        Item itemForEndSnow = ModItems.END_SNOW_BREW;
        Item itemForAncient = ModItems.ANCIENT_BREW;
        Item itemForSeaAncient = ModItems.SEA_ANCIENT_BREW;
        Item itemForNetherAncient = ModItems.NETHER_ANCIENT_BREW;
        Item itemForEndAncient = ModItems.END_ANCIENT_BREW;

        if (item == itemForTaming && !isTamed()) {
            if (this.world.isClient()) {
                return ActionResult.CONSUME;
            } else {
                if (!player.getAbilities().creativeMode) {
                    itemstack.decrement(1);
                }

                if (!this.world.isClient()) {
                    this.playSound(ModSounds.TAMESOUND, 0.80f, 1f);
                    super.setOwner(player);
                    this.navigation.recalculatePath();
                    this.setTarget(null);
                    this.world.sendEntityStatus(this, (byte) 7);
                    setSit(true);
                }

                return ActionResult.SUCCESS;
            }
        }

        if (isTamed() && !this.world.isClient() && item == itemForUpgrade && isOwner(player) && !isUpgraded()) {
            getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(40.0D);
            this.playSound(ModSounds.UPGRADE, 1f, 1f);
            this.heal(40);
            itemstack.decrement(1);
            setUpgrade(true);
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.world.isClient() && item == itemForSea && isOwner(player)) {
            this.setVariant(SlimelinVariant.SEA);
            this.playSound(ModSounds.SLIMECHANGE, 1f, 1f);
            itemstack.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.world.isClient() && item == itemForNether && isOwner(player)) {
            this.setVariant(SlimelinVariant.NETHER);
            this.playSound(ModSounds.SLIMECHANGE, 1f, 1f);
            itemstack.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.world.isClient() && item == itemForEnd && isOwner(player)) {
            this.setVariant(SlimelinVariant.END);
            this.playSound(ModSounds.SLIMECHANGE, 1f, 1f);
            itemstack.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.world.isClient() && item == itemForSeaWitch && isOwner(player)) {
            this.setVariant(SlimelinVariant.SEAWITCH);
            this.playSound(ModSounds.WITCHCHANGE, 1f, 1f);
            itemstack.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.world.isClient() && item == itemForNetherWitch && isOwner(player)) {
            this.setVariant(SlimelinVariant.NETHERWITCH);
            this.playSound(ModSounds.WITCHCHANGE, 1f, 1f);
            itemstack.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.world.isClient() && item == itemForEndWitch && isOwner(player)) {
            this.setVariant(SlimelinVariant.ENDWITCH);
            this.playSound(ModSounds.WITCHCHANGE, 1f, 1f);
            itemstack.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.world.isClient() && item == itemForWitch && isOwner(player)) {
            this.setVariant(SlimelinVariant.WITCH);
            this.playSound(ModSounds.WITCHCHANGE, 1f, 1f);
            itemstack.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.world.isClient() && item == itemForSeaSnow && isOwner(player)) {
            this.setVariant(SlimelinVariant.SEASNOW);
            this.playSound(ModSounds.SNOWCHANGE, 0.80f, 1f);
            itemstack.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.world.isClient() && item == itemForNetherSnow && isOwner(player)) {
            this.setVariant(SlimelinVariant.NETHERSNOW);
            this.playSound(ModSounds.SNOWCHANGE, 0.80f, 1f);
            itemstack.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.world.isClient() && item == itemForEndSnow && isOwner(player)) {
            this.setVariant(SlimelinVariant.ENDSNOW);
            this.playSound(ModSounds.SNOWCHANGE, 0.80f, 1f);
            itemstack.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.world.isClient() && item == itemForSnow && isOwner(player)) {
            this.setVariant(SlimelinVariant.SNOW);
            this.playSound(ModSounds.SNOWCHANGE, 0.80f, 1f);
            itemstack.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.world.isClient() && item == itemForSeaAncient && isOwner(player)) {
            this.setVariant(SlimelinVariant.SEAANCIENT);
            this.playSound(ModSounds.ANCIENTCHANGE, 0.80f, 1f);
            itemstack.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.world.isClient() && item == itemForNetherAncient && isOwner(player)) {
            this.setVariant(SlimelinVariant.NETHERANCIENT);
            this.playSound(ModSounds.ANCIENTCHANGE, 0.80f, 1f);
            itemstack.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.world.isClient() && item == itemForEndAncient && isOwner(player)) {
            this.setVariant(SlimelinVariant.ENDANCIENT);
            this.playSound(ModSounds.ANCIENTCHANGE, 0.80f, 1f);
            itemstack.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.world.isClient() && item == itemForAncient && isOwner(player)) {
            this.setVariant(SlimelinVariant.ANCIENT);
            this.playSound(ModSounds.ANCIENTCHANGE, 0.80f, 1f);
            itemstack.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.world.isClient() && item == itemForRawslime && isOwner(player)) {
            this.setVariant(SlimelinVariant.DEFAULT);
            this.playSound(ModSounds.SLIMECHANGE, 1f, 1f);
            itemstack.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.world.isClient() && item == itemForHeal && isOwner(player) && this.getHealth() < this.getMaxHealth()) {
            this.heal(40);
            this.playSound(ModSounds.CRUNCH, 2.50f, 1f);
            itemstack.decrement(1);
            return ActionResult.SUCCESS;
        }

        if (isTamed() && !this.world.isClient() && hand == Hand.MAIN_HAND && isOwner(player)) {
            setSit(!isSitting());
            return ActionResult.SUCCESS;
        }

        if (itemstack.getItem() == itemForTaming) {
            return ActionResult.PASS;
        }

        return super.interactMob(player, hand);
    }

    public void setUpgrade(boolean upgraded) {
        this.dataTracker.set(UPGRADE, upgraded);
    }
    public boolean isUpgraded() {
        return this.dataTracker.get(UPGRADE);
    }

    public void setSit(boolean sitting) {
        this.dataTracker.set(SITTING, sitting);
        super.setSitting(sitting);
    }

    public boolean isSitting() {
        return this.dataTracker.get(SITTING);
    }

    @Override
    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
        if (tamed) {
            getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(6D);
            getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue((double) 0.47f);
        } else {
            getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(2D);
            getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue((double) 0.47f);
        }
    }

    public boolean canAttackWithOwner(LivingEntity target, LivingEntity owner) {
        if (!(target instanceof CreeperEntity) && !(target instanceof GhastEntity)) {
            if (target instanceof SlimelinEntity) {
                SlimelinEntity slimelinEntity = (SlimelinEntity)target;
                return !slimelinEntity.isTamed() || slimelinEntity.getOwner() != owner;
            } else if (target instanceof PlayerEntity && owner instanceof PlayerEntity && !((PlayerEntity)owner).shouldDamagePlayer((PlayerEntity)target)) {
                return false;
            } else if (target instanceof AbstractHorseEntity && ((AbstractHorseEntity)target).isTame()) {
                return false;
            } else {
                return !(target instanceof TameableEntity) || !((TameableEntity)target).isTamed();
            }
        } else {
            return false;
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("isSitting", this.dataTracker.get(SITTING));
        nbt.putInt("variant", this.dataTracker.get(DATA_ID_TYPE_VARIANT));
        nbt.putBoolean("isUpgraded", this.dataTracker.get(UPGRADE));
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(SITTING, nbt.getBoolean("isSitting"));
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, nbt.getInt("variant"));
        this.dataTracker.set(UPGRADE, nbt.getBoolean("isUpgraded"));
    }

    @Override
    public AbstractTeam getScoreboardTeam() {
        return super.getScoreboardTeam();
    }

    public boolean canBeLeashedBy(PlayerEntity player) {
        return false;
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(SITTING, false);
        this.dataTracker.startTracking(DATA_ID_TYPE_VARIANT, 0);
        this.dataTracker.startTracking(UPGRADE, false);
    }

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(SlimelinEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public SlimelinVariant getVariant() {
        return SlimelinVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(SlimelinVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }
    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(ModSounds.SLIMESTEP, 0.75f, 1.0f);
    }
}