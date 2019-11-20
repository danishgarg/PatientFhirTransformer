package com.athenahealth.quality.cdc.infrastructure.messaging.configuration;

import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.cloud.stream.annotation.Input;
// import org.springframework.cloud.stream.annotation.Output;
// import org.springframework.messaging.MessageChannel;
import org.springframework.cloud.stream.annotation.Output;

public interface KafkaChannels {
	String CLIENT_CDC_INPUT = "client-cdc-input";
	String CHART_CDC_INPUT = "chart-cdc-input";
	String CLIENT_CDC_SNAPSHOT_OUT = "client-cdc-snapshot-out";
	String CHART_CDC_SNAPSHOT_OUT = "chart-cdc-snapshot-out";
	String PATIENT_CANONICAL_SNAPSHOT_OUT_CHART_JOIN = "patient-canonical-snapshot-out-chart-join";
	String PATIENT_CANONICAL_SNAPSHOT_OUT_CLIENT_JOIN = "patient-canonical-snapshot-out-client-join";
	String PATIENT_CANONICAL_SNAPSHOT_IN_TABLE_CHART_JOIN = "patient-canonical-snapshot-in-chart-join";
	String PATIENT_CANONICAL_SNAPSHOT_IN_TABLE_CLIENT_JOIN = "patient-canonical-snapshot-in-client-join";
	String PATIENT_CANONICAL_SNAPSHOT_IN_STREAM = "patient-canonical-snapshot-in-stream";
	String CLIENT_CDC_SNAPSHOT_IN = "client-cdc-snapshot-in";
	String CHART_CDC_SNAPSHOT_IN = "chart-cdc-snapshot-in";
	String PATIENT_FHIR_OUT = "patient-fhir-out";

	@Input(KafkaChannels.CLIENT_CDC_INPUT)
	KStream<?,?> clientCDCInput();

	@Input(KafkaChannels.CHART_CDC_INPUT)
	KStream<?,?> chartCDCInput();

	@Input (KafkaChannels.CLIENT_CDC_SNAPSHOT_IN)
	KStream<?,?> clientSnapshotIn();

	@Input (KafkaChannels.CHART_CDC_SNAPSHOT_IN)
	KStream<?,?> chartSnapshotIn();

	@Output(KafkaChannels.CLIENT_CDC_SNAPSHOT_OUT)
	KStream<?,?> clientCDCSnapshotOut();

	@Output(KafkaChannels.CHART_CDC_SNAPSHOT_OUT)
	KStream<?,?> chartCDCSnapshotOut();

	@Input(KafkaChannels.PATIENT_CANONICAL_SNAPSHOT_IN_TABLE_CHART_JOIN)
	KTable<?,?> patientCanonicalSnapshotChartJoinIn();

	@Input(KafkaChannels.PATIENT_CANONICAL_SNAPSHOT_IN_TABLE_CLIENT_JOIN)
	KTable<?,?> patientCanonicalSnapshotClientJoinIn();

	@Input(KafkaChannels.PATIENT_CANONICAL_SNAPSHOT_IN_STREAM)
	KStream<?,?> patientCanonicalSnapshotInStream();

	@Output(KafkaChannels.PATIENT_CANONICAL_SNAPSHOT_OUT_CHART_JOIN)
	KStream<?,?> patientCanonicalSnapshotChartJoinOut();

	@Output(KafkaChannels.PATIENT_CANONICAL_SNAPSHOT_OUT_CLIENT_JOIN)
	KStream<?,?> patientCanonicalSnapshotClientJoinOut();

	@Output(KafkaChannels.PATIENT_FHIR_OUT)
	KStream<?,?> patientFhirOut();

}