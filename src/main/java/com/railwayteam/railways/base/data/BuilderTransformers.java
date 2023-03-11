package com.railwayteam.railways.base.data;

import com.railwayteam.railways.content.custom_bogeys.monobogey.MonoBogeyBlock;
import com.railwayteam.railways.content.custom_bogeys.singleAxle.singleAxleBogeyBlock;
import com.railwayteam.railways.registry.CRBlocks;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.Create;
import com.simibubi.create.content.logistics.trains.IBogeyBlock;
import com.simibubi.create.content.logistics.trains.track.StandardBogeyBlock;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.world.level.block.SoundType;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class BuilderTransformers {
    public static <B extends MonoBogeyBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> monobogey(boolean upsideDown) {
        return b -> b.initialProperties(SharedProperties::softMetal)
            .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
            .properties(p -> p.noOcclusion())
            .transform(pickaxeOnly())
            .blockstate((c, p) -> BlockStateGen.horizontalAxisBlock(c, p, s -> p.models()
                .getExistingFile(p.modLoc("block/bogey/monorail/top" + (upsideDown ? "_upside_down" : "")))))
            .loot((p, l) -> p.dropOther(l, AllBlocks.RAILWAY_CASING.get()));
    }
    public static <B extends singleAxleBogeyBlock, P> NonNullUnaryOperator<BlockBuilder<B, P>> singleaxlebogey(boolean upsideDown) {
        return b -> b.initialProperties(SharedProperties::softMetal)
                .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
                .properties(p -> p.noOcclusion())
                .transform(pickaxeOnly())
                .blockstate((c, p) -> BlockStateGen.horizontalAxisBlock(c, p, s -> p.models()
                        .getExistingFile(p.modLoc("block/bogey/singleaxle/frame" + (upsideDown ? "_upside_down" : "")))))
                .loot((p, l) -> p.dropOther(l, AllBlocks.RAILWAY_CASING.get()));
    }
}
