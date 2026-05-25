package com.example.config;

import io.github.bucket4j.*;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Duration;

@Component
public class RateLimiterFilter implements Filter {

    private final Bucket bucket;

    public RateLimiterFilter() {

        Bandwidth limit = Bandwidth.builder()
                .capacity(5)
                .refillGreedy(5, Duration.ofMinutes(1))
                .build();

        this.bucket = Bucket.builder()
                .addLimit(limit)
                .build();
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse httpResponse =
                (HttpServletResponse) response;

        if (bucket.tryConsume(1)) {

            chain.doFilter(request, response);

        } else {

            httpResponse.setStatus(429);
            httpResponse.getWriter()
                    .write("Too many requests");
        }
    }
}