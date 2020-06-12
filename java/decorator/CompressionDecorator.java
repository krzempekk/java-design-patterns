package decorator;

public class CompressionDecorator extends DataSourceDecorator {

    public CompressionDecorator(DataSource source) {
        super(source);
    }

    private String compress(String data) {
        String result = new String();
        for (int i = 0; i < data.length(); i++) {
            int j = i;
            while (j < data.length() && data.charAt(i) == data.charAt(j)) {
                j++;
            }
            j--;
            Integer repeats = new Integer(j - i + 1);
            result = result.concat(String.valueOf(data.charAt(i))).concat(repeats.toString());
            i = j;
        }
        return result;
    }

    private String decompress(String data) {
        String result = new String();
        for (int i = 0; i < data.length(); i+=2) {
            for (int j = 0; j < Character.getNumericValue(data.charAt(i+1)); j++) {
                result = result.concat(String.valueOf(data.charAt(i)));
            }
        }
        return result;
    }

    @Override
    public String readData() {
        String compressed = super.readData();
        return this.decompress(compressed);
    }

    @Override
    public void writeData(String data) {
        super.writeData(this.compress(data));
    }
}
