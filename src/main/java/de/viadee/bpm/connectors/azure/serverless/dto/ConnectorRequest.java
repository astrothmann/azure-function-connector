package de.viadee.bpm.connectors.azure.serverless.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record ConnectorRequest(
    @Valid @NotNull Configuration configuration,
    @Valid @NotNull Authentication authentication) {}
