// package com.athenahealth.quality.cdc.infrastructure.web;

// import java.util.ArrayList;
// import java.util.List;

// import com.athenahealth.quality.cdc.domain.PatientEnterprise;

// import org.apache.kafka.streams.state.QueryableStoreTypes;
// import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;


// @RestController
// @RequestMapping("/patients")
// public class PatientEnterpriseController {
//     private InteractiveQueryService interactiveQueryService;
//     private ReadOnlyKeyValueStore<String, PatientEnterprise> patientStore;
//     @Autowired
//     public PatientEnterpriseController(InteractiveQueryService interactiveQueryService) {
//         this.interactiveQueryService = interactiveQueryService;
//     }

//     @GetMapping
//     public List<PatientEnterprise> getMethodName() {
//         List<PatientEnterprise> patients = new ArrayList<>();
//         if (this.patientStore == null) {
//             this.patientStore = this.interactiveQueryService.getQueryableStore("Patients",
//                     QueryableStoreTypes.keyValueStore());
//         }
//         this.patientStore.all().forEachRemaining((keyValue) -> patients.add(keyValue.value));
//         return patients;
//     }
    
// }