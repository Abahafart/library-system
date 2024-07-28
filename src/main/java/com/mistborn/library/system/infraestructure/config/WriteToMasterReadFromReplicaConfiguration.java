package com.mistborn.library.system.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.observability.MicrometerTracingAdapter;

import io.lettuce.core.ReadFrom;
import io.lettuce.core.resource.ClientResources;
import io.micrometer.observation.ObservationRegistry;

@Configuration
public class WriteToMasterReadFromReplicaConfiguration {

  @Bean
  public ClientResources clientResources(ObservationRegistry observationRegistry) {

    return ClientResources.builder()
        .tracing(new MicrometerTracingAdapter(observationRegistry, "my-redis-cache"))
        .build();
  }

  @Bean
  public LettuceConnectionFactory lettuceConnectionFactory(ClientResources clientResources) {
    LettuceClientConfiguration clientConfiguration = LettuceClientConfiguration.builder()
        .readFrom(ReadFrom.REPLICA_PREFERRED)
        .clientResources(clientResources)
        .build();
    RedisStandaloneConfiguration serverConfiguration = new RedisStandaloneConfiguration("localhost",
        6379);
    return new LettuceConnectionFactory(serverConfiguration, clientConfiguration);
  }
}
