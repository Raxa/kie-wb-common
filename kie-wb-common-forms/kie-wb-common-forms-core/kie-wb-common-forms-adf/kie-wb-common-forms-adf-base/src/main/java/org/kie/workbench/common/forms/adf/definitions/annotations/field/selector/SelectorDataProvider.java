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

package org.kie.workbench.common.forms.adf.definitions.annotations.field.selector;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation to specify the source of the data on selector fields
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface SelectorDataProvider {

    /**
     * Defines the type of provider
     */
    public enum ProviderType {
        /**
         * The provider is available on client-side.
         */
        CLIENT("local"),
        /**
         * The provider is available on server-side only.
         */
        REMOTE("remote");

        ProviderType(String code) {
            this.code = code;
        }

        protected String code;

        public String getCode() {
            return this.code;
        }

        @Override
        public String toString() {
            return code;
        }
    }

    /**
     * Type of the data provider
     */
    ProviderType type();

    /**
     * Qualified name of the data provider class.
     */
    String className();
}
