package com.orchestra.interfaces;

import com.orchestra.enums.Type;

/*
 * A worklet is a unit of work or a job which needs to be performed in a workflow.
 * Worklets allow the user to define the work.
 * 
 */
public interface Worklet {

	String workletId();

	Type workletType();

	Command command();
}
