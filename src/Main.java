import Encoding.HuffmanEncodingClassImplementation;
import Decoding.HuffmanDecodingClassImlementaion;
public class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        HuffmanEncodingClassImplementation hfe= new HuffmanEncodingClassImplementation();
        hfe.encode();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Encode time in milliseconds: " + elapsedTime);

        startTime = System.currentTimeMillis();
        HuffmanDecodingClassImlementaion hfd= new HuffmanDecodingClassImlementaion();
        hfd.decode();
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("Encode time in milliseconds: " + elapsedTime);
    }
}