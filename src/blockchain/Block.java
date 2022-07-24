package blockchain;

public class Block {

    private final int id;
    private final long timestamp;
    private final String previousBlockHash;

    public Block(int id, long timestamp, String previousBlockHash) {
        this.id = id;
        this.timestamp = timestamp;
        this.previousBlockHash = previousBlockHash;
    }


    public String getHash() {
        return StringUtil.applySha256("" + id + timestamp + previousBlockHash);
    }

    public int getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getPreviousBlockHash() {
        return previousBlockHash;
    }
}
