package com.nukkitx.protocol.bedrock.v354.serializer;

import com.nukkitx.network.VarInts;
import com.nukkitx.protocol.bedrock.packet.SetLastHurtByPacket;
import com.nukkitx.protocol.serializer.PacketSerializer;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SetLastHurtBySerializer_v354 implements PacketSerializer<SetLastHurtByPacket> {
    public static final SetLastHurtBySerializer_v354 INSTANCE = new SetLastHurtBySerializer_v354();


    @Override
    public void serialize(ByteBuf buffer, SetLastHurtByPacket packet) {
        VarInts.writeInt(buffer, packet.getEntityTypeId());
    }

    @Override
    public void deserialize(ByteBuf buffer, SetLastHurtByPacket packet) {
        packet.setEntityTypeId(VarInts.readInt(buffer));
    }
}
