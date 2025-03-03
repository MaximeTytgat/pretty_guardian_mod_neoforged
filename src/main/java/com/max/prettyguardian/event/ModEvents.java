package com.max.prettyguardian.event;

import com.max.prettyguardian.PrettyGuardian;
import com.max.prettyguardian.block.ModBlock;
import com.max.prettyguardian.component.ModAttachmentTypes;
import com.max.prettyguardian.config.Config;
import com.max.prettyguardian.config.EntityOnShoulderOnPlayerDeath;
import com.max.prettyguardian.entity.ModEntities;
import com.max.prettyguardian.entity.custom.CelestialRabbitEntity;
import com.max.prettyguardian.entityonshoulder.PlayerEntityOnShoulder;
import com.max.prettyguardian.item.ModItem;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.LogicalSide;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@EventBusSubscriber(modid = PrettyGuardian.MOD_ID)
public class ModEvents {
    private ModEvents() {}

// TODO: Suppress this
//    @SubscribeEvent
//    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
//        if(
//                event.getObject() instanceof Player
//                && !event
//                        .getObject()
//                        .getCapability(PlayerEntityOnShoulderProvider.PLAYER_ENTITY_ON_SHOULDER_CAPABILITY)
//                        .isPresent()
//        ) {
//                event.addCapability(ResourceLocation.fromNamespaceAndPath(PrettyGuardian.MOD_ID, "properties"), new PlayerEntityOnShoulderProvider());
//            }
//
//    }

// TODO: Needed ?
//    @SubscribeEvent
//    public static void onPlayerCloned(PlayerEvent.Clone event) {
//        if(event.isWasDeath()) {
//            event.getOriginal()
//                    .getCapability(PlayerEntityOnShoulderProvider.PLAYER_ENTITY_ON_SHOULDER_CAPABILITY)
//                    .ifPresent(oldStore ->
//                            event.getOriginal()
//                                    .getCapability(PlayerEntityOnShoulderProvider.PLAYER_ENTITY_ON_SHOULDER_CAPABILITY)
//                                    .ifPresent(newStore -> newStore.copyFrom(oldStore)
//                                    ));
//        }
//    }

    @SubscribeEvent
    public static void onInteractWithBlock(PlayerInteractEvent.RightClickBlock event) {
        if (!event.getSide().isClient()) {
            Player player = event.getEntity();

            if (isNotValidPlayer(player)) {
                return;
            }

            if (hasAllConditionsForProcess(event, player) && player.hasData(ModAttachmentTypes.PLAYER_ENTITY_ON_SHOULDER)) {
                PlayerEntityOnShoulder entityOnShoulder = player.getData(ModAttachmentTypes.PLAYER_ENTITY_ON_SHOULDER);

                if (entityOnShoulder.entityTypeDescriptionId() != null && !entityOnShoulder.entityTypeDescriptionId().isEmpty()) {
                    Optional<EntityType<?>> maybeEntityType = EntityType.byString(entityOnShoulder.entityTypeDescriptionId());

                    if (maybeEntityType.isPresent() && maybeEntityType.get() == ModEntities.CELESTIAL_RABBIT.get()) {
                        bringTheAnimalDownFromTheShoulder(event, entityOnShoulder, player);
                    }
                }
            }

        }
    }

    private static boolean isNotValidPlayer(Player player) {
        return player == null || player.isSpectator() || player.getVehicle() != null;
    }

    private static boolean hasAllConditionsForProcess(PlayerInteractEvent.RightClickBlock event, Player player) {
        return player.isShiftKeyDown()
                && player.getItemInHand(event.getHand()).getItem() == Items.AIR
                && event.getSide() == LogicalSide.SERVER;
    }

    private static void bringTheAnimalDownFromTheShoulder(PlayerInteractEvent.RightClickBlock event, PlayerEntityOnShoulder entityOnShoulder, Player player) {
        Vec3 newRabbitPos = getPosByClickedFace(event);
        CelestialRabbitEntity newRabbit = getCelestialRabbitEntity(player, entityOnShoulder, newRabbitPos, entityOnShoulder.isInSittingPose());

        player.level().addFreshEntity(newRabbit);
        player.removeData(ModAttachmentTypes.PLAYER_ENTITY_ON_SHOULDER);

        playerDropEntityOnShoulder(player.getStringUUID());
    }

    private static void playerDropEntityOnShoulder(String playerUUID) {
        PacketDistributor.sendToAllPlayers(
                new PlayerEntityOnShoulder(
                        playerUUID,
                        "",
                        0,
                        "",
                        false
                )
        );
    }

    private static Vec3 getPosByClickedFace(PlayerInteractEvent.RightClickBlock event) {
        Direction direction = event.getFace();
        Vec3 newPos = null;
        double defaultX = event.getPos().getX() + 0.5;
        double defaultY = event.getPos().getY();
        double defaultZ = event.getPos().getZ() + 0.5;

        switch (direction) {
            case UP:
                newPos = new Vec3(defaultX, (event.getPos().getY() + 1), (defaultZ));
                break;
            case DOWN:
                newPos = new Vec3(defaultX, (event.getPos().getY() - 1), (defaultZ));
                break;
            case NORTH:
                newPos = new Vec3(defaultX, defaultY, (event.getPos().getZ() - 0.5));
                break;
            case SOUTH:
                newPos = new Vec3(defaultX, defaultY, (event.getPos().getZ() + 1.5));
                break;
            case WEST:
                newPos = new Vec3((event.getPos().getX() - 0.5), defaultY, (defaultZ));
                break;
            case EAST:
                newPos = new Vec3((event.getPos().getX() + 1.5), defaultY, (defaultZ));
                break;
            case null:
                break;
        }

        return newPos;
    }

    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();

        if (isNotValidPlayer(player)) {
            return;
        }

        // TODO: add is baby to enbtity on shoulder to reCreate the rabbit in baby form
        if (
            event.getTarget() instanceof LivingEntity livingEntity
            && !player.level().isClientSide
            && livingEntity instanceof CelestialRabbitEntity celestialRabbit
            && player.isShiftKeyDown()
            && celestialRabbit.isTame()
            && !celestialRabbit.isBaby()
            &&  (Objects.equals(Objects.requireNonNull(celestialRabbit.getOwnerUUID()).toString(), player.getUUID().toString()))
            && event.getSide() == LogicalSide.SERVER
        ) {
            PlayerEntityOnShoulder entityOnShoulder = player.getData(ModAttachmentTypes.PLAYER_ENTITY_ON_SHOULDER);

            if (entityOnShoulder.entityTypeDescriptionId() == null || entityOnShoulder.entityTypeDescriptionId().isEmpty()) {
                DyeColor collarColor = celestialRabbit.getCollarColor();
                Component name = celestialRabbit.hasCustomName() ? celestialRabbit.getCustomName() : null;
                boolean isInSittingPose = celestialRabbit.isInSittingPose();

                entityOnShoulder = new PlayerEntityOnShoulder(
                        player.getStringUUID(),
                        (PrettyGuardian.MOD_ID+":"+ ModEntities.CELESTIAL_RABBIT.get().toShortString()),
                        collarColor.getId(),
                        name != null ? name.getString() : "",
                        isInSittingPose
                );

                player.setData(ModAttachmentTypes.PLAYER_ENTITY_ON_SHOULDER, entityOnShoulder);
                livingEntity.discard();

                PacketDistributor.sendToAllPlayers(entityOnShoulder);
            }
        }
    }

 // TODO: Test ?
    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        if(
                !event.getLevel().isClientSide()
                && event.getEntity() instanceof ServerPlayer player
                && player.hasData(ModAttachmentTypes.PLAYER_ENTITY_ON_SHOULDER)
        ) {
            PlayerEntityOnShoulder entityOnShoulder = player.getData(ModAttachmentTypes.PLAYER_ENTITY_ON_SHOULDER);
            PacketDistributor.sendToAllPlayers(entityOnShoulder);
        }
    }

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if(event.getEntity() instanceof Player player && player.hasData(ModAttachmentTypes.PLAYER_ENTITY_ON_SHOULDER)) {
            PlayerEntityOnShoulder entityOnShoulder = player.getData(ModAttachmentTypes.PLAYER_ENTITY_ON_SHOULDER);
            EntityOnShoulderOnPlayerDeath entityOnShoulderOnPlayerDeath = Config.entityOnShoulderOnPlayerDeath;

            if (entityOnShoulder.entityTypeDescriptionId() == null || entityOnShoulder.entityTypeDescriptionId().isEmpty()) return;

            if (entityOnShoulderOnPlayerDeath == EntityOnShoulderOnPlayerDeath.RESPAWN_WITH_PLAYER) return;

            Vec3 newRabbitPos = new Vec3(player.position().x, player.position().y + 1.5, player.position().z);
            CelestialRabbitEntity newRabbit = getCelestialRabbitEntity(player, entityOnShoulder, newRabbitPos, false);
            player.level().addFreshEntity(newRabbit);
            player.removeData(ModAttachmentTypes.PLAYER_ENTITY_ON_SHOULDER);
            playerDropEntityOnShoulder(player.getStringUUID());

            if (entityOnShoulderOnPlayerDeath == EntityOnShoulderOnPlayerDeath.DEATH) {
                newRabbit.kill();
            }

            player.removeData(ModAttachmentTypes.PLAYER_ENTITY_ON_SHOULDER);
        }
    }

    private static @NotNull CelestialRabbitEntity getCelestialRabbitEntity(Player player, PlayerEntityOnShoulder entityOnShoulder, Vec3 pos, boolean sittingPose) {
        CelestialRabbitEntity newRabbit = new CelestialRabbitEntity(ModEntities.CELESTIAL_RABBIT.get(), player.level());
        newRabbit.setPos(pos.x(), pos.y(), pos.z());
        newRabbit.setCollarColor(DyeColor.byId(entityOnShoulder.collarDyeColorId()));
        newRabbit.setOrderedToSit(sittingPose);
        if (entityOnShoulder.name() != null && !entityOnShoulder.name().isEmpty()) newRabbit.setCustomName(Component.nullToEmpty(entityOnShoulder.name()));
        newRabbit.tame(player);
        return newRabbit;
    }

    @SubscribeEvent
    public static void fallDamageEvent(LivingFallEvent event) {
        if (event.getEntity() instanceof Player player &&
                !event.getEntity().level().isClientSide() &&
                (
                        player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == ModItem.PLUTONS_KEY.get() &&
                                player.getCooldowns().getCooldownPercent(ModItem.PLUTONS_KEY.get(), 0) >= 0.98F
                )
        ) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack itemStack = new ItemStack(Items.EMERALD, 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, random) -> new MerchantOffer(
                    new ItemCost(ModItem.STRAWBERRY.get(), 7),
                    itemStack,
                    12,
                    2,
                    0.1F
            ));

            trades.get(villagerLevel).add((trader, random) -> new MerchantOffer(
                    new ItemCost(ModItem.MINT.get(), 7),
                    itemStack,
                    12,
                    2,
                    0.1F
            ));

            trades.get(villagerLevel).add((trader, random) -> new MerchantOffer(
                    new ItemCost(ModItem.VANILLA.get(), 5),
                    itemStack,
                    12,
                    2,
                    0.1F
            ));

            trades.get(3).add((trader, random) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModBlock.CREAM_STRAWBERRY_CAKE.get(), 1),
                    8,
                    8,
                    0.35F
            ));

            trades.get(3).add((trader, random) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModBlock.STRAWBERRY_CHOCO_CAKE.get(), 1),
                    8,
                    8,
                    0.35F
            ));

            trades.get(3).add((trader, random) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModBlock.CREAM_CAKE.get(), 1),
                    8,
                    8,
                    0.35F
            ));

            trades.get(3).add((trader, random) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModBlock.BERRY_STRAWBERRY_CAKE.get(), 1),
                    8,
                    8,
                    0.35F
            ));

            trades.get(3).add((trader, random) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModBlock.STRAWBERRY_CAKE.get(), 1),
                    8,
                    8,
                    0.35F
            ));

            trades.get(3).add((trader, random) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModBlock.RHUM_CAKE.get(), 1),
                    8,
                    8,
                    0.35F
            ));

            trades.get(3).add((trader, random) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModBlock.CHOCOLATE_CAKE.get(), 1),
                    8,
                    8,
                    0.35F
            ));

            trades.get(3).add((trader, random) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModBlock.VELVET_CAKE.get(), 1),
                    8,
                    8,
                    0.35F
            ));
        }
    }
}
