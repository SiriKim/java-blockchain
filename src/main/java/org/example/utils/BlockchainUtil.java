package org.example.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.example.block.BlockData;
import org.example.block.BlockObject;
import org.example.chain.Blockchain;

import java.security.DigestException;
import java.security.NoSuchAlgorithmException;

public class BlockchainUtil {

    public static BlockObject generateGenesisBlock() {
        String hash = "0";
        BlockData data = new BlockData("genesis-block", 42);
        return new BlockObject(hash, data);
    }

    public static String createHash(int index, String previousHash, long timestamp, BlockData data) throws NoSuchAlgorithmException {
        String content = index + previousHash + timestamp + data.toString();
        return DigestUtils.sha256Hex(content);
    }

    public static boolean isNewBlockValid(BlockObject newBlock) throws NoSuchAlgorithmException {
        BlockObject previousBlock = Blockchain.getLatestBlock();
        if (previousBlock.getIndex() != newBlock.getIndex() - 1) return false;
        else if (!previousBlock.getHash().equals(newBlock.getPreviousHash())) return false;
        else
            return newBlock.getHash().equals(BlockchainUtil.createHash(newBlock.getIndex(), newBlock.getPreviousHash(), newBlock.getTimestamp(), newBlock.getData()));
    }

    public static BlockObject createBlock(BlockData data) throws NoSuchAlgorithmException, DigestException {
        BlockObject previousBlock = Blockchain.getLatestBlock();
        String previousHash = previousBlock.getHash();
        return new BlockObject(previousHash, data);
    }
}
