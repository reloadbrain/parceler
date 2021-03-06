/**
 * Copyright 2011-2015 John Ericksen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.parceler.internal;

import org.androidtransfuse.adapter.ASTMethod;
import org.androidtransfuse.adapter.ASTType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author John Ericksen
 */
public class ParcelableDescriptor {

    private ConstructorReference constructorPair;
    private final List<ReferencePair<FieldReference>> fieldPairs = new ArrayList<ReferencePair<FieldReference>>();
    private final List<ReferencePair<MethodReference>> methodPairs = new ArrayList<ReferencePair<MethodReference>>();
    private final ASTType parcelConverterType;
    private List<ASTType> extraImplementations = new ArrayList<ASTType>();
    private List<ASTMethod> wrapCallbacks = new ArrayList<ASTMethod>();
    private List<ASTMethod> unwrapCallbacks = new ArrayList<ASTMethod>();
    private final Integer describeContents;

    public ParcelableDescriptor() {
        this(null, null);
    }

    public ParcelableDescriptor(ASTType[] extraImplementations, Integer describeContents) {
        this(extraImplementations, null, describeContents);
    }

    public ParcelableDescriptor(ASTType[] extraImplementations, ASTType parcelConverterType, Integer describeContents) {
        this.parcelConverterType = parcelConverterType;
        this.describeContents = describeContents;
        if(extraImplementations != null) {
            this.extraImplementations.addAll(Arrays.asList(extraImplementations));
        }
    }

    public List<ReferencePair<FieldReference>> getFieldPairs() {
        return fieldPairs;
    }

    public List<ReferencePair<MethodReference>> getMethodPairs() {
        return methodPairs;
    }

    public ASTType getParcelConverterType() {
        return parcelConverterType;
    }

    public void setConstructorPair(ConstructorReference constructorPair) {
        this.constructorPair = constructorPair;
    }

    public ConstructorReference getConstructorPair() {
        return constructorPair;
    }

    public List<ASTType> getExtraImplementations() {
        return extraImplementations;
    }

    public List<ASTMethod> getWrapCallbacks() {
        return wrapCallbacks;
    }

    public List<ASTMethod> getUnwrapCallbacks() {
        return unwrapCallbacks;
    }

    public Integer getDescribeContents() {
        return describeContents;
    }
}
