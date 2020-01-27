package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class EnrollmentResponse10_50 {

    public static org.hl7.fhir.dstu2.model.EnrollmentResponse convertEnrollmentResponse(org.hl7.fhir.r5.model.EnrollmentResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.EnrollmentResponse tgt = new org.hl7.fhir.dstu2.model.EnrollmentResponse();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        tgt.setDisposition(src.getDisposition());
        tgt.setCreated(src.getCreated());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.EnrollmentResponse convertEnrollmentResponse(org.hl7.fhir.dstu2.model.EnrollmentResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.EnrollmentResponse tgt = new org.hl7.fhir.r5.model.EnrollmentResponse();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        tgt.setRequest(VersionConvertor_10_50.convertReference(src.getRequest()));
        tgt.setDisposition(src.getDisposition());
        tgt.setCreated(src.getCreated());
        tgt.setOrganization(VersionConvertor_10_50.convertReference(src.getOrganization()));
        tgt.setRequestProvider(VersionConvertor_10_50.convertReference(src.getRequestProvider()));
        return tgt;
    }
}