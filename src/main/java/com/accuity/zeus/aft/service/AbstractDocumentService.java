package com.accuity.zeus.aft.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.accuity.domain.AbstractEntityCollection;
import com.accuity.domain.AbstractSerializableRoot;
import com.accuity.zeus.aft.rest.IRestService;

@SuppressWarnings("unchecked")
public abstract class AbstractDocumentService<T extends AbstractSerializableRoot, C extends AbstractEntityCollection<T>> implements IDocumentService<T> {

	private static final Logger log = Logger.getLogger(AbstractDocumentService.class);
	
	@Autowired
	private IRestService restService;
	
    private Class<T> returnClass;

    private Class<C> resultsClass;

    protected AbstractDocumentService() { }

    protected AbstractDocumentService(Class<T> returnClass) {
        this.returnClass = returnClass;
    }

    protected AbstractDocumentService(Class<T> returnClass, Class<C> resultsClass) {
        this.returnClass = returnClass;
        this.resultsClass = resultsClass;
    }

	protected abstract String getEntityName();
	
	protected T getEntity(URI uri) {
		if (uri != null) {
			log.info(uri.toString());
		}
		T returnObject = (T) restService.fetchAndDeserializeXml(uri, returnClass);
		log.info(returnObject);
		return returnObject;
	}

	protected C getSearchResults(URI uri) {
		if (uri != null) {
			log.info(uri.toString());
		}
		C returnObject = (C) restService.fetchAndDeserializeXml(uri, resultsClass);
		log.info(returnObject);
		return returnObject;
	}

	protected void ensureRequiredFieldsAreSetInParamsMap(Map<String, String> params) {
		if (params == null) {
			params = new HashMap<String, String>();
		}
		if (!params.containsKey("entity")) {
			params.put("entity", getEntityName());
		}
		if (!params.containsKey("start")) {
			params.put("start", "1");
		}
		if (!params.containsKey("count")) {
			params.put("count", "1");
		}
	}
	
}
