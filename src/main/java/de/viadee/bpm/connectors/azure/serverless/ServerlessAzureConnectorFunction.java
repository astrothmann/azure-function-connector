package de.viadee.bpm.connectors.azure.serverless;

import de.viadee.bpm.connectors.azure.serverless.dto.ConnectorRequest;
import de.viadee.bpm.connectors.azure.serverless.dto.MyConnectorResult;
import io.camunda.connector.api.annotation.OutboundConnector;
import io.camunda.connector.api.outbound.OutboundConnectorContext;
import io.camunda.connector.api.outbound.OutboundConnectorFunction;
import io.camunda.connector.generator.java.annotation.ElementTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@OutboundConnector(
    name = "Azure Function Connector",
    inputVariables = {"authentication", "configuration"},
    type = "de.viadee.bpm.camunda:azure-serverless-connector:1")
@ElementTemplate(
    id = "io.camunda.connector.azure.function.v1",
    name = "Azure Function Connector",
    version = 1,
    description = "Invoke azure serverless functions from within processes",
    icon = "azure-function.svg",
    documentationRef = "https://docs.camunda.io/docs/components/connectors/out-of-the-box-connectors/available-connectors-overview/",
    propertyGroups = {
      @ElementTemplate.PropertyGroup(id = "authentication", label = "Authentication"),
      @ElementTemplate.PropertyGroup(id = "configuration", label = "Configuration")
    },
    inputDataClass = ConnectorRequest.class)
public class ServerlessAzureConnectorFunction implements OutboundConnectorFunction {

  private static final Logger LOGGER = LoggerFactory.getLogger(
      ServerlessAzureConnectorFunction.class);

  @Override
  public Object execute(OutboundConnectorContext context) {
    final var connectorRequest = context.bindVariables(ConnectorRequest.class);

    var result = ExecutionHandler.getExecutor(connectorRequest,
        context.getJobContext().getProcessInstanceKey());

    return result;
  }
}