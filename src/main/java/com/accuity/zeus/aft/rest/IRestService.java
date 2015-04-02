package com.accuity.zeus.aft.rest;

import java.net.URI;

import com.accuity.domain.AbstractSerializable;

public interface IRestService {
	
	Object fetchAndDeserializeXml(URI uri, Class<? extends AbstractSerializable> returnClass);

}