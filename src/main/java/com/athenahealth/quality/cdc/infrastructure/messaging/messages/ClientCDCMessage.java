package com.athenahealth.quality.cdc.infrastructure.messaging.messages;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientCDCMessage {
    private String table;
    private String op_type;
    private String op_ts;
    private String current_ts;
    private String pos;
    private String[] primary_keys;
    // "tokens": {
    //     "txid": "6.4.7011",
    //     "csn": "13576496"
    // },
    private ClientTable before;
    private ClientTable after;
}