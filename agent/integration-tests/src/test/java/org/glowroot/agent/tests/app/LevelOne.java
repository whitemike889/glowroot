/*
 * Copyright 2011-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.glowroot.agent.tests.app;

public class LevelOne {

    private final RuntimeException exception;

    public LevelOne() {
        this(null);
    }

    public LevelOne(RuntimeException e) {
        this.exception = e;
    }

    // this method corresponds to LevelOneAspect
    public void call(Object arg1, Object arg2) {
        new LevelTwo(exception).call(arg1 + "x", arg2 + "x");
        new Simple().run();
        new Simple().run2();
    }
}
