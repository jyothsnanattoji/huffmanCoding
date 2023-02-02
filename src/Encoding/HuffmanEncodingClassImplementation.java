package Encoding;
import FileOp.FileOperations;
import HuffmanImplementaion.*;
import TreeNode.TreeNode;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanEncodingClassImplementation implements  huffmanInterface,Encode{
    FileOperations fo= new FileOperations();
    @Override
    public void encode() {
        String msg=fo.readFile();
        generate(msg);
        StringBuilder sb=encodeString(msg);

        try (FileOutputStream fos = new FileOutputStream("compressed.bin")) {
            byte[] bytes = new byte[(int) Math.ceil(sb.length() / 8.0)];
            for (int i = 0;i < sb.length(); i++) {
                if (sb.charAt(i) == '1') {
                    bytes[i / 8] |= (1 << (7 - (i % 8)));
                }
            }
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generate(String msg) {
        HashMap<Character, Integer> charCountMap = characterFreq(msg);
        PriorityQueue<TreeNode> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            // add a leaf node of all the map values into the queue
            TreeNode temp = new TreeNode(entry.getKey(), entry.getValue());
            pq.add(temp);
        }
        // while there is more than 1 node left in the queue
        while (pq.size() > 1) {
            TreeNode left = pq.poll();
            TreeNode right = pq.poll();
            // compute the sum of the least freq 2 nodes
            int sum = left.count + right.count;
            TreeNode temp = new TreeNode(sum, left, right);
            // add the new node formed into the priority queue
            pq.add(temp);
        }
        // the node remaining is the root node
        TreeNode root = pq.peek();

        generateTree(root, "", huffmanCode);
    }

    @Override

        public HashMap<Character, Integer> characterFreq(String msg) {
            //generate character Frequency
            char[] chars = msg.toCharArray();
            HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
            // using a map to count and store the frequency of each character
            for (char c : chars) {
                if (charCountMap.containsKey(c)) {
                    charCountMap.put(c, charCountMap.get(c) + 1);
                } else {
                    charCountMap.put(c, 1);
                }
            }
            return charCountMap;
        }

    @Override
    public void generateTree(TreeNode root, String str, Map<Character, String> huffmanCode) {

            if (root == null)
                return;
            // checks if node is a leaf node
            if (root.left == null && root.right == null)
                huffmanCode.put(root.ch,  str );

            // add 0 to the left and 1 to the right if not leaf
            generateTree(root.left, str + "0", huffmanCode);
            generateTree(root.right, str + "1", huffmanCode);
        }

    public StringBuilder encodeString(String msg) {

        char[] chars=msg.toCharArray();
        StringBuilder sb=new StringBuilder();
        for (char c : chars) {
            sb.append(huffmanCode.get(c));
        }
        return sb;
    }
}

