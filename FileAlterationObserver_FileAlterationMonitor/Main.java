import java.io.File;
import org.apache.commons.io.monitor.*;

public class Main {
    public static void main(String[] args) {
        File directory = new File("src/main/resources");

        // Create observer for that directory
        FileAlterationObserver observer = new FileAlterationObserver(directory);

        // Attach a listener
        observer.addListener(new FileAlterationListenerAdaptor() {
            @Override
            public void onFileCreate(File file) {
                System.out.println("File created: " + file.getName());
            }

            @Override
            public void onFileDelete(File file) {
                System.out.println("File deleted: " + file.getName());
            }

            @Override
            public void onFileChange(File file) {
                System.out.println("File modified: " + file.getName());
            }
        });

        // Poll every 3 seconds
        FileAlterationMonitor monitor = new FileAlterationMonitor(3000);
        monitor.addObserver(observer);

        // Start monitoring
        try {
            monitor.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Monitoring started. Add, delete, or change files in: " + directory.getAbsolutePath());

    }
}
