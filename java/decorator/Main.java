package decorator;

public class Main {
    public static void main(String[] args) {
        String text = "Ala ma kota";
        DataSourceDecorator encodedAndCompressed = new EncryptionDecorator(
                new CompressionDecorator(
                        new FileDataSource("out/compressedFile.txt")));
        encodedAndCompressed.writeData(text);
        DataSource justRead = new FileDataSource("out/compressedFile.txt");
        System.out.println("- Base string");
        System.out.println(text);
        System.out.println("- Encoded and compressed");
        System.out.println(justRead.readData());
        System.out.println("- Decoded and decompressed");
        System.out.println(encodedAndCompressed.readData());
    }
}