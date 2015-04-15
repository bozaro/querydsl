/*
 * Copyright 2011, Mysema Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.querydsl.core.serialization;

import java.util.Map;

import org.junit.Test;

import com.querydsl.core.support.SerializerBase;
import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;

public class SerializerBaseTest {

    @Test
    public void test() {
        DummySerializer serializer = new DummySerializer(new JavaTemplates());
        StringPath strPath = Expressions.stringPath("str");
        // path
        serializer.handle(strPath);
        // operation
        serializer.handle(strPath.isNotNull());
        // long path
        serializer.handle(new PathBuilder<Object>(Object.class, "p").getList("l", Map.class).get(0));
        // constant
        serializer.handle(ConstantImpl.create(""));
        //  custom
        serializer.handle(ExpressionUtils.template(Object.class, "xxx", ConstantImpl.create("")));
    }

}

class DummySerializer extends SerializerBase<DummySerializer> {

    public DummySerializer(Templates templates) {
        super(templates);
    }

    @Override
    public Void visit(SubQueryExpression<?> query, Void context) {
        return null;
    }

    @Override
    public Void visit(FactoryExpression<?> expr, Void context) {
        return null;
    }

    @Override
    public Void visit(ParamExpression<?> expr, Void context) {
        return null;
    }

}
