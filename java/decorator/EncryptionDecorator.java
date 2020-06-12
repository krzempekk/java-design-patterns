package decorator;

import java.util.Base64;

public class EncryptionDecorator extends DataSourceDecorator {
    private final int key = Character.getNumericValue('H');
    
    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    private String encode(String data) {
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    private String decode(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }

    @Override
    public void writeData(String data) {
        super.writeData(this.encode(data));
    }

    @Override
    public String readData() {
        return this.decode(super.readData());
    }
}
