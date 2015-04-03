package com.accuity.zeus.aft.rest.uri;

import java.net.URI;
import java.util.Map;

public interface IUriBuilder {

	URI buildUriString(String path, Map<String, String> params);

}