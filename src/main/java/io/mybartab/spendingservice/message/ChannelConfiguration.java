package io.mybartab.spendingservice.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.outbound.PubSubMessageHandler;
import com.google.cloud.spring.pubsub.support.converter.JacksonPubSubMessageConverter;
import com.google.cloud.spring.pubsub.support.converter.PubSubMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;

@Configuration
public class ChannelConfiguration {
    /*
     An outbound channel adapter listens to new messages from a Spring channel
     and publishes them to a Google Cloud Pub/Sub topic.
     InputChannel = the channel from which this service activator will consume messages
     */
    @Bean
    @ServiceActivator(inputChannel = "add-spending-v1-out")
    public MessageHandler messageSender(PubSubTemplate pubsubTemplate) {
        return new PubSubMessageHandler(pubsubTemplate, "add-spending-v1");
    }

    @Bean
    public PubSubMessageConverter pubSubMessageConverter() {
        return new JacksonPubSubMessageConverter(new ObjectMapper());
    }
}
