package doctor4t.spacemod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import dev.upcraft.sdrm.api.SDRMVerifier;
import doctor4t.spacemod.cca.PlayerSpaceComponent;
import doctor4t.spacemod.cca.ShipWorldComponent;
import doctor4t.spacemod.cca.SolarSystemComponent;
import doctor4t.spacemod.cca.SpaceModComponents;
import doctor4t.spacemod.planet.Planet;
import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Function;
import net.minecraft.class_2168;
import net.minecraft.class_2170;
import net.minecraft.class_2186;
import net.minecraft.class_2561;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_7157;

public class RFTSCommand {
   public static void register(CommandDispatcher<class_2168> dispatcher, class_7157 registryAccess) {
      dispatcher.register(
         (LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)class_2170.method_9247(
                                       "rfts"
                                    )
                                    .requires(source -> source.method_9259(2)))
                                 .then(class_2170.method_9247("where_the_fuck_is_janus").executes(RFTSCommand::whereTheFuckIsJanus)))
                              .then(
                                 ((LiteralArgumentBuilder)class_2170.method_9247("oxygen")
                                       .then(
                                          class_2170.method_9247("set")
                                             .then(
                                                class_2170.method_9244("targets", class_2186.method_9308())
                                                   .then(
                                                      class_2170.method_9244("amount", IntegerArgumentType.integer(0, 24000))
                                                         .executes(
                                                            ctx -> executeSet(
                                                               ctx,
                                                               class_2186.method_9312(ctx, "targets"),
                                                               "oxygen",
                                                               IntegerArgumentType.getInteger(ctx, "amount"),
                                                               PlayerSpaceComponent::setOxygen
                                                            )
                                                         )
                                                   )
                                             )
                                       ))
                                    .then(
                                       class_2170.method_9247("get")
                                          .then(
                                             class_2170.method_9244("target", class_2186.method_9305())
                                                .executes(
                                                   ctx -> executeGet(ctx, class_2186.method_9315(ctx, "target"), "oxygen", PlayerSpaceComponent::getOxygen)
                                                )
                                          )
                                    )
                              ))
                           .then(
                              ((LiteralArgumentBuilder)class_2170.method_9247("fuel")
                                    .then(
                                       class_2170.method_9247("set")
                                          .then(
                                             class_2170.method_9244("targets", class_2186.method_9308())
                                                .then(
                                                   class_2170.method_9244("amount", IntegerArgumentType.integer(0, 3600))
                                                      .executes(
                                                         ctx -> executeSet(
                                                            ctx,
                                                            class_2186.method_9312(ctx, "targets"),
                                                            "fuel",
                                                            IntegerArgumentType.getInteger(ctx, "amount"),
                                                            PlayerSpaceComponent::setFuel
                                                         )
                                                      )
                                                )
                                          )
                                    ))
                                 .then(
                                    class_2170.method_9247("get")
                                       .then(
                                          class_2170.method_9244("target", class_2186.method_9305())
                                             .executes(ctx -> executeGet(ctx, class_2186.method_9315(ctx, "target"), "fuel", PlayerSpaceComponent::getFuel))
                                       )
                                 )
                           ))
                        .then(
                           ((LiteralArgumentBuilder)class_2170.method_9247("suffocation")
                                 .then(
                                    class_2170.method_9247("set")
                                       .then(
                                          class_2170.method_9244("targets", class_2186.method_9308())
                                             .then(
                                                class_2170.method_9244("amount", IntegerArgumentType.integer(0, 400))
                                                   .executes(
                                                      ctx -> executeSet(
                                                         ctx,
                                                         class_2186.method_9312(ctx, "targets"),
                                                         "suffocation",
                                                         IntegerArgumentType.getInteger(ctx, "amount"),
                                                         PlayerSpaceComponent::setSuffocation
                                                      )
                                                   )
                                             )
                                       )
                                 ))
                              .then(
                                 class_2170.method_9247("get")
                                    .then(
                                       class_2170.method_9244("target", class_2186.method_9305())
                                          .executes(
                                             ctx -> executeGet(ctx, class_2186.method_9315(ctx, "target"), "suffocation", PlayerSpaceComponent::getSuffocation)
                                          )
                                    )
                              )
                        ))
                     .then(
                        ((LiteralArgumentBuilder)class_2170.method_9247("incapacitated")
                              .then(
                                 class_2170.method_9247("set")
                                    .then(
                                       class_2170.method_9244("targets", class_2186.method_9308())
                                          .then(
                                             class_2170.method_9244("value", BoolArgumentType.bool())
                                                .executes(
                                                   ctx -> executeSet(
                                                      ctx,
                                                      class_2186.method_9312(ctx, "targets"),
                                                      "incapacitated",
                                                      BoolArgumentType.getBool(ctx, "value"),
                                                      PlayerSpaceComponent::setDead
                                                   )
                                                )
                                          )
                                    )
                              ))
                           .then(
                              class_2170.method_9247("get")
                                 .then(
                                    class_2170.method_9244("target", class_2186.method_9305())
                                       .executes(ctx -> executeGet(ctx, class_2186.method_9315(ctx, "target"), "incapacitated", PlayerSpaceComponent::isDead))
                                 )
                           )
                     ))
                  .then(
                     ((LiteralArgumentBuilder)class_2170.method_9247("in_space")
                           .then(
                              class_2170.method_9247("set")
                                 .then(
                                    class_2170.method_9244("targets", class_2186.method_9308())
                                       .then(
                                          class_2170.method_9244("value", BoolArgumentType.bool())
                                             .executes(
                                                ctx -> executeSet(
                                                   ctx,
                                                   class_2186.method_9312(ctx, "targets"),
                                                   "in_space",
                                                   BoolArgumentType.getBool(ctx, "value"),
                                                   PlayerSpaceComponent::setInSpace
                                                )
                                             )
                                       )
                                 )
                           ))
                        .then(
                           class_2170.method_9247("get")
                              .then(
                                 class_2170.method_9244("target", class_2186.method_9305())
                                    .executes(ctx -> executeGet(ctx, class_2186.method_9315(ctx, "target"), "in_space", PlayerSpaceComponent::isInSpace))
                              )
                        )
                  ))
               .then(
                  ((LiteralArgumentBuilder)class_2170.method_9247("ship_movement_speed")
                        .then(
                           class_2170.method_9247("set")
                              .then(
                                 class_2170.method_9244("amount", DoubleArgumentType.doubleArg(0.0, 5.0E8))
                                    .executes(
                                       ctx -> executeSetWorld(
                                          ctx, "ship_movement_speed", DoubleArgumentType.getDouble(ctx, "amount"), ShipWorldComponent::setLinearMultiplier
                                       )
                                    )
                              )
                        ))
                     .then(class_2170.method_9247("get").executes(ctx -> executeGetWorld(ctx, "ship_movement_speed", ShipWorldComponent::getLinearMultiplier)))
               ))
            .then(
               ((LiteralArgumentBuilder)class_2170.method_9247("ship_rotation_speed")
                     .then(
                        class_2170.method_9247("set")
                           .then(
                              class_2170.method_9244("amount", DoubleArgumentType.doubleArg(0.0, 0.1))
                                 .executes(
                                    ctx -> executeSetWorld(
                                       ctx, "ship_rotation_speed", DoubleArgumentType.getDouble(ctx, "amount"), ShipWorldComponent::setAngularMultiplier
                                    )
                                 )
                           )
                     ))
                  .then(class_2170.method_9247("get").executes(ctx -> executeGetWorld(ctx, "ship_rotation_speed", ShipWorldComponent::getAngularMultiplier)))
            )
      );
   }

   private static int whereTheFuckIsJanus(CommandContext<class_2168> ctx) {
      class_3218 world = ((class_2168)ctx.getSource()).method_9225();
      SolarSystemComponent solarSys = (SolarSystemComponent)SpaceModComponents.SOLAR_SYSTEM.get(world);
      ShipWorldComponent ship = (ShipWorldComponent)SpaceModComponents.SHIP.get(world);

      for (Planet planet : solarSys.getAllPlanets()) {
         if (planet.getId() == 9) {
            ship.getPosition().set(planet.getPosition()).add(planet.getRadius() * 1.5, 0.0, 0.0).mul(1000000.0);
            ship.getVelocity().zero();
         }
      }

      return 1;
   }

   private static <T> int executeSet(
      CommandContext<class_2168> ctx, Collection<class_3222> targets, String argument, T value, BiConsumer<PlayerSpaceComponent, T> setter
   ) {
      class_2168 source = (class_2168)ctx.getSource();

      for (class_3222 player : targets) {
         PlayerSpaceComponent component = (PlayerSpaceComponent)SpaceModComponents.SPACE.get(player);
         setter.accept(component, value);
         component.sync();
      }

      if (targets.size() == 1) {
         source.method_9226(
            () -> class_2561.method_43469("commands.rfts.set.success.single", new Object[]{argument, value, targets.iterator().next().method_5476()}), true
         );
      } else {
         source.method_9226(() -> class_2561.method_43469("commands.rfts.set.success.multiple", new Object[]{argument, value, targets.size()}), true);
      }

      return targets.size();
   }

   private static <T> int executeGet(CommandContext<class_2168> ctx, class_3222 player, String argument, Function<PlayerSpaceComponent, T> getter) {
      class_2168 source = (class_2168)ctx.getSource();
      T value = getter.apply((PlayerSpaceComponent)SpaceModComponents.SPACE.get(player));
      source.method_9226(() -> class_2561.method_43469("commands.rfts.get.success", new Object[]{argument, value, player.method_5476()}), true);
      return 1;
   }

   private static <T> int executeSetWorld(CommandContext<class_2168> ctx, String argument, T value, BiConsumer<ShipWorldComponent, T> setter) {
      class_2168 source = (class_2168)ctx.getSource();
      ShipWorldComponent component = (ShipWorldComponent)SpaceModComponents.SHIP.get(source.method_9225());
      setter.accept(component, value);
      component.sync();
      source.method_9226(() -> class_2561.method_43469("commands.rfts.setworld.success.single", new Object[]{argument, value}), true);
      return 1;
   }

   private static <T> int executeGetWorld(CommandContext<class_2168> ctx, String argument, Function<ShipWorldComponent, T> getter) {
      class_2168 source = (class_2168)ctx.getSource();
      T value = getter.apply((ShipWorldComponent)SpaceModComponents.SHIP.get(source.method_9225()));
      source.method_9226(() -> class_2561.method_43469("commands.rfts.getworld.success", new Object[]{argument, value}), true);
      return 1;
   }

   static {
      SDRMVerifier.checkKey("spacemod", "aa4623fa-ed49-4885-859f-6efff3aad37d");
   }
}
