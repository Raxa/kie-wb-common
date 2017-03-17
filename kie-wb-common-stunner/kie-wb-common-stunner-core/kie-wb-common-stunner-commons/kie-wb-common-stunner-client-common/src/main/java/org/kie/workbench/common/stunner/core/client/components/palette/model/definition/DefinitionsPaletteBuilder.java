/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.stunner.core.client.components.palette.model.definition;

import java.util.List;

import org.kie.workbench.common.stunner.core.client.components.palette.model.PaletteDefinitionBuilder;
import org.kie.workbench.common.stunner.core.client.service.ClientRuntimeError;

public interface DefinitionsPaletteBuilder extends PaletteDefinitionBuilder<Iterable<String>, DefinitionsPalette, ClientRuntimeError> {

    void buildFromDefinitionSet(final String defintionSetId,
                                final Callback<DefinitionsPalette, ClientRuntimeError> callback);

    void buildFromPaletteItems(final List<DefinitionPaletteItem> definitionPaletteItems,
                               final Callback<DefinitionsPalette, ClientRuntimeError> callback);
}