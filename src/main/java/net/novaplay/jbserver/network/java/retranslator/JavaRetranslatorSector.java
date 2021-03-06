package net.novaplay.jbserver.network.java.retranslator;

import java.util.HashMap;

import com.github.steveice10.mc.protocol.packet.ingame.server.world.ServerChunkDataPacket;
import com.github.steveice10.packetlib.packet.Packet;

import net.novaplay.jbserver.network.java.retranslator.impl.ChunkDataRetranslator;
import net.novaplay.jbserver.network.protocol.JBPacket;
import net.novaplay.jbserver.network.protocol.JBPacketIdentifier;

public class JavaRetranslatorSector {
	
	private static HashMap<JBPacketIdentifier, JavaRetranslator> MAP = new HashMap<JBPacketIdentifier,JavaRetranslator>();
	private static HashMap<Class<? extends Packet>, JBPacketIdentifier> PAK = new HashMap<Class<? extends Packet>,JBPacketIdentifier>();
	static {
		MAP.put(JBPacketIdentifier.CHUNK_DATA, new ChunkDataRetranslator());
		
		PAK.put(ServerChunkDataPacket.class, JBPacketIdentifier.CHUNK_DATA);
		
		
	}
	
	public static Packet translateTo(JBPacket pk) {
		return MAP.get(pk.getIdentifier()).translateTo(pk);
	}
	
	public static JBPacket translateFrom(Packet pk) {
		return MAP.get(PAK.get(pk.getClass())).translateFrom(pk);
	}

}
