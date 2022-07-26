package com.example.orm.dto;

import lombok.Builder;

@Builder
public record SiteResponse (
        Integer id,
        String name,
        Integer pid
) {
}
