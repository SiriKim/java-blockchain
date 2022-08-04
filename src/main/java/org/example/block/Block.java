package org.example.block;

import org.example.utils.BlockchainUtil;

import java.security.NoSuchAlgorithmException;

public class Block {

    private static int currIndex = 0;

    private int index;
    private long timestamp;
    private String previousHash;
    private String hash;
    private BlockData data;

    // private int nonce;

    public int getIndex() {
        return index;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    public BlockData getData() {
        return data;
    }

    public Block(String previousHash, BlockData data) throws RuntimeException {
        try {
            this.index = currIndex++;
            this.timestamp = System.currentTimeMillis();
            this.previousHash = previousHash;
            this.data = data;
            this.hash = BlockchainUtil.createHash(this.index, this.previousHash, this.timestamp, this.data);
        } catch (NoSuchAlgorithmException e) {
            currIndex--;
            throw new RuntimeException(e);
        }
    }
}
