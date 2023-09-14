package java13g3.justMeet.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class GoogleCloudStorageConfig {

    private static final String CREDENTIALS_JSON_PATH = "src/main/resources/cloudstorage.json";
    private static final String BUCKET_NAME = "justmeetapplication";

    @Bean
    public Storage storage() throws IOException {
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(CREDENTIALS_JSON_PATH));
        return StorageOptions.newBuilder().setCredentials(credentials).build().getService();
    }

    @Bean
    public String bucketName() {
        return BUCKET_NAME;
    }
}
