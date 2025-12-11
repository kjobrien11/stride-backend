package com.stride.stride.dto;

import java.time.LocalDateTime;

public record TaskDTO(Integer taskId, String name, Boolean active, LocalDateTime createdAt) {
}
