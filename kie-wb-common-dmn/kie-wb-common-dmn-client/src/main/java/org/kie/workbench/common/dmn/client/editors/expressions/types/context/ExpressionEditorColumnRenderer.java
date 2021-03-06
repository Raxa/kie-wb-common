/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.dmn.client.editors.expressions.types.context;

import java.util.Optional;

import com.ait.lienzo.client.core.shape.Group;
import com.google.gwt.core.client.GWT;
import org.kie.workbench.common.dmn.client.widgets.grid.BaseExpressionGrid;
import org.kie.workbench.common.dmn.client.widgets.grid.model.DMNGridColumn;
import org.uberfire.ext.wires.core.grids.client.model.GridCell;
import org.uberfire.ext.wires.core.grids.client.widget.context.GridBodyCellRenderContext;
import org.uberfire.ext.wires.core.grids.client.widget.grid.renderers.columns.impl.BaseGridColumnRenderer;

public class ExpressionEditorColumnRenderer extends BaseGridColumnRenderer<Optional<BaseExpressionGrid>> {

    @Override
    public Group renderCell(final GridCell<Optional<BaseExpressionGrid>> cell,
                            final GridBodyCellRenderContext context) {
        if (cell == null || cell.getValue() == null) {
            return null;
        }

        final Group g = GWT.create(Group.class);
        if (cell.getValue() != null && cell.getValue() instanceof ExpressionCellValue) {
            final ExpressionCellValue ecv = (ExpressionCellValue) cell.getValue();
            ecv.getValue().ifPresent(editor -> g.add(editor.setX(DMNGridColumn.PADDING).setY(DMNGridColumn.PADDING)));
        }

        return g;
    }
}
