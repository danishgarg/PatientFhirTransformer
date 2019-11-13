package com.athenahealth.quality.cdc.infrastructure.messaging.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientTable {
    @JsonProperty("ID")
    private String ID;
    @JsonProperty("CREATED")
    private String CREATED;
    @JsonProperty("CREATEDBY")
    private String CREATEDBY;
    @JsonProperty("LASTNAME")
    private String LASTNAME;
    @JsonProperty("FIRSTNAME")
    private String FIRSTNAME;
    @JsonProperty("REGISTRATIONDATE")
    private String REGISTRATIONDATE;
    @JsonProperty("MIDDLEINITIAL")
    private String MIDDLEINITIAL;
    // private String PREVIOUSLASTNAME;
    @JsonProperty("ADDRESS1")
    private String ADDRESS1;
    @JsonProperty("ADDRESS2")
    private String ADDRESS2;
    @JsonProperty("CITY")
    private String CITY;
    @JsonProperty("STATE")
    private String STATE;
    @JsonProperty("ZIP")
    private String ZIP;
    @JsonProperty("HOMEPHONE")
    private String HOMEPHONE;
    @JsonProperty("TRANSLATEDHOMEPHONEINDEX")
    private String TRANSLATEDHOMEPHONEINDEX;
    @JsonProperty("WORKPHONE")
    private String WORKPHONE;
    @JsonProperty("TRANSLATEDWORKPHONEINDEX")
    private String TRANSLATEDWORKPHONEINDEX;
    @JsonProperty("OTHERPHONETYPE")
    private String OTHERPHONETYPE;
    @JsonProperty("OTHERPHONE")
    private String OTHERPHONE;
    @JsonProperty("DOB")
    private String DOB;
    @JsonProperty("SSN")
    private String SSN;
    @JsonProperty("SEX")
    private String SEX;
    @JsonProperty("REGISTRATIONDEPARTMENTID")
    private String REGISTRATIONDEPARTMENTID;
    @JsonProperty("CURRENTDEPARTMENTID")
    private String CURRENTDEPARTMENTID;
    @JsonProperty("PRIMARYPROVIDERID")
    private String PRIMARYPROVIDERID;

    // private String MARITALSTATUSID;
    // private String STUDENTSTATUSID;
    // private String EMPLOYMENTSTATUSID;
    // private String DECEASEDDATE;
    // private String EMPLOYERNAME;
    // private int REFERRALSOURCEID;
    // private String REFERRALSOURCEOTHER;
    @JsonProperty("ETHNICITYID")
    private String ETHNICITYID;
    @JsonProperty("RACEID")
    private String RACEID;
    // private int PRIMARYLANGUAGEID;
    // private String PRIMARYLANGUAGEOTHER;
    // private String TRANSFERDATE;
    // private String STATUS;
    // private String NOTES;
    // private String CONTACTNAME;
    // private String CONTACTRELATIONSHIP;
    // private String CONTACTPHONE1;
    // private String CONTACTPHONE2;
    // private String NEXTKINNAME;
    // private String NEXTKINRELATIONSHIP;
    // private String NEXTKINPHONE;
    // private String RPFIRSTNAME;
    // private String RPLASTNAME;
    // private String RPMIDDLEINITIAL;
    // private String RPDOB;
    // private String GUARDIANFIRSTNAME;
    // private String GUARDIANLASTNAME;
    // private String GUARDIANMIDDLEINITIAL;
    // private String REFERRINGPROVIDERID;
    // private String EMAIL;
    // private String SUPPRESSSTATEMENT;
    // private String ONLINESTATEMENTONLYYN;
    // private String NEXTSTATEMENTDATE;
    // private String STATEMENTNOTE;
    // private double BALANCEFORWARDAMOUNT;
    // private double UNAPPLIEDAMOUNT;
    // private String EMPLOYERCITY;
    // private String EMPLOYERADDRESS;
    // private String EMPLOYERSTATE;
    // private String EMPLOYERZIP;
    // private String EMPLOYERPHONE;
    // private String OCCUPATION;
    // private String DIAGNOSIS1;
    // private String DIAGNOSIS2;
    // private String DIAGNOSIS3;
    // private String LASTMODIFIED;
    // private String LASTMODIFIEDBY;
    // private String FIRSTVISITDATE;
    // private double CREDITBALANCE;
    // private int NEWPATIENTID;
    // private double OUTSTANDINGP;
    // private String CLAIMSTATUSP;
    // private String HOLDSTATEMENTREASON;
    // private String OTHERRECORDNUMBER;
    // private String OVERDUEDATE;
    // private int FAMILYCLIENTID;
    // private String IDOVERRIDDENYN;
    // private String IMPORTUNIQUEID;
    // private String IMPORTCOL1;
    // private String IMPORTCOL2;
    // private int EMPLOYERID;
    @JsonProperty("ENTERPRISEID")
    private String ENTERPRISEID;
    // private String RPADDRESS;
    // private String RPCITY;
    // private String RPSTATE;
    // private String RPZIP;
    // private int ORIGINALPRACTICEID;
    // private int CHARTHOME;
    // private int CHARTLOCATION;
    // private String CHARTHOLDER;
    // private int COUNTRYID;
    // private int RPCOUNTRYID;
    // private String PRIVACYNOTICEGIVENFLAG;
    // private String PRIVACYNOTICEGIVENDATE;
    // private String PRIVACYNOTICENOTGIVENREASON;
    // private String PRIVACYNOTICENOTGIVENNOTE;
    // private String PRIVACYNOTICEGIVENDEPARTMENTID;
    // private String PRIVACYNOTICEGIVENBY;
    // private String PATIENTSIGNATUREONFILEFLAG;
    // private String PATIENTSIGNATUREEFFECTIVEDATE;
    // private String PATIENTSIGNATUREEXPIRATIONDATE;
    // private String INSUREDSIGNATUREONFILEFLAG;
    // private String INSUREDSIGNATUREEFFECTIVEDATE;
    // private String INSUREDSIGNATUREEXPIRATIONDATE;
    // private String SIGNATURESOURCECODE;
    // private String RESTRICTRECORDYN;
    // private String CONFIDENTIALCOMMUNICATIONYN;
    // private String BLOCKPATIENTYN;
    // private String RESTRICTREPORTINGYN;
    // private String MEDICATIONHISTORYCONSENTBY;
    // private String MEDICATIONHISTORYCONSENTDATE;
    // private String MEDICATIONHISTORYCONSENTYN;
    // private String PROVIDERGROUPID;
    // private String NAMESUFFIX;
    // private String HIPAAID;
    // private String HOMEBOUNDYN;
    // private String RPNAMESUFFIX;
    // private String RPADDRESS2;
    // private String GUARDIANNAMESUFFIX;
    // private String MOBILEPHONE;
    // private String TRANSLATEDMOBILEPHONEINDEX;
    // private String MOBILECARRIERID;
    // private String RPSSN;
    // private String RPPHONE;
    // private String RPEMPLOYERID;
    // private String SAMEADDRESSFLAG;
    // private String RELATIONSHIPTOPATIENTID;
    // private String STATEMENTNOTEEFFECTIVEDATE;
    // private String STATEMENTNOTEEXPIRATIONDATE;
    // private String DEFAULTPRESCRIPTIONPROVIDERID;
    // private String LICENSESTATEID;
    // private String LICENSEEXPIRATIONDATE;
    // private String PINCODE;
    // private String ENCRYPTEDPINCODE;
    // private String DONOTCALLYN;
    // private String PORTALTERMSONFILEFLAG;
    // private String PORTALTERMSEFFECTIVEDATE;
    // private String PORTALTERMSEXPIRATIONDATE;
    // private String PORTALREGISTRATIONDATE;
    // private String CONTACTPREFERENCE;
    // private String DEFAULTLABPROVIDERID;
    // private String EMAILEXISTSYN;
    // private String NOPORTALYN;
    // private String HIESUBMISSIONYN;
    // private String HIESUBMISSIONDATE;
    // private String HIESUBMISSIONBY;
    // private String HIERETRIEVALYN;
    // private String HIERETRIEVALDATE;
    // private String HIERETRIEVALBY;
    // private String SMSOPTINDATE;
    // private String LASTEMAIL;
    // private String RPEMAIL;
    // private String RPEMAILEXISTSYN;
    // private String FAMILYSIZE;
    // private String YEARLYINCOME;
    // private String INCOMEPERPAYPERIOD;
    // private String PAYPERIOD;
    // private String PORTALACCESSYN;
    // private String ONLINESTATEMENTONLYDATE;
    // private String NOPORTALADOPTIONEMAILYN;
    // private String SHOWNEWFEATUREPORTALYN;
    // private String PHONEMESSAGEOKYN;
    // private String CONTACTNAME2;
    // private String CONTACTTIMEID;
    // private String DIRECTORYYN;
    // private String ORGANDONORYN;
    // private String ALTCONTACTNAME;
    // private String ALTCONTACTPHONE;
    // private String RELIGIONID;
    // private String CHURCH;
    // private String CARESUMMARYDELIVERYPREFERENCE;
    // private String DIRECTEMAIL;
    // private String OCCUPATIONID;
    // private String INDUSTRYID;
    // private String INDUSTRY;
    // private String SELFPAYRESTRICTIONYN;
    // private String HASMOBILEYN;
    // private String EMAILCONFIRMED;
    // private String LICENSENUMBER;
    // private String PREFERREDNAME;
    // private String CONSENTTOCALLFLAG;
    // private String ENCRYPTEDPINCODESALT;
    // private String QUICKPAYTERMSONFILEFLAG;
    // private String QUICKPAYTERMSEFFECTIVEDATE;
    // private String QUICKPAYTERMSEXPIRATIONDATE;
    // private String CONSENTTOCALLFLAGEFFECTIVEDATE;
    // private String PLCLASTNAME;
    // private String PLCFIRSTNAME;
    // private String PLCMIDDLEINITIAL;
    // private String PLCPREVIOUSLASTNAME;
    // private String PLCNAMESUFFIX;
    // private String PLCPREFERREDNAME;
    // private String PLCADDRESS1;
    // private String PLCADDRESS2;
    // private String PLCCITY;
    // private String DEFAULTIMAGINGPROVIDERID;
    // private String TESTPATIENTYN;
    // private String SMSPROMPTEDDATE;
    // private String CONSENTTOTEXTYN;
    // private String PORTALACCESSPROVIDED;
    // private String UNCONFIRMEDFAMILYSIZE;
    // private String UNCONFFAMILYSIZEDECLINEDYN;
    // private String UNCONFIRMEDYEARLYINCOME;
    // private String UNCONFIRMEDINCOMEPERPAYPERIOD;
    // private String UNCONFIRMEDPAYPERIOD;
    // private String UNCONFIRMEDINCOMEDECLINEDYN;
    // private String UNCONFIRMEDFEDERALPOVERTYLEVEL;
    // private String AGRIWORKER;
    // private String AGRIWORKERTYPES;
    // private String HOMELESS;
    // private String HOMELESSTYPES;
    // private String VETERANSTATUS;
    // private String SCHOOLBASED;
    // private String PUBLICHOUSING;
    // private String STREAMLINEDTESTPATIENTYN;
    // private String STREAMLINEDTESTUSERNAME;
    // private String EDUCATIONLEVELID;
    // private String EMPLOYERCOUNTRYID;
    // private String UNCONFINCOMERANGEDECLINEDYN;
    // private String SEXUALORIENTATION;
    // private String GENDERIDENTITY;
    // private String ALTFIRSTNAME;
    // private String PLCALTFIRSTNAME;
    // private String PREFERREDPRONOUNS;
    // private String ASSIGNEDSEXATBIRTH;
    // private String NORPFIRSTNAMEYN;
    // private String NORPLASTNAMEYN;
    // private String SEXUNKNOWNYN;
    // private String SEXUALORIENTATIONOTHER;
    // private String GENDERIDENTITYOTHER;
    // private String SEXUALORIENTATIONID;
    // private String GENDERIDENTITYID;
    // private String JOHNDOEYN;
    // private String MOTHERSMAIDENNAME;
}