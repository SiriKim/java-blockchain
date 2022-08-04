package org.example.chain;

import org.example.block.BlockObject;
import org.example.utils.BlockchainUtil;

import java.util.Stack;

public class Blockchain {
    private static Stack<BlockObject> blockchain;

    static {
        initBlockchain();
    }

    public static BlockObject getLatestBlock() {
        return blockchain.peek();
    }

    public static void pushNewBlock(BlockObject newBlock) {
        blockchain.push(newBlock);
    }

    private static void initBlockchain() {
        blockchain = new Stack<>();
        blockchain.push(BlockchainUtil.generateGenesisBlock());
    }

}
