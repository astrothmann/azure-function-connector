package de.viadee.bpm.connectors.azure.serverless.dto;

import io.camunda.connector.generator.java.annotation.TemplateProperty;
import jakarta.validation.constraints.NotEmpty;

public record Configuration(
    @NotEmpty
    @TemplateProperty(group = "configuration", label = "Operation", description = "Type of operation to invoke")
    String operation,
    @NotEmpty
    @TemplateProperty(group = "configuration", label = "Function Name", description = "Name of function to invoke")
    String functionName) { }
