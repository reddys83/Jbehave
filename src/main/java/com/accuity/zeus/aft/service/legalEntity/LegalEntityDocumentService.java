package com.accuity.zeus.aft.service.legalEntity;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accuity.domain.legalEntity.LegalEntities;
import com.accuity.domain.legalEntity.LegalEntity;
import com.accuity.zeus.aft.rest.uri.IUriBuilder;
import com.accuity.zeus.aft.service.AbstractDocumentService;
import com.accuity.zeus.aft.service.IDocumentService;

@Service
public class LegalEntityDocumentService extends AbstractDocumentService<LegalEntity, LegalEntities> implements IDocumentService<LegalEntity> {

	@Autowired
	private IUriBuilder searchUriBuilder;

	public LegalEntityDocumentService() {
		super(LegalEntity.class, LegalEntities.class);
	}
	
	@Override
	public LegalEntity getArbitraryEntity(String entity) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("entity", entity);
		URI uri = searchUriBuilder.buildUriString("any", params);
		return getEntity(uri);
	}

	@Override
	public LegalEntity search(Map<String, String> params) {
		ensureRequiredFieldsAreSetInParamsMap(params);
		URI uri = searchUriBuilder.buildUriString(null, params);
		LegalEntities results = getSearchResults(uri);
		if (results.getResults().size() > 0) {
			return results.getResults().iterator().next();
		}
		return null;
	}

	@Override
	protected String getEntityName() {
		return LegalEntity.ENTITY_NAME;
	}

}
