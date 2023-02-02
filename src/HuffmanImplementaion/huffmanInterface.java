package HuffmanImplementaion;
import java.util.HashMap;
import java.util.Map;
import TreeNode.TreeNode;
public interface huffmanInterface {
    public void generate(String msg);

    public HashMap<Character, Integer> characterFreq(String msg);

    HashMap<Character, String> huffmanCode = new HashMap<>();

    public void  generateTree(TreeNode root, String str, Map<Character, String> FormEncode);
}
