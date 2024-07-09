package br.com.fean.orchestrator.presentation.saga;

import static br.com.fean.orchestrator.domain.enums.EEventSource.*;
import static br.com.fean.orchestrator.domain.enums.ESagaStatus.*;
import static br.com.fean.orchestrator.domain.enums.ETopics.*;

public final class SagaHandler {

    private SagaHandler() {

    }

    public static final Object[][] SAGA_HANDLER = {
             // WHEN , THIS, GOTO

            { ORCHESTRATOR, SUCCESS, CUSTOMER_SUCCESS },
            { ORCHESTRATOR, FAIL, FINISH_FAIL },

            { CUSTOMER_SERVICE, ROLLBACK_PENDING, CUSTOMER_FAIL },
            { CUSTOMER_SERVICE, FAIL, FINISH_FAIL },
            { CUSTOMER_SERVICE, SUCCESS, PRODUCT_VALIDATION_SUCCESS },

            { PRODUCT_VALIDATION_SERVICE, ROLLBACK_PENDING, PRODUCT_VALIDATION_FAIL },
            { PRODUCT_VALIDATION_SERVICE, FAIL, FINISH_FAIL },
            { PRODUCT_VALIDATION_SERVICE, SUCCESS, INVENTORY_SUCCESS },

            { INVENTORY_SERVICE, ROLLBACK_PENDING, INVENTORY_FAIL },
            { INVENTORY_SERVICE, FAIL, FINISH_FAIL },
            { INVENTORY_SERVICE, SUCCESS, FINISH_SUCCESS }
    };

    public static final int EVENT_SOURCE_INDEX = 0;
    public static final int SAGA_STATUS_INDEX = 1;
    public static final int TOPIC_INDEX = 2;
}