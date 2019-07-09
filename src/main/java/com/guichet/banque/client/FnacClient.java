package com.guichet.banque.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="guichet-api",url="${fnac.api.url}")
public interface FnacClient {
	
	

}
