/*
 * Copyright (c) 2009 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.types.path;

import com.mysema.query.types.Grammar;
import com.mysema.query.types.expr.EBoolean;
import com.mysema.query.types.expr.EString;

/**
 * PString represents String typed paths
 * 
 * @author tiwe
 * 
 */
public class PString extends EString implements Path<String> {
    private EBoolean isnull, isnotnull;
    private final PathMetadata<?> metadata;

    public PString(PathMetadata<?> metadata) {
        this.metadata = metadata;
    }

    public PString(String var) {
        this(PathMetadata.forVariable(var));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Path ? ((Path<?>) o).getMetadata().equals(metadata)
                : false;
    }

    @Override
    public PathMetadata<?> getMetadata() {
        return metadata;
    }

    @Override
    public Path<?> getRoot() {
        return metadata.getRoot() != null ? metadata.getRoot() : this;
    }

    @Override
    public int hashCode() {
        return metadata.hashCode();
    }

    @Override
    public EBoolean isNotNull() {
        if (isnotnull == null) {
            isnotnull = Grammar.isNotNull(this);
        }
        return isnotnull;
    }

    @Override
    public EBoolean isNull() {
        if (isnull == null) {
            isnull = Grammar.isNull(this);
        }
        return isnull;
    }
}