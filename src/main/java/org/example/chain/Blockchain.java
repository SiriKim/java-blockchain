package org.example.chain;

import org.example.block.Block;
import org.example.utils.BlockchainUtil;

import java.util.Stack;

public class Blockchain {
    private static Stack<Block> blockchain;

    static {
        initBlockchain();
    }

    public static Block getLatestBlock() {
        return blockchain.peek();
    }

    public static void pushNewBlock(Block newBlock) {
        blockchain.push(newBlock);
    }

    private static void initBlockchain() {
        blockchain = new Stack<>();
        blockchain.push(BlockchainUtil.generateGenesisBlock());
    }

}
