package com.accuity.zeus.aft.service;

import java.util.Map;

import com.accuity.domain.AbstractSerializableRoot;

public interface IDocumentService<T extends AbstractSerializableRoot> {

	T getArbitraryEntity(String entity);
	
	T getArbitraryEntity(Map<String, String> params);
	
}
