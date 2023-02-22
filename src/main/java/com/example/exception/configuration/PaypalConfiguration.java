/*
package com.example.exception.configuration;

import com.paypal.core.PayPalHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaypalConfiguration {
    @Value("${paypal.client.id}")
    private String clientId;

    @Value("${paypal.client.secret}")
    private String clientSecret;

    @Bean
    public PayPalHttpClient payPalHttpClient() {
        return new PayPalHttpClient(new Environment() {
            @Override
            public String clientId() {
                return clientId;
            }

            @Override
            public String clientSecret() {
                return clientSecret;
            }

            @Override
            public String mode() {
                return "sandbox"; // Hoặc "live" nếu bạn sử dụng tài khoản PayPal thật
            }
        });
    }
}
*/
