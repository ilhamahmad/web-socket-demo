package com.example.demowebsocket.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    // this function is used to getting messages (like sending channel)
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }

    // this function is used for sending message (from to which channel)
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // if we use @SendTo annotation ,this configuration automatically add app prefix to endpoint
        registry.setApplicationDestinationPrefixes("/app");

        // if we use convertAndSendToUser method , this config automatically add user prefix to endpoint
        registry.setUserDestinationPrefix("/user");

        registry.enableSimpleBroker("/chatroom","/user");
    }
}
