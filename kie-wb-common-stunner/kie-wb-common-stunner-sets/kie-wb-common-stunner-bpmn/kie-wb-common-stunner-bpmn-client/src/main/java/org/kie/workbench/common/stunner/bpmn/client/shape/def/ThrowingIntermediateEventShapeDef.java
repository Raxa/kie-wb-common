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
package org.kie.workbench.common.stunner.bpmn.client.shape.def;

import java.util.HashMap;
import java.util.Map;

import org.kie.workbench.common.stunner.bpmn.client.resources.BPMNSVGGlyphFactory;
import org.kie.workbench.common.stunner.bpmn.client.resources.BPMNSVGViewFactory;
import org.kie.workbench.common.stunner.bpmn.definition.BaseThrowingIntermediateEvent;
import org.kie.workbench.common.stunner.bpmn.definition.IntermediateMessageEventThrowing;
import org.kie.workbench.common.stunner.bpmn.definition.IntermediateSignalEventThrowing;
import org.kie.workbench.common.stunner.core.client.shape.SvgDataUriGlyph;
import org.kie.workbench.common.stunner.core.client.shape.view.HasTitle;
import org.kie.workbench.common.stunner.core.client.shape.view.handler.FontHandler;
import org.kie.workbench.common.stunner.core.client.shape.view.handler.SizeHandler;
import org.kie.workbench.common.stunner.core.definition.shape.Glyph;
import org.kie.workbench.common.stunner.svg.client.shape.factory.SVGShapeViewResources;
import org.kie.workbench.common.stunner.svg.client.shape.view.SVGShapeView;

public class ThrowingIntermediateEventShapeDef
        implements BPMNSvgShapeDef<BaseThrowingIntermediateEvent> {

    public static final SVGShapeViewResources<BaseThrowingIntermediateEvent, BPMNSVGViewFactory> VIEW_RESOURCES =
            new SVGShapeViewResources<BaseThrowingIntermediateEvent, BPMNSVGViewFactory>()
                    .put(IntermediateSignalEventThrowing.class, BPMNSVGViewFactory::intermediateSignalThrowingEvent)
                    .put(IntermediateMessageEventThrowing.class, BPMNSVGViewFactory::intermediateMessageThrowingEvent);


    public static final Map<Class<? extends BaseThrowingIntermediateEvent>, SvgDataUriGlyph> GLYPHS =
            new HashMap<Class<? extends BaseThrowingIntermediateEvent>, SvgDataUriGlyph>() {{
                put(IntermediateSignalEventThrowing.class, BPMNSVGGlyphFactory.INTERMEDIATE_SIGNAL_EVENT_GLYPH);
                put(IntermediateMessageEventThrowing.class, BPMNSVGGlyphFactory.INTERMEDIATE_MESSAGE_EVENT_GLYPH);
            }};

    @Override
    public FontHandler<BaseThrowingIntermediateEvent, SVGShapeView> newFontHandler() {
        return newFontHandlerBuilder()
                .positon(event -> HasTitle.Position.BOTTOM)
                .build();
    }

    @Override
    public SizeHandler<BaseThrowingIntermediateEvent, SVGShapeView> newSizeHandler() {
        return newSizeHandlerBuilder()
                .radius(task -> task.getDimensionsSet().getRadius().getValue())
                .build();
    }

    @Override
    public SVGShapeView<?> newViewInstance(final BPMNSVGViewFactory factory,
                                           final BaseThrowingIntermediateEvent intermediateTimerEvent) {
        return VIEW_RESOURCES
                .getResource(factory, intermediateTimerEvent)
                .build(false);
    }

    @Override
    public Glyph getGlyph(final Class<? extends BaseThrowingIntermediateEvent> type) {
        return GLYPHS.get(type);
    }
}
