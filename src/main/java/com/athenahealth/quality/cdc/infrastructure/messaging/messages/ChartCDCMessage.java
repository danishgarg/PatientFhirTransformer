package com.athenahealth.quality.cdc.infrastructure.messaging.messages;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChartCDCMessage {
    private String table;
    private String op_type;
    private String op_ts;
    private String current_ts;
    private String pos;
    private String[] primary_keys;
    private ChartTable before;
    private ChartTable after;
}