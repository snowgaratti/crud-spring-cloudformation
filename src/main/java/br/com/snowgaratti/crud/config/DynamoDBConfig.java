package br.com.snowgaratti.crud.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "amazon")
@EnableDynamoDBRepositories(basePackages = "br.com.snowgaratti.crud.repository")
public class DynamoDBConfig {

    private final Aws aws = new Aws();
    private final DynamoDB dynamoDb = new DynamoDB();

    public Aws getAws() {
        return aws;
    }

    public DynamoDB getDynamoDb() {
        return dynamoDb;
    }

    @Bean
    public DynamoDBMapperConfig dynamoDBMapperConfig() {
        return DynamoDBMapperConfig.DEFAULT;
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamoDb.endpoint, dynamoDb.region))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(aws.accessKey, aws.secretKey)))
                .build();
    }

    private static class Aws {

        private String accessKey;
        private String secretKey;

        public void setAccessKey(String accessKey) {
            this.accessKey = accessKey;
        }

        public void setSecretKey(String secretKey) {
            this.secretKey = secretKey;
        }
    }

    private static class DynamoDB {
        private String endpoint;
        private String region;

        public void setEndpoint(String endpoint) {
            this.endpoint = endpoint;
        }

        public void setRegion(String region) {
            this.region = region;
        }
    }
}
