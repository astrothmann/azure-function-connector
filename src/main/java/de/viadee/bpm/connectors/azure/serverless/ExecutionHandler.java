package de.viadee.bpm.connectors.azure.serverless;

import de.viadee.bpm.connectors.azure.serverless.dto.ConnectorRequest;

public class ExecutionHandler {

  public static ConnectorExecutor getExecutor(ConnectorRequest connectorRequest,
      long processInstanceKey) {

    var selectedOperation = ApiOperationsEnum.fromValue(
        connectorRequest.configuration().operation()
    );

    switch (selectedOperation) {
      case INVOKE_FUNCTION_SYNC:
        return new InvokeFunctionSyncExecutor(connectorRequest, processInstanceKey);
      case GET_FUNCTION_LIST:
        return new GetFunctionListExecutor(connectorRequest, processInstanceKey);
      default: // OTHER
        throw new RuntimeException("Selected operation is not supported");
    }
  }

}
