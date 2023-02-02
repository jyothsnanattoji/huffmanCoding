package Decoding;

import FileOp.FileOperations;

import java.util.HashMap;
import java.util.Map;

import static HuffmanImplementaion.huffmanInterface.huffmanCode;

public class HuffmanDecodingClassImlementaion implements Decode{
    FileOperations fo= new FileOperations();
    @Override
    public void decode() {
        StringBuilder fi=decodeString(fo.ReadBinaryFile());
        fo.writeFile(fi.toString());
    }

    public StringBuilder decodeString(String msg) {
        Map<String, Character> reverseHuffmanCode = new HashMap<>();
        for (Map.Entry<Character, String> entry : huffmanCode.entrySet()) {
            reverseHuffmanCode.put(entry.getValue(), entry.getKey());
        }
        StringBuilder sb2 = new StringBuilder();
        String temp = "";
        for (int i = 0; i < msg.length(); i++) {
            temp += msg.charAt(i);
            Character c = reverseHuffmanCode.get(temp);
            if (c != null) {
                sb2.append(c);
                temp = "";
            }
        }
        return sb2;
    }
}
