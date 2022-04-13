package org.cloudburstmc.protocol.bedrock.codec.v486;

import org.cloudburstmc.protocol.bedrock.codec.BedrockCodec;
import org.cloudburstmc.protocol.bedrock.codec.v291.serializer.LevelSoundEvent1Serializer_v291;
import org.cloudburstmc.protocol.bedrock.codec.v313.serializer.LevelSoundEvent2Serializer_v313;
import org.cloudburstmc.protocol.bedrock.codec.v332.serializer.LevelSoundEventSerializer_v332;
import org.cloudburstmc.protocol.bedrock.codec.v465.BedrockCodecHelper_v465;
import org.cloudburstmc.protocol.bedrock.codec.v475.Bedrock_v475;
import org.cloudburstmc.protocol.bedrock.codec.v486.serializer.AddVolumeEntitySerializer_v486;
import org.cloudburstmc.protocol.bedrock.codec.v486.serializer.BossEventSerializer_v486;
import org.cloudburstmc.protocol.bedrock.codec.v486.serializer.CodeBuilderSourceSerializer_v486;
import org.cloudburstmc.protocol.bedrock.codec.v486.serializer.LevelChunkSerializer_v486;
import org.cloudburstmc.protocol.bedrock.codec.v486.serializer.PlayerStartItemCooldownSerializer_v486;
import org.cloudburstmc.protocol.bedrock.codec.v486.serializer.ScriptMessageSerializer_v486;
import org.cloudburstmc.protocol.bedrock.codec.v486.serializer.SubChunkRequestSerializer_v486;
import org.cloudburstmc.protocol.bedrock.codec.v486.serializer.SubChunkSerializer_v486;
import org.cloudburstmc.protocol.bedrock.data.SoundEvent;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityFlag;
import org.cloudburstmc.protocol.bedrock.data.inventory.stackrequestactions.StackRequestActionType;
import org.cloudburstmc.protocol.bedrock.packet.AddVolumeEntityPacket;
import org.cloudburstmc.protocol.bedrock.packet.BossEventPacket;
import org.cloudburstmc.protocol.bedrock.packet.CodeBuilderSourcePacket;
import org.cloudburstmc.protocol.bedrock.packet.LevelChunkPacket;
import org.cloudburstmc.protocol.bedrock.packet.LevelSoundEvent1Packet;
import org.cloudburstmc.protocol.bedrock.packet.LevelSoundEvent2Packet;
import org.cloudburstmc.protocol.bedrock.packet.LevelSoundEventPacket;
import org.cloudburstmc.protocol.bedrock.packet.PlayerStartItemCooldownPacket;
import org.cloudburstmc.protocol.bedrock.packet.ScriptMessagePacket;
import org.cloudburstmc.protocol.bedrock.packet.SubChunkPacket;
import org.cloudburstmc.protocol.bedrock.packet.SubChunkRequestPacket;
import org.cloudburstmc.protocol.common.util.TypeMap;

public class Bedrock_v486 extends Bedrock_v475 {

    protected static final TypeMap<EntityFlag> ENTITY_FLAGS = Bedrock_v475.ENTITY_FLAGS.toBuilder()
            .insert(100, EntityFlag.CROAKING)
            .insert(101, EntityFlag.EAT_MOB)
            .build();

    protected static final TypeMap<StackRequestActionType> ITEM_STACK_REQUEST_TYPES = Bedrock_v475.ITEM_STACK_REQUEST_TYPES.toBuilder()
            .shift(7, 2)
            .insert(7, StackRequestActionType.PLACE_IN_ITEM_CONTAINER)
            .insert(8, StackRequestActionType.TAKE_FROM_ITEM_CONTAINER)
            .build();

    protected static final TypeMap<SoundEvent> SOUND_EVENTS = Bedrock_v475.SOUND_EVENTS.toBuilder()
            .replace(372, SoundEvent.TONGUE)
            .insert(373, SoundEvent.CRACK_IRON_GOLEM)
            .insert(374, SoundEvent.REPAIR_IRON_GOLEM)
            .insert(375, SoundEvent.UNDEFINED)
            .build();

    public static final BedrockCodec CODEC = Bedrock_v475.CODEC.toBuilder()
            .protocolVersion(486)
            .minecraftVersion("1.18.10")
            .helper(() -> new BedrockCodecHelper_v465(ENTITY_DATA, ENTITY_DATA_TYPES, ENTITY_FLAGS, GAME_RULE_TYPES, ITEM_STACK_REQUEST_TYPES))
            .updateSerializer(AddVolumeEntityPacket.class, AddVolumeEntitySerializer_v486.INSTANCE)
            .updateSerializer(BossEventPacket.class, BossEventSerializer_v486.INSTANCE)
            .updateSerializer(LevelSoundEvent1Packet.class, new LevelSoundEvent1Serializer_v291(SOUND_EVENTS))
            .updateSerializer(LevelSoundEvent2Packet.class, new LevelSoundEvent2Serializer_v313(SOUND_EVENTS))
            .updateSerializer(LevelSoundEventPacket.class, new LevelSoundEventSerializer_v332(SOUND_EVENTS))
            .updateSerializer(LevelChunkPacket.class, LevelChunkSerializer_v486.INSTANCE)
            .updateSerializer(SubChunkPacket.class, SubChunkSerializer_v486.INSTANCE)
            .updateSerializer(SubChunkRequestPacket.class, SubChunkRequestSerializer_v486.INSTANCE)
            .registerPacket(PlayerStartItemCooldownPacket.class, PlayerStartItemCooldownSerializer_v486.INSTANCE, 176)
            .registerPacket(ScriptMessagePacket.class, ScriptMessageSerializer_v486.INSTANCE, 177)
            .registerPacket(CodeBuilderSourcePacket.class, CodeBuilderSourceSerializer_v486.INSTANCE, 178)
            .build();
}
