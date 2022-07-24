package blockchain;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Blockchain {

    private List<Block> chain = new LinkedList<>();
    private AtomicInteger idGenerator = new AtomicInteger();
    private String previousHash;

    public Blockchain() {
        this.previousHash = "0";
    }

    public void createBlock() {
        Block block = new Block(idGenerator.incrementAndGet(), Instant.now().toEpochMilli(), previousHash);
        this.previousHash = block.getHash();
        chain.add(block);
    }

    public void printChain() {
        for (Block block : chain) {
            System.out.println(
                    String.format(
                            "Block:\n" +
                                    "Id: %d\n" +
                                    "Timestamp: %d\n" +
                                    "Hash of the previous block:\n" +
                                    "%s\n" +
                                    "Hash of the block:\n" +
                                    "%s\n",
                            block.getId(),
                            block.getTimestamp(),
                            block.getPreviousBlockHash(),
                            block.getHash()
                    )
            );
        }
    }


}
