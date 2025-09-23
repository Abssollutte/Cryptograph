import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;

@UtilityClass
public class ConsoleHelper {
    private final BufferedReader console = new BufferedReader(new InputStreamReader(System.in));


    @SneakyThrows
    public String readString() {
        return console.readLine();
    }

    public int readInt() {
        return Integer.parseInt(readString());
    }

    public Path buildFileName(String path, String suffix) {
        return null;
    }
}
