package config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseInitializer {
    @PostConstruct
    public void initialize() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("../../../../hey-cousin-36230-firebase-adminsdk-di9ud-7dc6abc3f7.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setProjectId("hey-cousin-36230")
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://hey-cousin-36230.firebaseio.com/")
                .build();

        FirebaseApp.initializeApp(options);
    }
}
