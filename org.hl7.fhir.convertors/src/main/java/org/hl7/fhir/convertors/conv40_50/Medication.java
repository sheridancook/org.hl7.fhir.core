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


public class Medication extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.Medication convertMedication(org.hl7.fhir.r4.model.Medication src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Medication tgt = new org.hl7.fhir.r5.model.Medication();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasStatus())
      tgt.setStatus(convertMedicationStatus(src.getStatus()));
    if (src.hasManufacturer())
      tgt.setManufacturer(convertReference(src.getManufacturer()));
    if (src.hasForm())
      tgt.setDoseForm(convertCodeableConcept(src.getForm()));
    if (src.hasAmount())
      tgt.setAmount(convertRatio(src.getAmount()));
    for (org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent t : src.getIngredient())
      tgt.addIngredient(convertMedicationIngredientComponent(t));
    if (src.hasBatch())
      tgt.setBatch(convertMedicationBatchComponent(src.getBatch()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Medication convertMedication(org.hl7.fhir.r5.model.Medication src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Medication tgt = new org.hl7.fhir.r4.model.Medication();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasStatus())
      tgt.setStatus(convertMedicationStatus(src.getStatus()));
    if (src.hasManufacturer())
      tgt.setManufacturer(convertReference(src.getManufacturer()));
    if (src.hasDoseForm())
      tgt.setForm(convertCodeableConcept(src.getDoseForm()));
    if (src.hasAmount())
      tgt.setAmount(convertRatio(src.getAmount()));
    for (org.hl7.fhir.r5.model.Medication.MedicationIngredientComponent t : src.getIngredient())
      tgt.addIngredient(convertMedicationIngredientComponent(t));
    if (src.hasBatch())
      tgt.setBatch(convertMedicationBatchComponent(src.getBatch()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Medication.MedicationStatusCodes convertMedicationStatus(org.hl7.fhir.r4.model.Medication.MedicationStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r5.model.Medication.MedicationStatusCodes.ACTIVE;
    case INACTIVE: return org.hl7.fhir.r5.model.Medication.MedicationStatusCodes.INACTIVE;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.Medication.MedicationStatusCodes.ENTEREDINERROR;
    default: return org.hl7.fhir.r5.model.Medication.MedicationStatusCodes.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Medication.MedicationStatus convertMedicationStatus(org.hl7.fhir.r5.model.Medication.MedicationStatusCodes src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r4.model.Medication.MedicationStatus.ACTIVE;
    case INACTIVE: return org.hl7.fhir.r4.model.Medication.MedicationStatus.INACTIVE;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.Medication.MedicationStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r4.model.Medication.MedicationStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Medication.MedicationIngredientComponent convertMedicationIngredientComponent(org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Medication.MedicationIngredientComponent tgt = new org.hl7.fhir.r5.model.Medication.MedicationIngredientComponent();
    copyElement(src, tgt);
    if (src.hasItem())
      tgt.setItem(convertType(src.getItem()));
    if (src.hasIsActive())
      tgt.setIsActiveElement(convertBoolean(src.getIsActiveElement()));
    if (src.hasStrength())
      tgt.setStrength(convertRatio(src.getStrength()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent convertMedicationIngredientComponent(org.hl7.fhir.r5.model.Medication.MedicationIngredientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent tgt = new org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent();
    copyElement(src, tgt);
    if (src.hasItem())
      tgt.setItem(convertType(src.getItem()));
    if (src.hasIsActive())
      tgt.setIsActiveElement(convertBoolean(src.getIsActiveElement()));
    if (src.hasStrengthRatio())
      tgt.setStrength(convertRatio(src.getStrengthRatio()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Medication.MedicationBatchComponent convertMedicationBatchComponent(org.hl7.fhir.r4.model.Medication.MedicationBatchComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Medication.MedicationBatchComponent tgt = new org.hl7.fhir.r5.model.Medication.MedicationBatchComponent();
    copyElement(src, tgt);
    if (src.hasLotNumber())
      tgt.setLotNumberElement(convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(convertDateTime(src.getExpirationDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Medication.MedicationBatchComponent convertMedicationBatchComponent(org.hl7.fhir.r5.model.Medication.MedicationBatchComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Medication.MedicationBatchComponent tgt = new org.hl7.fhir.r4.model.Medication.MedicationBatchComponent();
    copyElement(src, tgt);
    if (src.hasLotNumber())
      tgt.setLotNumberElement(convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(convertDateTime(src.getExpirationDateElement()));
    return tgt;
  }


}
