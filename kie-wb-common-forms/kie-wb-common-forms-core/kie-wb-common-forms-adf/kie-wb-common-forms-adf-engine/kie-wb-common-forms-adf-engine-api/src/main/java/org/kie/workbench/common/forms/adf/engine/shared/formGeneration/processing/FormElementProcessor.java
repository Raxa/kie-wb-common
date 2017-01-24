/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.forms.adf.engine.shared.formGeneration.processing;

import org.kie.workbench.common.forms.adf.engine.shared.formGeneration.FormGenerationContext;
import org.kie.workbench.common.forms.adf.service.definitions.elements.FormElement;
import org.uberfire.ext.layout.editor.api.editor.LayoutComponent;

/**
 * Component able to process a {@link FormElement} and generate a {@link LayoutComponent} to display it on the form.
 */
public interface FormElementProcessor<TYPE extends FormElement> {

    /**
     * Retrieves the type of the {@link FormElement} supported by the processor
     */
    Class<TYPE> getSupportedElementType();

    /**
     * Generates a {@link LayoutComponent for the given {@link FormElement}}
     */
    LayoutComponent processFormElement(TYPE element,
                                       FormGenerationContext context);
}
