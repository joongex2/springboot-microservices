package net.javaguides.employeeservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name="Message Service - MessageController",
        description="Message Controller Exposes REST APIs for Message-Service"
)
@RefreshScope
@RestController
public class MessageController {

    @Value("${spring.boot.message}")
    private String message;

    @Operation(
            summary="Get Message REST API",
            description="Get Message REST API is used to get message from configuration server"
    )
    @ApiResponse(
            responseCode="200",
            description="HTTP Status 200 SUCCESS"
    )
    @GetMapping("/users/message")
    public String message() {
        return message;
    }
}
