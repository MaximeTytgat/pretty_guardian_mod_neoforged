package com.max.prettyguardian.event;

import com.example.prettyguardian.PrettyGuardian;
import com.example.prettyguardian.block.ModBlock;
import com.example.prettyguardian.component.ModAttachmentTypes;
import com.example.prettyguardian.entity.ModEntities;
import com.example.prettyguardian.entity.custom.CelestialRabbitEntity;
import com.example.prettyguardian.entityonshoulder.PlayerEntityOnShoulder;
import com.example.prettyguardian.item.ModItem;
import com.max.prettyguardian.networking.ModMessages;
import com.max.prettyguardian.networking.packet.PlayerEntityOnShoulderDataSCPacket;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.LogicalSide;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

import java.util.List;
import java.util.Objects;

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

                if (entityOnShoulder.getEntityType() != null && entityOnShoulder.getEntityType() == ModEntities.CELESTIAL_RABBIT.get()) {
                    bringTheAnimalDownFromTheShoulder(event, entityOnShoulder, player);
                }
            }

        }
    }

    private static boolean isNotValidPlayer(Player player) {
        return player == null || player.isSpectator() || player.getVehicle() != null;
    }

    private static boolean hasAllConditionsForProcess(PlayerInteractEvent.RightClickBlock event, Player player) {
        return player.isShiftKeyDown()
                && event.getHand() == InteractionHand.MAIN_HAND
                && player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == Items.AIR
                && event.getSide() == LogicalSide.SERVER;
    }

    private static void bringTheAnimalDownFromTheShoulder(PlayerInteractEvent.RightClickBlock event, PlayerEntityOnShoulder entityOnShoulder, Player player) {
        CelestialRabbitEntity newRabbit = new CelestialRabbitEntity(ModEntities.CELESTIAL_RABBIT.get(), player.level());

        Direction direction = event.getFace();
        switch (direction) {
            case UP:
                newRabbit.setPos(event.getPos().getX() + 0.5, event.getPos().getY() + 1, event.getPos().getZ() + 0.5);
                break;
            case DOWN:
                newRabbit.setPos(event.getPos().getX() + 0.5, event.getPos().getY() - 1, event.getPos().getZ() + 0.5);
                break;
            case NORTH:
                newRabbit.setPos(event.getPos().getX() + 0.5, event.getPos().getY(), event.getPos().getZ() - 0.5);
                break;
            case SOUTH:
                newRabbit.setPos(event.getPos().getX() + 0.5, event.getPos().getY(), event.getPos().getZ() + 1.5);
                break;
            case WEST:
                newRabbit.setPos(event.getPos().getX() - 0.5, event.getPos().getY(), event.getPos().getZ() + 0.5);
                break;
            case EAST:
                newRabbit.setPos(event.getPos().getX() + 1.5, event.getPos().getY(), event.getPos().getZ() + 0.5);
                break;
            case null:
                break;
        }

        newRabbit.setCollarColor(entityOnShoulder.getCollarColor());
        newRabbit.setOrderedToSit(entityOnShoulder.isInSittingPose());

        if (entityOnShoulder.getName() != null) newRabbit.setCustomName(entityOnShoulder.getName());
        newRabbit.tame(player);

        player.level().addFreshEntity(newRabbit);

        entityOnShoulder.letGoEntity();

        ModMessages.sendToAllPlayers(
                new PlayerEntityOnShoulderDataSCPacket(
                        player.getStringUUID(),
                        false
                )
        );
    }

    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();

        if (isNotValidPlayer(player)) {
            return;
        }

        if (
            event.getTarget() instanceof LivingEntity livingEntity
            && !player.level().isClientSide
            && livingEntity instanceof CelestialRabbitEntity celestialRabbit
            && player.isShiftKeyDown()
            && celestialRabbit.isTame()
            &&  (Objects.equals(Objects.requireNonNull(celestialRabbit.getOwnerUUID()).toString(), player.getUUID().toString()))
            && event.getSide() == LogicalSide.SERVER
        ) {
            PlayerEntityOnShoulder entityOnShoulder = player.getData(ModAttachmentTypes.PLAYER_ENTITY_ON_SHOULDER);

            if (entityOnShoulder.getEntityType() == null) {
                DyeColor collarColor = celestialRabbit.getCollarColor();
                Component name = celestialRabbit.hasCustomName() ? celestialRabbit.getCustomName() : null;
                boolean isInSittingPose = celestialRabbit.isInSittingPose();

                entityOnShoulder.setEntityOnShoulder(ModEntities.CELESTIAL_RABBIT.get(), collarColor, name, isInSittingPose);

                livingEntity.discard();

                ModMessages.sendToAllPlayers(
                        new PlayerEntityOnShoulderDataSCPacket(
                                player.getStringUUID(),
                                true
                        )
                );
            }
        }
    }

// TODO: Needed ?
//    @SubscribeEvent
//    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
//        if(
//                !event.getLevel().isClientSide()
//                && event.getEntity() instanceof ServerPlayer player
//        ) {
//                player.getCapability(PlayerEntityOnShoulderProvider.PLAYER_ENTITY_ON_SHOULDER_CAPABILITY).ifPresent(entityOnShoulder -> {
//                    if (entityOnShoulder.getEntityType() != null) {
//                        ModMessages.sendToAllPlayers(new PlayerEntityOnShoulderDataSCPacket(
//                                player.getStringUUID(),
//                                true
//                        ));
//                    }
//                });
//            }
//
//    }

    // TODO: add config to choose if the rabbit should spawn, die or stay on the shoulder
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if(event.getEntity() instanceof Player player) {
            player.getCapability(PlayerEntityOnShoulderProvider.PLAYER_ENTITY_ON_SHOULDER_CAPABILITY).ifPresent(entityOnShoulder -> {
                if(entityOnShoulder.getEntityType() != null) {
                    CelestialRabbitEntity newRabbit = new CelestialRabbitEntity(ModEntities.CELESTIAL_RABBIT.get(), player.level());
                    newRabbit.setPos(player.getX(), player.getY() + 1.5, player.getZ());
                    newRabbit.setCollarColor(entityOnShoulder.getCollarColor());
                    newRabbit.setOrderedToSit(false);
                    if (entityOnShoulder.getName() != null) newRabbit.setCustomName(entityOnShoulder.getName());
                    newRabbit.tame(player);

                    player.level().addFreshEntity(newRabbit);

                    entityOnShoulder.letGoEntity();

                    ModMessages.sendToAllPlayers(
                            new PlayerEntityOnShoulderDataSCPacket(
                                    player.getStringUUID(),
                                    false
                            )
                    );
                }
            });
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
