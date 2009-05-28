/*
 * Copyright (c) 2009 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.types.custom;

import java.util.List;

import com.mysema.query.types.expr.Expr;

/**
 * Custom provides base types for custom expresions with integrated
 * serialization patterns
 * 
 * @author tiwe
 * @version $Id$
 */
public interface Custom<T> {

    /**
     * Get the arguments of the custom expression
     * 
     * @return
     */
    List<Expr<?>> getArgs();

    /** 
     * Get the argument with the given index
     * 
     * @param index
     * @return
     */
    Expr<?> getArg(int index);

    /**
     * Get the serialization pattern for this custom expression
     * 
     * @return
     */
    String getPattern();

}
