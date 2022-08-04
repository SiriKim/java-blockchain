package org.example.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.example.block.Block;
import org.example.block.BlockData;
import org.example.chain.Blockchain;

import java.security.NoSuchAlgorithmException;

public class BlockchainUtil {

    public static Block generateGenesisBlock() {
        String hash = "0";
        BlockData data = new BlockData("genesis-block", 42);
        return new Block(hash, data);
    }

    public static String createHash(int index, String previousHash, long timestamp, BlockData data) throws NoSuchAlgorithmException {
        String content = index + previousHash + timestamp + data.toString();
        return DigestUtils.sha256Hex(content);
    }

    public static boolean isValidBlock(Block block) throws NoSuchAlgorithmException {
        return block.getHash().equals(BlockchainUtil.createHash(block.getIndex(), block.getPreviousHash(), block.getTimestamp(), block.getData()));
    }

    public static Block createBlock(BlockData data) {
        return new Block(Blockchain.getLatestBlock().getHash(), data);
    }
}
