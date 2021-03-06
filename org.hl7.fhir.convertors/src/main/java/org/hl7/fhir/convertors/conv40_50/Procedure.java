package org.hl7.fhir.convertors.conv40_50;

/*-
 * #%L
 * org.hl7.fhir.convertors
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.convertors.VersionConvertor_40_50;


/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/

// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0


public class Procedure extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.Procedure convertProcedure(org.hl7.fhir.r4.model.Procedure src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Procedure tgt = new org.hl7.fhir.r5.model.Procedure();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(convertCanonical(t));
    for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(convertUri(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf())
      tgt.addPartOf(convertReference(t));
    if (src.hasStatus())
      tgt.setStatus(convertProcedureStatus(src.getStatus()));
    if (src.hasStatusReason())
      tgt.setStatusReason(convertCodeableConcept(src.getStatusReason()));
    if (src.hasCategory())
      tgt.addCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    if (src.hasPerformed())
      tgt.setOccurrence(convertType(src.getPerformed()));
    if (src.hasRecorder())
      tgt.setRecorder(convertReference(src.getRecorder()));
    if (src.hasAsserter())
      tgt.setReported(convertReference(src.getAsserter()));
    for (org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertProcedurePerformerComponent(t));
    if (src.hasLocation())
      tgt.setLocation(convertReference(src.getLocation()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReason(convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(convertCodeableConcept(t));
    if (src.hasOutcome())
      tgt.setOutcome(convertCodeableConcept(src.getOutcome()));
    for (org.hl7.fhir.r4.model.Reference t : src.getReport())
      tgt.addReport(convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getComplication())
      tgt.addComplication(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getComplicationDetail())
      tgt.addComplicationDetail(convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getFollowUp())
      tgt.addFollowUp(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r4.model.Procedure.ProcedureFocalDeviceComponent t : src.getFocalDevice())
      tgt.addFocalDevice(convertProcedureFocalDeviceComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getUsedReference())
      tgt.addUsed(convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getUsedCode())
      tgt.addUsed(convertCodeableConceptToCodeableReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Procedure convertProcedure(org.hl7.fhir.r5.model.Procedure src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Procedure tgt = new org.hl7.fhir.r4.model.Procedure();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(convertCanonical(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(convertUri(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf())
      tgt.addPartOf(convertReference(t));
    if (src.hasStatus())
      tgt.setStatus(convertProcedureStatus(src.getStatus()));
    if (src.hasStatusReason())
      tgt.setStatusReason(convertCodeableConcept(src.getStatusReason()));
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setPerformed(convertType(src.getOccurrence()));
    if (src.hasRecorder())
      tgt.setRecorder(convertReference(src.getRecorder()));
    if (src.hasReportedReference())
      tgt.setAsserter(convertReference(src.getReportedReference()));
    for (org.hl7.fhir.r5.model.Procedure.ProcedurePerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertProcedurePerformerComponent(t));
    if (src.hasLocation())
      tgt.setLocation(convertReference(src.getLocation()));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
      tgt.addReasonCode(convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
      tgt.addReasonReference(convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(convertCodeableConcept(t));
    if (src.hasOutcome())
      tgt.setOutcome(convertCodeableConcept(src.getOutcome()));
    for (org.hl7.fhir.r5.model.Reference t : src.getReport())
      tgt.addReport(convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getComplication())
      tgt.addComplication(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getComplicationDetail())
      tgt.addComplicationDetail(convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getFollowUp())
      tgt.addFollowUp(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r5.model.Procedure.ProcedureFocalDeviceComponent t : src.getFocalDevice())
      tgt.addFocalDevice(convertProcedureFocalDeviceComponent(t));
    for (CodeableReference t : src.getUsed())
      if (t.hasReference())
      tgt.addUsedReference(convertReference(t.getReference()));
    for (CodeableReference t : src.getUsed())
      if (t.hasConcept())
      tgt.addUsedCode(convertCodeableConcept(t.getConcept()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Enumerations.EventStatus convertProcedureStatus(org.hl7.fhir.r4.model.Procedure.ProcedureStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PREPARATION: return org.hl7.fhir.r5.model.Enumerations.EventStatus.PREPARATION;
    case INPROGRESS: return org.hl7.fhir.r5.model.Enumerations.EventStatus.INPROGRESS;
    case NOTDONE: return org.hl7.fhir.r5.model.Enumerations.EventStatus.NOTDONE;
    case ONHOLD: return org.hl7.fhir.r5.model.Enumerations.EventStatus.ONHOLD;
    case STOPPED: return org.hl7.fhir.r5.model.Enumerations.EventStatus.STOPPED;
    case COMPLETED: return org.hl7.fhir.r5.model.Enumerations.EventStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.Enumerations.EventStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r5.model.Enumerations.EventStatus.UNKNOWN;
    default: return org.hl7.fhir.r5.model.Enumerations.EventStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Procedure.ProcedureStatus convertProcedureStatus(org.hl7.fhir.r5.model.Enumerations.EventStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PREPARATION: return org.hl7.fhir.r4.model.Procedure.ProcedureStatus.PREPARATION;
    case INPROGRESS: return org.hl7.fhir.r4.model.Procedure.ProcedureStatus.INPROGRESS;
    case NOTDONE: return org.hl7.fhir.r4.model.Procedure.ProcedureStatus.NOTDONE;
    case ONHOLD: return org.hl7.fhir.r4.model.Procedure.ProcedureStatus.ONHOLD;
    case STOPPED: return org.hl7.fhir.r4.model.Procedure.ProcedureStatus.STOPPED;
    case COMPLETED: return org.hl7.fhir.r4.model.Procedure.ProcedureStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.Procedure.ProcedureStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r4.model.Procedure.ProcedureStatus.UNKNOWN;
    default: return org.hl7.fhir.r4.model.Procedure.ProcedureStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Procedure.ProcedurePerformerComponent convertProcedurePerformerComponent(org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Procedure.ProcedurePerformerComponent tgt = new org.hl7.fhir.r5.model.Procedure.ProcedurePerformerComponent();
    copyElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(convertReference(src.getActor()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(convertReference(src.getOnBehalfOf()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent convertProcedurePerformerComponent(org.hl7.fhir.r5.model.Procedure.ProcedurePerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent tgt = new org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent();
    copyElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(convertReference(src.getActor()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(convertReference(src.getOnBehalfOf()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Procedure.ProcedureFocalDeviceComponent convertProcedureFocalDeviceComponent(org.hl7.fhir.r4.model.Procedure.ProcedureFocalDeviceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Procedure.ProcedureFocalDeviceComponent tgt = new org.hl7.fhir.r5.model.Procedure.ProcedureFocalDeviceComponent();
    copyElement(src, tgt);
    if (src.hasAction())
      tgt.setAction(convertCodeableConcept(src.getAction()));
    if (src.hasManipulated())
      tgt.setManipulated(convertReference(src.getManipulated()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Procedure.ProcedureFocalDeviceComponent convertProcedureFocalDeviceComponent(org.hl7.fhir.r5.model.Procedure.ProcedureFocalDeviceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Procedure.ProcedureFocalDeviceComponent tgt = new org.hl7.fhir.r4.model.Procedure.ProcedureFocalDeviceComponent();
    copyElement(src, tgt);
    if (src.hasAction())
      tgt.setAction(convertCodeableConcept(src.getAction()));
    if (src.hasManipulated())
      tgt.setManipulated(convertReference(src.getManipulated()));
    return tgt;
  }


}
