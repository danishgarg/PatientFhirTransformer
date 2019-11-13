package com.athenahealth.quality.cdc.infrastructure.messaging.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChartTable {
    @JsonProperty("ID")
    private String ID;
    @JsonProperty("CHARTSHARINGGROUPID")
    private String CHARTSHARINGGROUPID;
    @JsonProperty("ENTERPRISEID")
    private String ENTERPRISEID;
    @JsonProperty("DELETED")
    private String DELETED;
    @JsonProperty("DELETEDBY")
    private String DELETEDBY;
    @JsonProperty("CREATED")
    private String CREATED;
    @JsonProperty("CREATEDBY")
    private String CREATEDBY;
    @JsonProperty("LASTMODIFIED")
    private String LASTMODIFIED;
    @JsonProperty("LASTMODIFIEDBY")
    private String LASTMODIFIEDBY;
    @JsonProperty("NEWCHARTID")
    private String NEWCHARTID;
}